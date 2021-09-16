package lectures.OOP

object anonymous extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class to the compiler
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahaha")
  }
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")

  }
  val Jim = new Person(name = "Jim") {
    override def sayHi: Unit = println(s"My name is not Ben")

  }

  // exercises
  trait myPredicate[-T] {
    def test(element: T): Boolean
  }

  trait myTransformer[-A, B] {
    def transform(element: A): B
  }

  abstract class myList[+A]  {
    def map[B](transformer: myTransformer[A,B]): myList[B]
    def filter: myList[A]
    def flatMap[B](transformer: myTransformer[A,myList[B]]): myList[B]
    def filter(predicate: myPredicate[A]): myList[A]
  }


}
