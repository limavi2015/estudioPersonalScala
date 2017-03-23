package futuresExamples

import scala.concurrent.{ExecutionContext, Future, Await}
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.{Success, Failure, Try}

class FuturesExamples {
  def runFutures={
    println("*** runFutures ***")
    //futuroBloqueante
    futuroNoBloqueante
    constanteDentroDeUnFuturo
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


  private def constanteDentroDeUnFuturo ={
    println("** ConstanteDentroDeUnFuturo,  Llamarlos no gasta un thread, a diferencia de Future { ... }")
    val constante1="Red"
    Future.failed(new Exception)
    Future.successful(constante1)
  }

}



/*
http://slides.com/miguelvila/futures-en-scala#/4/24

Para ejecutar futuros de la librería estándar se requiere tener un ExecutionContext, que es algo que ejecuta
código típicamente en un pool de threads.s de la librería estándar se requiere tener un ExecutionContext,
que es algo que ejecuta código típicamente en un pool de threads.

Scala provee un contexto de ejecución global (que se utiliza haciendo import scala.concurrent.ExecutionContext.
Implicits.global), pero para aplicaciones de verdad se sugiere tener varios aislados.
 */