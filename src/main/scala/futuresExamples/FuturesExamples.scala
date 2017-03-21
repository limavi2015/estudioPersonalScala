package futuresExamples

import scala.concurrent.{ExecutionContext, Future, Await}
import scala.concurrent.duration._

import ExecutionContext.Implicits.global
import scala.util.{Success, Failure, Try}

class FuturesExamples {
  val futuro1String: Future[String] = Future{
    Thread.sleep(10000)
    "pink"
  }

  val futuro2Num: Future[Int] = Future{
    Thread.sleep(10000)
    3
  }

  def runFutures={
    println("*** runFutures ***")
    //futuroBloqueante
    //futuroNoBloqueante
    forComprehensions
    Thread.sleep(12000)
    println("*** termino la ejecucion runFutures ***")
  }

  private def futuroNoBloqueante={
    println("** Futuro No Bloqueante")
    futuro1String onComplete {
      case Success(result) =>println("OnComplete Success:" + result)
      case Failure(e) => println("OnComplete Failure: " + e.getMessage)
    }
    println("El programa continua en ejecución")
  }

  private def futuroBloqueante={
    println("** Futuro Bloqueante")
    println("resultado del Await: " + Await.result(futuro1String,12.seconds))
    println("El programa llega a este punto cuando el futuro bloqueante ha terminado")
  }

  private def forComprehensions={
    println("** for Comprehensions, tampoco es bloqueante")
   for {
      f1 <- futuro1String
      f2 <- futuro2Num
   }yield (println("**El resultado del for Comprehensions: "+ "f1:" +f1 +", f2:"+ f2))
    println("El programa continua en ejecución 2")
  }
}



/*Para ejecutar futuros de la librería estándar se requiere tener un ExecutionContext, que es algo que ejecuta
código típicamente en un pool de threads.s de la librería estándar se requiere tener un ExecutionContext,
que es algo que ejecuta código típicamente en un pool de threads.

Scala provee un contexto de ejecución global (que se utiliza haciendo import scala.concurrent.ExecutionContext.
Implicits.global), pero para aplicaciones de verdad se sugiere tener varios aislados.
 */