package lectures.OOP

import playground.{cinderella, prince}

object PackagingAndImports extends App {

  // package members are accesible within the same package
  val writer = new Writer("Phil", "The Great Satire", 2019)

  // need to import outside package

  // package object
  // package.scala

  //imports

  val princePhil = new prince
  val cindy = new cinderella
  // can import as with name => new_name
  // import playground.cinderella => Princess

  // default imports that you dont need to import
  // java.lang = String, Object, Exception
  // scala = Int, Nothing, Function
  
}
