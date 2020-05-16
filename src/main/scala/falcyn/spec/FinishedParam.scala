package falcyn.spec

import scala.language.implicitConversions

import scalaz.Scalaz._

import falcyn.parsing.Validated
import falcyn.parsing.Validated._
import falcyn.parsing.types._

class FinishedParam[+T, Env] private[spec](converter: Converter[String, T], completion: Completor[Env]) {
  
  def complete(name: String, env: Env, arg: String): Option[Completed] =
    completion.map(_.apply(name, env, arg))
  
  def apply(name: String, str: String): Validated[T] =
    converter(name, str)
  
}
