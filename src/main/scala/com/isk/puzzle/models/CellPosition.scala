package com.isk.puzzle.models

/**
 * @author imustafin
 */

/**
 * Позиция ячейки в поле
 * @param x координата по осе X
 * @param y координата по осе Y
 */
case class CellPosition(x: Int, y: Int) {

  /**
   * Позиция выше
   */
  lazy val above = CellPosition(x, y - 1)

  /**
   * Позиция правее
   */
  lazy val right = CellPosition(x + 1, y)

  /**
   * Позиция левее
   */
  lazy val left = CellPosition(x - 1, y)

  /**
   * Позиция ниже
   */
  lazy val below = CellPosition(x, y + 1)


  /**
   * Список окружающих позиций (выше, ниже, левее, правее)
   */
  lazy val positionsAround = List(above, right, left, below)
}
