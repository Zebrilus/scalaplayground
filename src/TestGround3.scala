import scala.util.Random
object TestGround3 extends App {
  
  val n = 10
  val a = new Array[Int](n)

  
  for (x <- 0 until n) {
    a(x) = Random.nextInt(n);
  }
  
  println(a.size)
  println(a.mkString(","))
  
  val newa = for (x <- a if (x%2 == 0)) yield x
  
  println(newa.mkString(","))
  
  val v = Array(2,3,5,7,11)
  val result = for (elem <- a) yield 2*elem
  
  println(v.mkString(","));
}
