class Rational(n: Int, d: Int) {
  require(d != 0)

  private val gcden = gcd(n.abs, d.abs)
  val num: Int = n / gcden
  val den: Int = d / gcden
  val Pv: Double = scala.math.Pi

  def this(n: Int) = this(n, 1)

  override def toString = num + "/" + den;

  def +(that: Rational): Rational = new Rational(this.num * that.den + that.num * this.den, this.den * that.den)

  def -(that: Rational): Rational = new Rational(this.num * that.den - that.num * this.den, this.den * that.den)

  def *(that: Rational): Rational = new Rational(num * that.num, den * that.den)

  def /(that: Rational): Rational = new Rational(num * that.den, den * that.num)

  private def gcd(a: Int, b: Int): Int = {
    //    if (b == 0)
    //      println(a + "\n====")
    //    else
    //      println(s"a: $a ; b: $b $a/$b = ${a / b} R ${a % b}")
    if (b == 0) a else gcd(b, a % b)
  }
}

object Rational {
  implicit def intToRational(x: Int) = new Rational(x)
}