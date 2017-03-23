import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global
import scala.concurrent

package object futuresExamples {
  val futuro1String: Future[String] = Future{
    Thread.sleep(10000)
    "pink" }

  val futuro2Num: Future[Int] = Future{
    Thread.sleep(10000)
    3
  }

  val futuroListString = Future{
    List("a","b","c","d","e")
  }

  val futuro2ListString = Future{
    List("f","g","h","i","j")
  }

  def devuelveListaFuturo()={
    futuro2ListString
  }

  val seqFuturesString: Seq[Future[String]] =Seq(
    Future{"orange"},
    Future{"black"},
    Future{"white"}
  )

  val listFuturesString: Seq[Future[String]] =List(
    Future{"orange"},
    Future{"black"},
    Future{"white"}
  )
}

