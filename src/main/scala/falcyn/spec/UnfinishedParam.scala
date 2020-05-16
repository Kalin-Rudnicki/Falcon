package falcyn.spec

import scala.language.implicitConversions

import scalaz.Scalaz._

import falcyn.parsing.Validated
import falcyn.parsing.Validated._
import falcyn.parsing.types._

class UnfinishedParam[+T] private[spec](converter: Converter[String, T]) {
  
  def validate(validator: Validator[T], onInvalid: OnInvalid[T]): UnfinishedParam[T] =
    new UnfinishedParam[T](
      (name, arg) =>
        converter(name, arg).flatMap(
          res =>
            validator(name, res).fold[Validated[T]](
              Valid[T](res),
              Invalid(onInvalid(name, res))
            )
        )
    )
  
  def transform[T2](c: Converter[T, T2]): UnfinishedParam[T2] =
    new UnfinishedParam[T2](
      (name, arg) =>
        converter(name, arg).flatMap(
          res =>
            c(name, res)  
        )
    )
  
}

object UnfinishedParam {
  
  def string: UnfinishedParam[String] =
    new UnfinishedParam[String](
      (_, str) =>
        Valid[String](str)
    )
  
}
