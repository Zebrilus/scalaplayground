/**
 * Coordinate.scala
 */
package de.nufta.scalatest.sudoku

/**
 *
 * @author zebrilus
 *
 * tags
 */
class Coordinate(xc: Int, yc: Int) {
  require (xc >=0 && xc < 9 && yc >=0 && yc <9, "Coordinate out of bounds : [" + xc + "," + yc + "]");

  val coord = Tuple2(xc, yc)

  def x: Int = { coord._1 }
  def y: Int = { coord._2 }

  def canEqual(a: Any) = a.isInstanceOf[Coordinate]

  override def equals(that: Any): Boolean = {
    that match {
      case that: Coordinate => that.canEqual(this) && that.coord.equals(this.coord)
      case _ => false
    }
  }

  override def hashCode: Int = coord.hashCode()

  override def toString() = {
    "Coordinate:[" + x + "," + y + "]";
  }
}