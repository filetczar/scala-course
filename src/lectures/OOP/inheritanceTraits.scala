package lectures.OOP

object inheritanceTraits extends App{

  class Animal {
    // fully inherited, it is public
    def eat: Unit = println("nom nom")
    // only available in class
    private def meow(): Unit = println("Meow")
    // this can be called inside the extended sub class, but not called directly
    protected def growl: Unit = println("growl")
  }
  // ineritance to a sub class
  class Cat extends Animal {
    def angry: Unit= growl
  }
  val marley = new Cat
  marley.eat
  // marley.meow //is private, does not extend

  // constructors
  // extending a class with parameters needs to have all the parameters
  // here Adult inherits from the super class Person
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overriding

  class Dog extends Animal {
    override def growl() = println("I dont growl?!")
  }

  val Zoey = new Dog
  Zoey.growl

  // you can also override vals
  // superclass
  // to refer to a super class method in a subclass call (super.)

  // preventing overrides
  // if you prefix any of your methods with final, then subclassed cannot override that method
  // you can also prevent inheritance on the class by adding final to the class instance
  // you can also seal the class, which prevents extension to other files
  // ex: sealed class Animal { }
}
