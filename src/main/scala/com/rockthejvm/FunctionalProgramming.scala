package com.rockthejvm

object FunctionalProgramming extends App {
 //scala is object oriented
  class Person(name: String){
   def apply(age: Int) = println(s"I have aged $age years")
 }

  val bob = new Person("Bob")
  bob.apply(43)
  //or
  bob(43) //invoking bob as a function === bob.apply(43)
  //presence of apply method allows instance of class to be invoked like a function
  /* This is important because:
  Scala runs on the JVM
  jvm was built for scala
  it knows what an object is but not what a function is as a first-class citizen

  In functional programming we want to work with functions as first class elements of programming
   be able to:
    - compose functions
    - pass functions as arguments
    - return functions as results

    in order for jvm to understand scala functions, Scala uses FunctionX
    includes function1, function2... function22 (22 is maximum number of arguments you can pass to a function)
    */

  val simpleIncrementor = new Function1[Int, Int]{
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementor.apply(23) //returns 24
  //or
  simpleIncrementor(23)

  //All scala functions are instances of the Function_X type

  //syntax sugars | simple syntax to replace heavier boilerplate code
  val doubler: (Int) => Int = (x: Int) => 2 * x
  /*equivalent to boiler plate code:
  new Function[Int, Int]{
  override def apply(x:Int) = 2 * x
  */

  //higher order functions - methods that take functions as arguments or return functions as results
  val aMappedList = List(1,2,3).map(x => x + 1)
  println(aMappedList)

  //another higher order function | FlatMap
  val aFlatMapList = List(1, 2, 3).flatMap(x => List(x, 2 * x))

  /*alternative syntax
  val aFlatMapList = List(1, 2, 3).flatMap{ x =>
    List(x, 2 * x) }
    */

     println(aFlatMapList)
   //compiles multiple lists into one list

  //Another higher order function | Filtered List
  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x <= 3) //for every item in the list (x), if x<=3 then return in filtered list
  println(aFilteredList)
  /*shorter syntax
val aFilteredList = List(1, 2, 3, 4, 5).filter(_<= 3)
 */

  //chains of maps, flat maps and filters
  //want to return all combinations of two lists '1, 2, 3' and 'a, b, c'
  //iterates through collection without using for loops or anything, just calling maps, flatmap or filtering
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter") )
  println(allPairs)

  //more readable syntax | for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  //equivalent to map/flatmap chain above


  /**
   Collections
   */

  //Lists
  val aList= List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail //head and tail are the fundamental operations on list
  val aPrependedList = 0 :: aList //returns List(0, 1, 2, 3, 4, 5)
  val anExtendedList = 0 +: aList :+6 // +: prepends an element to a list, :+ appends an element //returns List(0, 1, 2, 3, 4, 5, 6)


  //sequences
  val aSequence: Seq[Int] = Seq(1,2,3) //equivalent to Seq.apply(1,2,3)
  //main characteristic of a sequence is that you can access an element at a given index
  val accessedElement = aSequence.apply(1) //returns element at index 1

  //vectors | sequence type which is fast for large sets of data
  val aVector = Vector(1,2,3,4,5)

  //sets | collections with no duplicates
  val aSet = Set(1,2,3,4,1,2,3)
  val setHas5 = aSet.contains(5) //contains method returns true or false
  val anAddedSet = aSet + 5 //adds 5 to the set | returns Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 //returns Set(1,2,4)

  //ranges
  //useful for iterating through values
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList //returns List(2,4,6...2000)


  //tuples | groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  //maps
  val aMap: Map[String, Int] = Map(
    ("Daniel", 986734),
    ("Jane", 234453),
    //or expressed as
    "Kate" -> 435322
  )
  println(aMap)

}
