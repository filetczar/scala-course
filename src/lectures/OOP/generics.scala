package lectures.OOP

object generics extends App {

  class MyList[A] {
    // square brackets denote a generic type

    def add[B >: A](element: B): MyList[B] = ???
    //if I add a type B, which is a super of A (>:) then the list becomes a list of B
  }

  val listofInts = new MyList[Int]
  val listofStr = new MyList[String]

  class myMap[Key, Value]

  trait traitGeneric[A]

  //generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyList = MyList.empty[Int]

  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // yes List[Cat] extends List[Animal], this is called covariance
  class CovariantList[+A]
  val _animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // list of animals athat are sub class cats
  // what happens wehn I add a dog
  // animalList.add(Dog)

  // invariance, does not extend sub classes
  class InvarianceList[A]
  val invariantAnimal: InvarianceList[Animal] = new InvarianceList[Animal]

  // contravariance

  class ContravariantList[-A]
  val contravarianceList: ContravariantList[Cat] = new ContravariantList[Animal]

  //bounded types
  // class cage only receives types sub classes of Animal
  /* class Cage[A <: Animal](animal: A)
  val _cage = new Cage(new Dog)
  class Car
  val newCage = new Cage(new Car) // this will error bc car is not a sub class of animal
*/
  // expand MyList into a generic



}
