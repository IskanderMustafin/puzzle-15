package com.isk.puzzle.puzzlelabels

/**
 * @author welcometo
 */


/**
 * Базовый трейт для значений которые можно представить на поле.
 */
sealed abstract class PuzzleCellLabels {
  def getCellValues(size: Int): Seq[String]
}

/**
 * Значения для представления поля арабскими цифрами
 */
case object ArabicNumCellLabels extends PuzzleCellLabels {
  def getCellValues(size: Int) : Seq[String] = 1 to size map(_.toString)
}

/**
 * Значения для представления поля римскими цифрами
 */
case object RomanNumCellLabels extends PuzzleCellLabels {
  private val allPresentationValues = Array("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
  "XI", "XII", "XIII", "XIV", "XV");  // можно сделать конвертер арабских чисел в римские чтоб не заполнять руками

  def getCellValues(size: Int) : Seq[String] = {
    allPresentationValues.take(size)
  }
}

/**
 * Занчения для представления поля алфавитом
 */
// не будет работать если размер поля больше количества букв в алфавите
case object AlphabeticalCellLabels extends PuzzleCellLabels {
  private val allPresentationValues = Array("а", "б", "в", "г", "д"); // TODO дозаполнить

  def getCellValues(size: Int) : Seq[String] = {
    allPresentationValues.take(size)
  }
}

