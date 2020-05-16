package falcyn.parsing

sealed trait Validated[+T] {
  
  def map[T2](f: T => T2): Validated[T2]
  
  def flatMap[T2](f: T => Validated[T2]): Validated[T2]
  
}

object Validated {
  
  case class Valid[T](value: T) extends Validated[T] {
    
    override def map[T2](f: T => T2): Validated[T2] =
      Valid[T2](f(value))
  
    override def flatMap[T2](f: T => Validated[T2]): Validated[T2] =
      f(value)
    
  }
  
  case class Invalid(message: String) extends Validated[Nothing] {
    
    override def map[T2](f: Nothing => T2): Validated[T2] =
      this
  
    override def flatMap[T2](f: Nothing => Validated[T2]): Validated[T2] =
      this
    
  }
  
}

object Test {
  
  import Validated._
  
  val t1: Validated[Int] =
    Valid[Int](5)
  
  val t2: Validated[Int] =
    Invalid("Test")
  
}
