package de.nufta.scalatest.sudoku

import scala.io.Source
import scala.io.BufferedSource

object SudokuLoader {

  def loadFile(fileName: String): Sudoku = {
    load(Source.fromFile(fileName))
  }

  def loadResource(name:String): Sudoku = { 
    load(Source.fromResource(name))
  }
  
  def load(buffer: BufferedSource) = {
    val sod = new Sudoku();
    try {
      val cl = this.getClass.getClassLoader
      var cnt: Int = 0
      for (ch <- buffer.filter(c => c >= '0' && c <= '9')) {
        val v = ch.toInt - 48
        if (v != 0) {
          val x = cnt % 9
          val y = cnt / 9
          sod.set(new Coordinate(x, y), v)
        }
        cnt += 1
      }
    } finally {
      buffer.close()
    }
    sod.setInitialized()
  }

}