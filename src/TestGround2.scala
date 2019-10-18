object TestGround2 extends App {
  def exp(x:Double, n:Int):Double ={
    if (n == 0) 1 else
      if (n < 0) 1/exp(x, -n) else
        if (n%2 == 0) {val y:Double = exp(x, n/2); y*y} else 
          x*exp(x, n-1)
  }  
  println(exp(3,-4))
  
  val s = Array("Hello", "World");
  s(1) = "Arsehole";
  for (x <- s) println(x)
  
}
