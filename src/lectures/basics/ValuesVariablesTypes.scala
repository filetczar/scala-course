package lectures.basics
/** comments here
 * vals are immutable. cannot be changed
 *
 * */
object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // x = 2, cant do this VALS are immutable
  // types are optional, but recommended. Compiler can infer types

  val astring: String = "Hello";
  val anotherString: String = "goodbye";

  val abool: Boolean = true;
  val anotherbool: Boolean = false;
  val aChar: Char = 'a';
  val anint: Int = x;
  val aShort: Short = 4613;
  // shorts have 2 bytes instead of 4
  // longs have 8 bytes. Ends with L
  val aLong: Long = 943974198104L;
  val aFloat: Float = 2.0F;
  val aDouble: Double = 3.14;

  // variables
  // can be reassigned

  var aVariable: Int = 4
  aVariable = 5;
  aVariable += 1
  println(aVariable)


}
