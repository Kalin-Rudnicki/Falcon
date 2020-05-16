package falcyn.parsing

object types {
  
  type Converter[I, O] =
    (String, I) => Validated[O]
  
  type Validator[T] =
    (String, T) => Boolean
  
  type OnInvalid[T] =
    (String, T) => String
  
  // TODO (KR) : Can I make it do error messages?
  //           : Left(str) => Error message
  //           : Right(list) => Options
  // TODO (KR) : It would be nice to be able to pass it everything it knows about so far
  //           : (Only children though)
  //           : A { B, C }, B shouldnt know about A or C
  type Completor[Env] =
    Option[(String, Env, String) => Completed]
  
  type Completed =
    Either[String, List[String]]
  
}
