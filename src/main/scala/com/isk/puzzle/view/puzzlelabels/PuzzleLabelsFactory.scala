package com.isk.puzzle.puzzlelabels


/**
 * @author welcometo
 */

/**
 * Фабрика для получения различных типов значений для представления в поле пятнашек
 */
object PuzzleLabelsFactory {

  import PuzzleLabelType._
  def apply(gridType: PuzzleLabelType, size: Int): Seq[String] = {
    gridType match {
      case ARABIC_NUMERALS => ArabicNumCellLabels.getCellValues(size)
      case ROMAN_NUMERALS => RomanNumCellLabels.getCellValues(size)
      case ALPHABETICAL => AlphabeticalCellLabels.getCellValues(size)

      case _ => throw new IllegalArgumentException("Неподдерживаемый тип представления поля: " + gridType)
    }
  }
}



