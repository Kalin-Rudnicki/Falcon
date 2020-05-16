package falcyn.helpers

import falcyn.parsing.types._

object Completion {
  
  trait OneOf[T] {
  
    // TODO (KR) : Very rough first impression
    def options: List[T]
    
  }
  
  def oneOf[T](list: List[T]) = ???
  
  // TODO (KR) : Pattern?
  def matches(regex: String, msg: Option[String]) = ???
  
  def complete[Env](completion: Completor[Env]) = ???
  
  def isFile(existsParentNone: Any = "exists") = ???
  
  def isDir = ???
  
}
