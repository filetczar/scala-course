package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " first computing " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }
println(factorial(10))
/* stack overflow error: little memory */
// tail recursion = use a recursive call as the last expression
  def factorial_two(n: Int): BigInt = {

    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <=1 ) accumulator
      else factHelper(x -1, x * accumulator)
    }
    factHelper(x = n , accumulator = 1)
  }
  // println(factorial_two(n=5000))
  // 1. concatenate a string n times
  // 2. is prime as tail rec
  // 3. fibonacci as tail rec

  @tailrec
  def concan(s: String, n: Int, accumulator: String): String = {
    if(n <= 0) accumulator
    else concan(s, n-1, s + accumulator)
  }
  println(concan(s="hello", n =3, accumulator= ""))

  def isPrimeTailRec(n: Int): Boolean = {
    def aux(t: Int, stillPrime: Boolean): Boolean = {
      if (!stillPrime) false
      else if (t <= 1) true
      else aux(t - 1, n % t != 0 && stillPrime)
    }
    aux(n/2, stillPrime =true)

    }

  def fibonnaci_tail_rec(n: Int): Int = {
    def aux(i: Int, acc1: Int, acc2: Int): Int = {
      if(i >= n ) acc1
      else aux(i+ 1, acc1 + acc2, acc1)
    }
    if(n <= 2) 1
    else aux(2,1,1)

  }
}
