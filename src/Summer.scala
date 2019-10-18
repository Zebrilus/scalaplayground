import scala.math;

// In file Summer.scala
import ChecksumAccumulator.calculate
object Summer {
  def main(args: Array[String]) = {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
      println(math.abs(12.2));
  }
}