package example

import cats.Monoid
import cats.syntax.monoid._

case class Statistics(detailPageView: Int, listPageView: Int, email: Int)

object CustomADT {

  // The function of the beginning...
  def combineAll[A: Monoid](as: List[A]): A =
    as.foldLeft(Monoid[A].empty)(Monoid[A].combine)

  // How to combine
  implicit val statisticsMonoid = new Monoid[Statistics] {
    def empty = Statistics(0, 0, 0)
    def combine(a: Statistics, b: Statistics) =
      Statistics(
        a.detailPageView + b.detailPageView,
        a.listPageView + b.listPageView,
        a.email + b.email
      )
  }

  def runDemo() = {

    val a = Statistics(1, 2, 3)
    val b = Statistics(2, 3, 4)
    val c = Statistics(3, 4, 5)

    // Abstracted away the how from what => easier to grasp
    println(s"Plus: ${a |+| b}")
    println(s"List: ${combineAll(List(a, b, c))}")

    // Cats has default instances for many Monoids, e.g. Int, String, Map, ...
    import cats.instances.string._

    val d = "abc"
    val e = "def"
    println(s"Plus: ${d |+| e}")
  }
}
