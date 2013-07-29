package com.isk.puzzle.puzzlelabels

/**
 * @author welcometo
 */

/**
 * Перечисление доступных видов предсталения игры пятнашки
 */
object PuzzleLabelType extends Enumeration {

  type PuzzleLabelType = Value

  /**
   * Классическое представление значений поля арабскими цифрами
   */
  val ARABIC_NUMERALS = Value

  /**
   * Представление Римскими цифрами (I, II, ..., V, ..., X и т.д.)
   */
  val ROMAN_NUMERALS = Value

  /**
   * Прдеставление занчений поля в виде алфавита
   */
  val ALPHABETICAL = Value // что делать если размер поля больше количества букв в алфавите
}
