package catsExamples

class CatsExamples {
  import cats._, cats.instances.all._
  import cats._
  import cats.instances.all._

  def runCatsExamples={
    functorExample


  }


  private def functorExample={
    println("** functor")
    println("Un Functor es una clase de tipo obicua que implica tipos que tienen un 'agujero', es decir, tipos que tienen la forma F [?], Como Opción, Lista y Futuro. (Esto es en contraste con un tipo como Int que no tiene agujero, o Tuple2 que tiene dos agujeros (Tuple2 [?,?])). La categoría Functor implica una sola operación, denominada map:")

    // map
    val len: String=> Int = _.length
    println("map: " + Functor[Option].map(Some(1))(x => x*13))
    println("map: " + Functor[Option].map(Some(1))(x => x.toString))
    println("map: " + Functor[List].map(List("qwer", "adsfg"))(len))
    println("map: " + Functor[Option].map(Some("adsf"))(_.length))

    //`Lift` parece un 'map`, pero como una función pura. Podemos utilizar Functor para "elevar" una función de A => B a F [A] => F [B]:
    val lenOption: Option[String] => Option[Int] = Functor[Option].lift(len)
    println("lift: " + lenOption(Some("abcd")))

    //fproduct Functor proporciona una función fproduct que empareja un valor con el resultado de aplicar una función a ese valor.
    val source = List("a", "aa", "b", "ccccc")
    println("fproduct: " + Functor[List].fproduct(source)(len).toMap)

    //compose Dado cualquier functor F [_] y cualquier functor G [_] podemos crear un nuevo functor F [G [_]]
    val listOpt = Functor[List] compose Functor[Option]
    val w: List[Option[Int]] = listOpt.map(List(Some(1), None, Some(3)))(_ + 1)

    val optList = Functor[Option] compose Functor[List]
    val x: Option[List[Int]] =  optList.map(Some(List(1, 2, 3)))(_ + 1)

    val listOptList = listOpt compose Functor[List]
    val y: List[Option[List[Int]]] = listOptList.map(List(Some(List(1,2)), None, Some(List(3,4))))(_ + 1)

    println(w)
    println(x)
    println(y)

  }
}
