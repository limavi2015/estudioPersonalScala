package traitExamples

class traitExamples {
  def runTraitExamples(): Unit ={
    println("*** Traits ***")

    println("A trait encapsulates method and field definitions, which can then be reused by mixing them into classes. Unlike class inheritance, in which each class must inherit from just one superclass, a class can mix in any number of traits.")

    //example1
    val w = new valorImprimible(3)
    w.print()

    //example2
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)
    println(p1.isEqual(p2)) // no pasa el asInstanceOf
    println(p1.isEqual(p3)) // pasa isInstanceOf porque ambos son de tipo Point y asInstanceOf porque en p3 3==3
    println(p1.isEqual(2))  // no pasa el isInstanceOf
  }
}

//trait example1
trait Printable extends Any {
  def print() = println(this)
}
class valorImprimible(valuex: Int) extends Printable


// trait example2
trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)
}
class Point(xc: Int, yc: Int) extends Equal {
  var x = xc
  var y = yc
  def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}
/*
  Obj.isInstanceOf - Para comprobar que el Tipo de obj y Point son iguales no lo son.
  Obj.asInstanceOf - significa casting exacto tomando el obj type y devuelve el mismo obj que Point type.
*/