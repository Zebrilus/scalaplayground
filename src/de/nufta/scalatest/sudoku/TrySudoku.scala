package de.nufta.scalatest.sudoku

object TrySudoku extends App {
  //val sod = SudokuLoader.loadFile("c:/tests/Test1.sod")
  val sod = SudokuLoader.loadResource("resources/Test1.sod");
  println("Sudoku: \n")
  println(sod)
  val solved = sod.solve() 
  println("--\n\nEs wurde " + {if (solved) "eine" else "keine"} + " Lösung gefunden:");
  println(sod)
}