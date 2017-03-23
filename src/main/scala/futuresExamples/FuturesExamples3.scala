package futuresExamples

import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class FuturesExamples3 {

  case class CauseException(descripcion: String)
  trait TraitResult
  case class SuccessfulFileExecution(fileId: Int) extends TraitResult
  case class FailedFileExecution(fileId: Int, cause: CauseException) extends TraitResult

  val f2: Future[FailedFileExecution] = Future {
    Thread.sleep(8000)
    FailedFileExecution(1, CauseException("error"))
  }

  def runFutures3={
    println("*** runFutures3 ***")
    //Recover y RecoverWith Sirven para convertir un error del futuro en un valor
    ejercicioRecover
    ejercicioRecoverWith
    ejercicioSequence
    ejerciciotraverse

    Thread.sleep(12000)
    println("*** termino la ejecucion runFutures3 ***")
  }

  private def ejercicioRecover={
    println("** ejercicio Recover, para transformar el error síncronamente")
    val f3:Future[TraitResult] = f2.recover {
      case fee: CauseException => FailedFileExecution(1, fee)
    }
    f3.map(r=> println("Recover: " + r))
    println("codigo continua")
  }

  private def ejercicioRecoverWith= {
    println("** ejercicio RecoverWith, para transformar el error asíncronamente")
    val f3:Future[TraitResult] = f2.recoverWith {
      case _: CauseException => Future(FailedFileExecution(1, CauseException("error")))
    }
    f3.map(r=> println("RecoverWith: " + r))
    println("codigo continua")
  }

  private def ejercicioSequence={
    println("** ejercicioSequence ")
    val futuresSequenceString : Future[Seq[String]] = Future.sequence(seqFuturesString)
    val futuresSequenceString2: Future[Seq[String]] = Future.sequence(listFuturesString)
  }

  private def ejerciciotraverse={
    println("** ejerciciotraverse ")
    val futureList: Future[List[Int]] = Future.traverse((1 to 10).toList)(x => Future(x * 2))
    println(futureList)
  }



}


/*
http://slides.com/miguelvila/futures-en-scala#/4/24
*/