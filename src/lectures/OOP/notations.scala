package lectures.OOP

object notations extends App {

  // if inside here, then
  class Person(val name: String, favoriteMovie: String, age: Int = 18) {
    def likes(movie: String): Boolean = movie == this.favoriteMovie

    def hangOutWith(friend: Person): String = s"${this.name} is hanging out with ${friend.name}"

    def unary_! : String = s"${this.name}, what the heck?"

    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is ${this.name} and I like ${this.favoriteMovie}!"

    def +(nickname: String): Person = new Person(name = s"${this.name} $nickname",
                                                  favoriteMovie= this.favoriteMovie,
                                                    age = this.age)


    def learns(thing: String): String = s"${this.name} is learning $thing"

    def learningScala(): String = this learns "Scala"

    def apply(n: Int): String = s"${this.name} has watched ${this.favoriteMovie} $n times"

    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

  }
  val mary = new Person(name= "Mary", favoriteMovie = "Inception", 30)
  println(mary.likes(movie = "Inception"))
  println(mary likes "Inception") // infix notation, this only works with methods with a similar parameter. Known as syntactic sugar

  // operators in Scala
  val tom = new Person("Tom", "Fight Club", 45)
  println(mary hangOutWith tom)
  // you can use + as a method name. It is valid
  // all operators are methods

  // prefix notation

  val x = -1 // negative sign is a unary operator
  val y = 1.unary_-
  println(x == y)

  println(!mary) // this calls the unary for not (!) defined in the function

  // postfix notation with methods that do not have arguments
  println(mary.isAlive)

  // apply method can be called from the class; mary(), tom()
  println(mary.apply())
  println(mary())
  /*
  1. overload the + operator that returns a new person with a nickname
  2. add age to the person with a unary_+ that adds age + 1
  3. add a learns method to learn something
    add a learnsScala method that calls learns in a postfix method
   4. apply mehtod with a number to be called how many times
   */
  // 1.
  println((mary + "the swimmer")())
  //2.
  println(+mary)
  // 3.
  println(mary.learningScala())
  // 4.
  println(mary.apply(2))

}
