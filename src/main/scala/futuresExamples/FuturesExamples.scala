package futuresExamples

import scala.concurrent.{ExecutionContext, Future, Await}
import scala.concurrent.duration._

import ExecutionContext.Implicits.global
import scala.util.{Success, Failure, Try}

class FuturesExamples {
  val futuro1: Future[String] = Future{
    Thread.sleep(10000)
    "pink"
  }

  def runFutures={
    println("*** runFutures ***")
    futuroNoBloqueante
    futuroBloqueante
  }

  private def futuroNoBloqueante={
    println("** Futuro No Bloqueante")
    futuro1 onComplete {
      case Success(result) =>println("resultado del onComplete:" + result)
      case Failure(e) => println("Error: " + e.getMessage)
    }
    println("El programa continua en ejecución")
  }

  private def futuroBloqueante={
    println("** Futuro Bloqueante")
    println("resultado del Await: " + Await.result(futuro1,12.seconds))
  }
}
