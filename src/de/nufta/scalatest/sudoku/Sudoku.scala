package de.nufta.scalatest.sudoku

import scala.collection.mutable.Map
import scala.collection.mutable.Map._
import scala.collection._
import scala.collection.mutable.ArrayBuffer

/**
 * @author ulrich.luebke
 *
 * tags
 */
class Sudoku {

  // 0 DENOTES no Value entered
  val UNSET: Int = 0;
  val allValues: Set[Int] = (1 to 9).toSet

  val field: Map[Coordinate, Int] = Map()

  val rows: Array[Set[Coordinate]] = new Array(9)
  val cols: Array[Set[Coordinate]] = new Array(9)
  val squares: Array[Set[Coordinate]] = new Array(9)

  val history: ArrayBuffer[Coordinate] = new ArrayBuffer()
  var initialized: Boolean = false
  
  val coords: Array[Coordinate] = new Array(9*9)
  
  var go = false

  {
    for (x <- 0 until 9) 
      for (y <- 0 until 9) 
         coords(y*9 +x) = new Coordinate(x,y)
    
    for (i: Int <- 0 until 9) {
      rows(i) = {
        var z: Set[Coordinate] = Set()
        for (x: Int <- 0 until 9) {
          z += new Coordinate(x, i)
        }
        z
      }
      cols(i) = {
        var z: Set[Coordinate] = Set()
        for (y: Int <- 0 until 9) {
          z += new Coordinate(i, y)
        }
        z
      }
      squares(i) = {
        var z: Set[Coordinate] = Set()
        val xb: Int = i % 3 * 3
        val yb: Int = i / 3 * 3
        for (x: Int <- xb until xb + 3) {
          for (y: Int <- yb until yb + 3) {
            z += new Coordinate(x, y)
          }
        }
        z
      }
    }
  }

  def entry(c: Coordinate): Int = {
    try {
      field(c)
    } catch {
      case ex: Exception => { UNSET }
    }
  }

  def entry(x: Int, y: Int): Int = {
    entry(new Coordinate(x, y))
  }

  def set(c: Coordinate, value: Int) {
    require(value > 0 && value <= 9, "---> " + value)
    field(c) = value
    if (initialized) {
      history += c
    }
  }

  /**
   * Sets the Sudoku to be Initialized and tracking entries
   */
  def setInitialized():Sudoku ={
    initialized = true;
    this
  }
  
  /**
   * Undo the last entry
   */
  def rollback() {
    val c = history.last
    field(c)= 0
    history.remove(history.length-1);
  }
  
  def isPlausible():Boolean = {
    field.keys.forall(cc => checkPlausible(cc))
  }
  
  private def checkPlausible(c:Coordinate):Boolean = {
    val e = entry(c)
    e == UNSET || {
      val cs = getRelated(c)
      !cs.exists(cc => entry(cc) == e)
    }
  }
  
  def getRelated(c:Coordinate):Set[Coordinate] = {
    val squareIndex = (c.x/3) + (c.y/3*3)
    (rows(c.y) ++ cols(c.x) ++ squares(squareIndex)) - c
  }
  
  def solve():Boolean = {
    val cord = coords.find(c => entry(c) == UNSET)
    if (cord == None) {
      return true
      //isPlausible()
    } else {
      val related = getRelated(cord.get)
      var usedNumbers:Set[Int] = Set()
      related.foreach(cc => usedNumbers += entry(cc))
      val availNumbers = allValues -- usedNumbers
      
      for (n <- availNumbers) {
        set(cord.get, n);
        if (solve()) {
          return true
        } else {
          rollback()
        }
      }
    }
    false
  }

  override def toString() = {
    val topBottom = "-" * (2 * 9 + 1);
    val builder = new StringBuilder(topBottom + "\n")
    for (y <- 0 until 9) {
      builder ++= "|"
      for (x <- 0 until 9) {
        builder ++= entry(x, y) + "|"
      }
      builder ++= "\n"
    }
    builder ++= topBottom
    builder.toString
  }
}