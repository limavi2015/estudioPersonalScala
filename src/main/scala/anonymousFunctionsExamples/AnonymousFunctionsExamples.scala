package anonymousFunctionsExamples

class AnonymousFunctionsExamples {

  def runAnonymousFunctions () {
    println("*** runAnonymousFunctions ***")

    var userDir = () => { System.getProperty("user.dir") } //funcion anonima sin parametros

    val inc = (x:Int) => x+1 //inc variable es una función que se puede utilizar la forma habitual
    println(inc(7)-3)

    val mul = (x: Int, y: Int) => x*y
    println(mul(3, 4))


    funcion1QueRecibeUnaFuncion(() => "resultado de la funcion anonima" )

    println("Resultado de la funcion anonima que suma: " +funcion2QueRecibeUnaFuncion((x:Int,y:Int) => x+y))

    println("Resultado de la funcion anonima que multiplica: "  + funcion2QueRecibeUnaFuncion((x:Int,y:Int) => x*y))

    println("Resultado de la funcion que resta: "+ funcion2QueRecibeUnaFuncion(funcionResta))

    println(add1(42,13))
    println(add2(42,13))
    println(add3(42,13))
    println(add4(42,13))
  }

  private def funcion1QueRecibeUnaFuncion(funcionx:()=>String) ={
    println(funcionx.apply())
  }

  private def funcion2QueRecibeUnaFuncion(funcionx:(Int,Int) => Int) ={
    val num1=3
    val num2=5
    funcionx(num1,num2)
  }

  private def funcionResta(x:Int,y:Int)={x-y }


  def add1(x:Int, y:Int) = x + y     //method
  val add2 = (x:Int, y:Int) => x + y //anonymous function
  val add3:(Int,Int)=>Int = _ + _    //alternate way
  val add4 = (_ + _):(Int,Int)=>Int  //alternate way, rare

}
