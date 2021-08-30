package lectures.OOP

object OObasics extends App {

  val person = new Person(name = "Phil", age = 30)
  println(person)
  println(person.age)
  println(person.x)
  println(person.greet(name = "Daniel"))

  val persontwo = new Person(name = "John")
  println(persontwo.age) // will print 0 due to the default age
  val author = new Writer("Charles", "dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(novel.authorAge)

  val counter = new Counter(0)
  counter.inc()
  println(counter.x)

}
// constructor is defined in () with paramters are not fields that can be called unless they have val/var
class Person(name: String, val age: Int)  {
  //body
  val x = 2
  // a println would run
  // this grabs the class field, similar to self
  def greet(name: String): Unit = println(s"${this.name} says hi to $name")

  // multiple constructors
  // gives a default
  def this(name: String) = this(name, 0)


}

/*
Writer: first name, last name, year with method given their full name
Novel: name, year of the release, author
- author age at year of release
- isWrittenBy(author)
- copy is a new instance of the novel

Counter: inputs an int
method: current count
method to add or decrease with a new counter
method to recieve amount
 */

class Writer(val firstName: String, val lastName: String,  val birthYear: Int) {
  def fullName(): String = s"${this.firstName} ${this.lastName}"
}

class Novel(val name: String, val releaseYear: Int, author: Writer) {

  val authorAge: Int = this.releaseYear - author.birthYear

  def isWrittenBy(): Unit = {
    println(author.fullName())
  }

  def copy(newYear: Int): Novel = {
    new Novel(this.name, newYear, this.author)
  }

}

class Counter(val x: Int) {
  def currentCount(): Int = this.x

  def increase(by: Int = 1): Counter = new Counter(x + by)
  def decrease(by: Int = 1): Counter = new Counter(x - by)

  def inc(n: Int =1 ): Counter = {
    if (n <= 0) this
    else increase(by=n-1)
}

  def dec(n: Int =1): Counter = {
    if (n <= 0) this
    else decrease(by=n-1)
  }

}
