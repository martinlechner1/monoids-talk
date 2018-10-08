package example

// Called Monoid in cats
trait CombineableWithEmpty[A] extends Combineable[A] {
  def empty: A
  // Rule: combine(x, empty) = combine(empty, x) = x
}
