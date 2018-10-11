package example

import cats.implicits._

import scala.collection.mutable.{Map => MMap}

object Motivation {

  private val data: List[Map[String, Int]] = List(Map("A" -> 1, "B" -> 2), Map("A" -> 41))

  Map("A" -> 42, "B" -> 2)

  def manualCombine(): Map[String, Int] = {
    val initialMap = MMap.empty[String, Int].withDefaultValue(0)
    data
      .foldLeft(initialMap) {
        (finalMap: MMap[String, Int], rowMap: Map[String, Int]) =>
          rowMap.foreach { case (key, value) => finalMap(key) += value }
          finalMap
      }
      .toMap
  }

  def catsCombine(): Map[String, Int] = data.combineAll
}
