package com.rockthejvm

object Basics extends App {

  //defining a value
  val meaningOfLife: Int = 42
  println("The  meaning of life is: " + meaningOfLife)

  val anInterpolatedString = s"The meaning of life is always $meaningOfLife"
  print(anInterpolatedString)

  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  //if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999

  val chainedIfExpression =
    if (meaningOfLife > 43) 53
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0


  //code blocks
  val aCodeBlock = {
    //can add definitions, functions, classes etc.
    val aLocalValue = 67
    //have to return something at the end
    //last expression of code block is the valur of entire block
    aLocalValue + 3
  }

  //define a function
  def myFunction(x: Int, y: String): String = y + " " + x


  //functions are usually recursive in practice
  //recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)
  //in scala we don't use loops or iteration, we use RECURSION!

  //the Unit return type = no meaningful value === "void" in java

  //type of SIDE EFFECTS = operations which have nothing to do with computing meaningful information
  println("I Love Scala")

  //function returning unit
  def myUnitReturningFunction(): Unit = {
    println("Hello World")
  }
}