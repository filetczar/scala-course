package exercises

// new, make generic
abstract class MyList[+A] {
  // method head: first element of the list
  // method tail = remainder of the list
  // method isEmpty
  // method add to return a new list with an element added
  // to String: returns string representation of a list
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: myTransformer[A,B]): MyList[B]
  def flatMap[B](transformer: myTransformer[A,MyList[B]]): MyList[B]
  def filter(predicate: myPredicate[A]): MyList[A]
  // for flat map need a concatenation function

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException // throws not implemented error
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: myTransformer[Nothing,B]): MyList[B] = Empty
  def flatMap[B](transformer: myTransformer[Nothing,MyList[B]]): MyList[B] = Empty
  def filter(predicate: myPredicate[Nothing]): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: myPredicate[A]): MyList[A] =
    if(predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: myTransformer[A,B]): MyList[B] =
    new Cons(h = transformer.transform(h), t.map(transformer))

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: myTransformer[A,MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

}

object listTest extends App {
  val listofInt: MyList[Int] = new Cons( 1, new Cons(2, new Cons(3, Empty)))
  val listStrings: MyList[String] = new Cons("Phil", new Cons("Azar", Empty))
  val anotherInt: MyList[Int] = new Cons( 4, new Cons(5, new Cons(6, Empty)))
  println(listofInt.head)
  println(listStrings.toString)
  println(listofInt.map(new myTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }))

  println(listofInt.filter(new myPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }))

  println(listofInt ++ anotherInt)

  println(listofInt.flatMap(new myTransformer[Int, MyList[Int]]  {
    override def transform(element: Int): MyList[Int] = new Cons(element, new Cons(element+1, Empty))
  }))
}

trait myPredicate[-T] {
  def test(element: T): Boolean
}

trait myTransformer[-A, B] {
  def transform(element: A): B
}

// takeways
/*
private, protected and public
derive classes can override methods
reuse parents/ fields with super
prevent ineheritance with final and
 */
