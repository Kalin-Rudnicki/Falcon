package falcyn.parsing

object types {
  
  type Converter[I, O] =
    (String, I) => Validated[O]
  
  type Validator[T] =
    (String, T) => Boolean
  
  type OnInvalid[T] =
    (String, T) => String
  
}
