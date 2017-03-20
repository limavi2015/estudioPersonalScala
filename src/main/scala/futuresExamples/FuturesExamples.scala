package futuresExamples

import scala.concurrent.{ExecutionContext, Future, Await}
import scala.concurrent.duration._
import ExecutionContext.Implicits.global

class FuturesExamples {

  def runFutures={
    println("*** runFutures ***")

    val f: Future[Int] = Future{
      Thread.sleep(10000)
      2
    }

    println(Await.result(f,12.seconds))
  }
}
