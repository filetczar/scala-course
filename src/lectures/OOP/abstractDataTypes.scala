package lectures.OOP

object abstractDataTypes extends App {
  // abstracts: Leave classes or methods blank

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }
  // abstratc classes can be initiated
  // these are made to be extended latter

  class Dog extends Animal  {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // traits are abstract and can be interited

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferred_meal: String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Crocodile"
    def eat: Unit = "nom nom nom"
    def eat(animal: Animal): Unit = println(s"I am a croc and eating a ${animal.creatureType}")
  }

  // can add more classes with more "with X with Y.."
  //traits vs abstarct classes
  // both can have blank and defined values/methods
  // traits do not have a constructor parameters
  // you can only extend one class, but can inherit multiple traits
  // traits are behaviors, but an abstract class is a type of thing

  // type hierarchy
}
