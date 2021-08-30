package lectures.basics

object DefaultArgs extends App {
  def tailFactorial(n: Int, acc: Int = 1 ): Int = {
    if (n <= 1 ) acc
    else tailFactorial(n-1, n*acc)
  }
  val fact10 = tailFactorial(n = 10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving pic")
  // need to pass in named args with function is called

}
