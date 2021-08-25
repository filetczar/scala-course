package lectures.basics


// name, parameters, return type
object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def parameterLess(): Int = 42
  println(parameterLess())
  println(parameterLess)

  def aRepeatedFunc(a: String, n: Int): String = {
    if (n == 1) a
    else a + aRepeatedFunc(a, n - 1)
  }
  println(aRepeatedFunc(a = "hello", n = 3))
  // when you need loops, use recursion instead!

  def aFuncWithSideEffects(a: String): Unit = {
    println(a)
  }

  def aBigFunc(n: Int): Int = {
    def auxFunc(a: Int, n: Int): Int = {
      n + a
  }
    auxFunc(n, n * 3)
}

  /* 1. greeting function for name and age
  2. factorial function n!
  3. Fibonacci Function f(n) = f(n-1) + f(n+2)
  4. Test if a number is prime
   */

  def greeting(name: String, age: Int): String = {
    "Hello, my name is " + name + " and I am " + age + " years old!"
  }
  println(greeting(name = "Phil", age = 31))
  def factorial(n: Int): Int = {
    if ( n <= 0 ) 1
    else n * factorial(n-1)
  }

  println(factorial(n = 6))
  println(factorial(n=4))

  def fibonnaci(n: Int): Int = {
    if ( n <= 2 ) 1
    else fibonnaci(n-1) + fibonnaci(n-2)
  }
  println(fibonnaci(3))

  def primeTest(x: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else x % t != 0 && isPrimeUntil(t-1)
    }
    isPrimeUntil(x / 2)
  }
}
