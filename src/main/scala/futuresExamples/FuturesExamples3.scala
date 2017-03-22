package futuresExamples

import scala.concurrent.Future

class FuturesExamples3 {

  case class CauseException{"descripcion": String}
  trait TraitResult
  case class SuccessfulFileExecution(fileId: Int) extends TraitResult
  case class FailedFileExecution(fileId: Int, cause: CauseException) extends TraitResult

  def runFutures3={
    println("*** runFutures3 ***")
    //Recover y RecoverWith Sirven para convertir un error del futuro en un valor
    ejercicioRecover
    ejercicioRecoverWith

    Thread.sleep(12000)
    println("*** termino la ejecucion runFutures3 ***")
  }

  private def ejercicioRecover={
    println("** ejercicio Recover")
    //recover: para transformar el error "síncronamente"
    val f1 = Future(SuccessfulFileExecution(1))
    val f2 : Future[TraitResult]= f1.recover {
      case fee: CauseException => FailedFileExecution(1, fee)
    }

  }

  private def ejercicioRecoverWith={
    println("** ejercicio RecoverWith")
    //recoverWith: para transformar el error "asíncronamente"

  }





}
