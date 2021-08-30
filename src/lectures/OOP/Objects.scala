package lectures.OOP

// scala does not have class level functionality like in Java
object Objects extends App {
  // you can define values, var and methods in an object
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    //companion class
  }
  println(Person.N_EYES)

  // an object is a singleton instance
  // an object is a type and is its only instance
  // write objects and classes as the same name to separate instance functionality (class) and static functionality (object)
  // this is called companions class and object
  val mary = Person
  val john = Person
  println(mary == john) // true

  val Michelle = new Person("Michelle")
  val Phil = new Person("Phil")
  val bobbie = Person(Michelle, Phil) // calling the apply function within the Person object

  // scala applications
  // scala app = scala objects with a
  // def main(args: Array[String]): Unit
  // either have extends App or within execuatble code do
  // def main(args: Array[String]): Unit = { code block }


}
