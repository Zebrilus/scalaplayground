
import ChecksumAccumulator.calculate

object FallWinter extends App {
  
  for ( x <- List("Sommer", "Winter", "Mond", "Sonne", "Erde" , "Feuer" , "Wasser")) {
      println(x+ (ChecksumAccumulator calculate x) )  
  }
}
  