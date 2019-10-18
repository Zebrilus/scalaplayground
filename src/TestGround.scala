import scala.math.BigInt._
import scala.util.Random
import java.math.BigInteger
import scala.io.StdIn.readLine

object TestGround extends App {
  
  
  
  {
    val x = probablePrime(100, Random);
    println(x)
  }

  // excercise 1.8
  val z= {
    println(Random.nextString(12))
    val x:BigInt = new BigInt(new BigInteger(40,new java.util.Random()))
    println(x)
    println(x.toString(36))
    println(x.toString(16))
    4
  }
  // exercise 1.9
  println("\n\n");
  {
    //val x = readLine("Gib was ein: ")
    val x = "Hallo Welt!"
    println(x.head)
    println(x takeRight 1)
    println(x drop(2))    
  }
  
  {
    val x = "hallo" //readLine("Irgendein Text")
    for(c <- x) {
      println(c)
    }
  }
  
  def signum(i:Int):Int = {if (i < 0) -1 else if(i==0) 0 else 1}
  
  println(signum(1234))
  println(signum(-123));
  println(signum(0));
  
  def countdown(n: Int) {
    for (z <-0 to n reverse) {
      println(z);
    }
  }
  
  countdown(10)
  
  var v:Int=1;
  for (c <- "Hello") {
    v =  v * c.toInt
  }
  println(v)
  v=1
  "Hello".foreach(v*=_)
  println(v)
  
  def product (s:String)={
    var t:Int= 1;
    s.foreach(t*=_);
    t
  }
  
  println(product("Hello"));
}
  