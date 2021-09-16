package lectures.OOP

object exceptions extends App {
  // throwing and catching exceptions

  val x: String = null
 // val a: String = throw new NullPointerException
  // this throws: throw new NullPointerException
  // exceptions and errors are extensions of the Throwable class

  // catching
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int!")
    else 42

  val potnetialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught runtime exception")
  } finally {
    // code that will get executed no matter what
    println("Finally")
  }
// finally is only for sideeffects (loggings, printing, etc.)

  // 3. how to define your own exceptions

  class MyException extends Exception

  /*
  1. crash program with an out of memory error
  2. crash with a stack overflow error
  3. PocketCalculator class:
      - add,
      - mulitply
      - divide
      - subtract
      throw custom exception if something add exceeds Int.MAX_VALUE
      throw custom excpetion if subtract exceeds Int.MIN_VALUE
      throw
   */

  // out of memory error
  // val array = Array.ofDim(Int.MaxValue)

  // stack overflow error
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

class PocketCalculator(val x: Int, val y: Int) {
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException

  def add(x: Int = this.x, y: Int = this.y ): Int = {
   val result = x + y
    if( x > 0 && y > 0 && result < 0) throw new OverflowException
    else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
    else result
  }

  def subtract(x: Int = this.x, y: Int = this.y): Int  = {
      val result = x -y
    if ( x > 0 && y < 0 && result < 0) throw new OverflowException
    else if ( x < 0 && y > 0 && result > 0) throw new UnderflowException
    else result
  }

  def divide(x: Int = this.x, y: Int = this.y): Int = {
    if(y == 0) throw new MathCalculationException
    else x / y
  }
}
 val calc = new PocketCalculator(x = 5, y = 10)
 println(calc.add())

}
