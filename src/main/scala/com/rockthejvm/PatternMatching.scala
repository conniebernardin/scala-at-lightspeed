package com.rockthejvm

object PatternMatching extends App{

  //pattern matching is equivalent of switch expressions
  //but it is more advanced as it can deconstruct data structures into its constituent parts
  val anInteger = 55
//you can match this integer against a number of cases instead of using if-else chains
  val order = anInteger match{
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th" //underscore denotes default for anything else
  }
  println(order)


  //advanced PM
  //decomposing value into its constituent parts
  case class Person(name: String, age:Int) //benefit of case classes is being able to deconstruct with pattern matching
  val bob = Person("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "cannot find name or age" //always set a default
  }
  println(personGreeting)
  //matches bob to a whole structure
  //if Person bob conforms to structure of (n, a), then n and a become constituent parts of bob as a person
  //pattern match expression assigns bob to the structure

  //pattern matching can also deconstruct tuples
  val aTuple = ("Bon Jovi" , "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "cannot find band or genre"
  }
  println(bandDescription)


  //decomposing Lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown List"
  }

  //pattern matching tries all cases in sequence
}
