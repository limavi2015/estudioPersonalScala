package collectionsExamples

class CollectionsExamples {

  def runExamplesCollections(): Unit ={
    println("*** Collections ***")
    println("Scala has a rich set of collection library. Collections are containers of " +
      "things. Those containers can be sequenced, linear sets of items like List, Tuple, Option, Map, etc.")
    listExample()
    setExample
    mapExample
    tupleExample
    optionExample
    iteratorExample
  }

  private def listExample(): Unit ={
    println("*** listExample")
    val fruit: List[String] = List("apples", "oranges", "pears")
    val nums: List[Int] = List(1, 2, 3, 4)
    val dim: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
    val empty: List[Nothing] = List()
    val empty2 = Nil

    println(fruit)
    println(nums)
    println(dim)
    println(empty)
    println(empty2)
  }

  private def setExample={
    println("*** setExample:")
    val fruit = Set("apples", "oranges", "pears")
    val nums: Set[Int] = Set()
    println( "Head of fruit : " + fruit.head )
    println( "Tail of fruit : " + fruit.tail )
    println( "Check if fruit is empty : " + fruit.isEmpty )
  }

  private def mapExample={
    println("*** mapExample")
    val colors1 = Map("red" -> "#FF0002", "azure" -> "#F0FFFF", "peru" -> "#CD853F")
    val colors2 = Map("red2" -> "#FF0000", "blue" -> "#0033FF", "yellow" -> "#FFFF00")

    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )

    if( colors.contains( "azure" )) {
      println("azure key exists with value :"  + colors("azure"))
    }
  }

  private def tupleExample={
    println("*** tupleExample")
    val t3: (Int, String, Boolean) = (1, "hello", true) //tuple3
    val t4 = new Tuple4(true, 1, 3, "hello") //tuple 4
    val t22=(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22) //tuple max 22
    println("t3: " + t3._1 +","+ t3._2 + "," + t3._3)
    println("t4: " + t4)
  }

  private def optionExample={
    println("*** optionExample")
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    val valOption: Option[String] =capitals.get( "France" )
    println(valOption.getOrElse("esto se imprime si la variable venia en None"))
  }

  private def iteratorExample={
    println("*** iteratorExample")
    println("An iterator is not a collection, but rather a way to access the elements of a collection one by one")
    val it = Iterator("xx", "yy", "zz")
    val itb = Iterator(20,40,2,50,99, 90)
    while (it.hasNext){
      println(it.next())
    }
    println("Maximum valued element " + itb.max )
  }
}
