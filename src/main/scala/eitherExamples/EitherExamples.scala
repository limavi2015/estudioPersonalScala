package eitherExamples

class EitherExamples {

  def runEitherExamples={
    val l: Either[String,String] = Left("wrong")
    val r: Either[String,String] = Right("Right")

    l.fold(lv => println(lv), lr => println(lr))
    r.fold( lv => println(lv), lr => println(lr))
  }


}
