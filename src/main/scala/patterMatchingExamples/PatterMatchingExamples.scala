package patterMatchingExamples

class PatterMatchingExamples {

  def runPatterMatchingExamples()={
    println("*** PatterMatching ***")
    println(matchTest(3))
    println(matchTest2("two"))
    println(matchTest2(1))
  }

  private def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  private def matchTest2(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }
}
