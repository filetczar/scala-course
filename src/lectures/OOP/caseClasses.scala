package lectures.OOP

object caseClasses extends App {

  /* great at defining default objects */

  case class Person(name: String, age: Int)
  // 1. class params are fields
  val jim = new Person("Jim", age= 34)
  println(jim.name)

  // 2. sensible to string
  println(jim.toString)

  // 3. equals and hashcode implemented out of box

  val jim2 = new Person(name = "Jim", age = 34)
  println(jim == jim2) // true, would be false if not case class

  // 4. have copy methods

  val jim3 = jim.copy()
  // you can also create new using copy
  val jim45 = jim.copy(age= 45)
  println(jim3)
  println(jim45)

  // can create companion objects

  val thePerson = Person
  val mary = Person("Mary", 23)
  println(mary)

  // case classes are serializable for distributed compute
  // case classes have extractor patterns  and can be used in pattern matching

  // case objects
  case object UnitedKingdom {
    def name: String = "The UK of GB and Northern Ireland"
  }
}
