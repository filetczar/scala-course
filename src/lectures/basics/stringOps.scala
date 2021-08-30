package lectures.basics

object stringOps extends App {

  val str: String = "Hello, I am learning Scala"
  // index at 0
  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala Specific

  // s interpolators

  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age +1} years old."
  println(anotherGreeting)

  // f interpolators
  val speed = 1.234f
  val myth = f"$name%s can eat $speed%2.2f burgers" // 2 character and 2 decimals points
  println(myth)
  //%s means string, %2.2f is a 2 character followed by 2 decimals
  // types in the f interpolator must match the value defined

  // raw interpolator
  println("This is a \n newline")
  val escaped: String = "This is a \n newline"
  println(escaped)
  println(raw"$escaped")


}
