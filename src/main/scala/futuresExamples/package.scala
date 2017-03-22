import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

package object futuresExamples {
  val futuro1String: Future[String] = Future{
    Thread.sleep(10000)
    "pink" }

  val futuro2Num: Future[Int] = Future{
    Thread.sleep(10000)
    3
  }

  val listaFuturoString = Future{
    List("a","b","c","d","e")
  }

  val lista2FuturoString = Future{
    List("f","g","h","i","j")
  }

  def devuelveListaFuturo()={
    lista2FuturoString
  }
}
