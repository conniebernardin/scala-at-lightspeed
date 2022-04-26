package com.rockthejvm

object ObjectOrientation extends App{

  //extends app is equivalent to java: public static void main(String[] args){}
  //allows you to run application


  //class and instance
  class Animal {
    //define fields
    val age: Int = 0
    //define methods
    def eat() = println("I'm eating")
  }
  //inheritance with keyword 'new'
  val anAnimal = new Animal

  //inheritance
  class Dog(name:String) extends Animal //class definition is also constructor definition
  //(name:string) passes arguments to class

  //constructor argument with keyword val
  val aDog = new Dog("lassie")

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() //most derived method will be called at runtime

  //abstract class = not all fields/classes need implementation
  abstract class WalkingAnimal {
    val hasLegs = true //all fields and methods are public by default | can be restricted by 'private' or 'protected'
    def walk(): Unit //whichever class extends WalkingAnimal will override this method or provide implementation
  }

  //interface = ultimate abstract type === you can leave everything unimplemented
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  //scala offers single class inheritance and multi-trait inheritance
  //can extend single class but mix in multiple traits | as many traits as you like
  //adding a trait is called 'mixing'
  class Crocodile extends Animal with Carnivore with Philosopher {
    //implementing a method that is also present in a supertype is called Override
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    //can also implement concrete method from animal
    override def eat(): Unit = super.eat()

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  //method naming
  trait Philosopher{
    def ?!(thought: String): Unit //?! is a valid method name
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  //or can write
  aCroc eat aDog //infix notation = structured like: object method argument | only available for methods with ONE argument

  //method ?! using single argument so can also be used in infix notation
  aCroc ?! "What if we could fly?"
  //operators in Scala are actually methods
  val basicMath = 1 + 2 //the plus is actually a method
  val anotherBasicMath = 1.+(2) //equivalent to basicMath

  //anonymous classes
  //abstract classes/interfaces cannot be instantiated by themselves. They need to be extended by a concrete class
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  }

  //singleton object | particular to Scala
  object MySingleton { // the only instance of the mySingleton type
    val mySpecialValue = 5623
    def mySpecialMethod(): Int = 6783

    //special method in scala called apply
    def apply(x: Int): Int = x + 1 //using apply method in class allows instances of class to call that method in certain way
  }

  //applied method in a class allows instances of that class to be invoked like functions
  MySingleton.apply(65)
  MySingleton(65) //equivalent to above
  MySingleton.mySpecialMethod()

  //defining class and object with the same name in the same file makes companions
  object Animal { //companions | companion object
    //companions have additional property that they can access each others private fields/methods
    //however the singleton animal and instances of animal are different things
    //normally never use animal as an instance while other animals are in practice | instead you use animal companion object
    //to access things that do not depend on instances of the animal class

    val canLiveIndefinitely = false
  }
  //access this field ^^^ on the singleton object in the same way you access static methods in java
  val animalsCanLiveForever = Animal.canLiveIndefinitely

  //case class
  //light weight data structures with boilerplate

  /*when defining a case class, the compiler generates the following
  * sensible equals and hashcode
  * sensible and quick serialization
  *companion with apply
  * pattern matching
  * */
  case class Person(name:String, age:Int)

  val Bob = Person("Bob", 54) //equivalent to Person.apply("Bob", 54)
  //able to emit the new keyword when making person because the person case class also has a companion object with an apply method


  //exceptions
  try{
    //code that can throw
  }
  catch {
    case e: Exception => "error message"
  }
  finally{
    //execute some code no matter what
  }


  //Generics
  //allows you to reuse functionality and apply it to multiple types

  abstract class MyList[T]{ //MyList class is applicable to any type denoted as T
    def head: T
    def tail: MyList[T]

    //defining elements that will become concrete when called outside the class
  }

  val aList: List[Int] = List(1, 2, 3)
  val first = aList.head //head method becomes concrete
  val rest = aList.tail

  //same logic can be applied to string list as Integer list
  val aStringList= List("hello", "scala")
  val firstString = aStringList.head
  val restString = aStringList.tail


  //Scala is operated with Immutable values
  //Any modification to an instance of a class should result in another instance
  //you don't mutate or change the values inside a given object, you simply return another one
  /*Benefits
  * works miracles in multithreaded environments
  * helps make sense of code('reasoning about')
  * */
}
