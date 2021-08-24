package lectures.basics

object Expressions extends App {
  val x = 1 + 2 // Expression
  println(x)

  println( 3 + 2 * 4)

  println( 1 == x) // boolean, !=, > >=, < , <=

  println(!(1 == x)) // logical negation, ! || &&

  var aVar = 2
  aVar -= 1

  // instructions vs. expressions
  // instructions: something you do
  // expression: something that has a value and or a type. In Scala these are evaluated
  val aCondition = true
  val aConditionedVal = if(aCondition) 5 else 3
  println(aConditionedVal)
  // ifs are an expression

  var  i = 0
  while ( i < 10) {
    println(i)
    i += 1
  }

  // never write loops in scala, because it is not an imperative lang like python

  val aUnit = (aVar =3) // Unit == void
  println(aUnit)

  // side effects: pintln(), whiles, reassigning. Expressions that return or change

  // Code blocks
  // The value of a code block is the value of the last expression
  // code blocks are expressions
  // values inside the code block are localized in the code block

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // exercises

  // 1. value and expression
  // 2. true and 42
}
