package example

// Called Semigroup in Cats

trait CombineableTypeclass[A] {
  def combine(x: A, y: A): A
}

object CombinableTypeclass {

  def combine[A](a: A, b: A)(implicit c: CombineableTypeclass[A]) =
    c.combine(a, b)

  implicit val CombinableInt = new CombineableTypeclass[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }

  val a = 1
  val b = 2

  def exampleCombinationTypeclass() = combine(a, b)
}
