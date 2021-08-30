package lectures.basics

object namevsvalue extends App {

  def callByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  def callByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)

  }
  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  // Why?
  // callByValue computes the value then executes function
  // callByName passes the parameter X => into the function and is executed within the function
  // byName does not evaluate until it is called in the internal function

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  // if x = infinite() -> error
  // if y = infinite() -? OK bc not called
}
