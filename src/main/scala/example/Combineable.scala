package example

// Called Semigroup in Cats
trait Combineable[A] {
  def combine(x: A, y: A): A
}

object Combinable {

  implicit val CombinableInt = new Combineable[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }

  val a = 1
  val b = 2

  def exampleCombination() =
    println(CombinableInt.combine(a, b))

  // Rule (associative):
  // combine(a, combine(b, c)) = combine(combine(a, b), c)
}
