package example

import example.Motivation._
import example.Combinable._
import example.CustomADT._

object App extends App {
  println(s"Manual: ${manualCombine()}")
  println(s"Cats:   ${catsCombine()}")
  // exampleCombination
  // runDemo
}
