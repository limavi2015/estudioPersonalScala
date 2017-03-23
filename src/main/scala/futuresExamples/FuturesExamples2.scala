package futuresExamples

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

class FuturesExamples2 {

  def runFutures2={
    println("*** runFutures2 ***")
    ejercicioMap1
    ejercicioMap2.flatten.map(r=> println("ejercicioMap2: " + r))
    ejercicioFlatMap.map(r=> println("ejercicioConFlatMap: " + r))
    ejercicioforComprehensions
    Thread.sleep(12000)
    println("*** termino la ejecucion runFutures2 ***")
  }

  private def ejercicioMap1={
    println("** Ejercicio Map1")
    futuro1String.map(result=> println("Ejercicio Map1, el resultado del map: " + result))
    println("Ejercicio Map1, el codigo continua")
  }

  private def ejercicioMap2: Future[Future[List[String]]] = {
    println("** Ejercicio Map2")
    futuro2ListString.map { listaString1 =>
      devuelveListaFuturo()
    }
  }

  private def ejercicioFlatMap: Future[List[String]] = {
    futuro2ListString.flatMap { listaString1 =>
      devuelveListaFuturo()
    }
  }

  private def ejercicioforComprehensions={
    println("** Ejercicio for Comprehensions")
    for {
      f1 <- futuro1String
      f2 <- futuro2Num
    }yield (println("Ejercicio for Comprehensions, el resultado del for Comprehensions: "+ "f1:" +f1 +", f2:"+ f2))
    println("Ejercicio for Comprehensions, el programa continua en ejecución 2")
  }
}

/*
http://slides.com/miguelvila/futures-en-scala#/4/24
*/