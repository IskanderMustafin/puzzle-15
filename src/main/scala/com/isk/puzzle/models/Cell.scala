package com.isk.puzzle.models

import scala.util.Random

/**
 * @author imustafin
 */

/**
 * Модель ячейки в поле
 * @param initPosition начальная позиция ячейки
 * @param gridModel модель поля
 */
case class Cell(initPosition: CellPosition, gridModel: GridModel) {

  /**
   * Текущая позиция ячейки
   */
  var curPosition = initPosition

  /**
   * Проверяет находится ли данная ячейка на своей первоначальной позиции
   * @return true если ячейка на первоначальной позиции, иначе false
   */
  def isAtInitialPosition = {
    curPosition == initPosition
  }

  /**
   * Проверяет является-ли ячейка прикающей к другой
   * @param anotherCell ячейка по отношению к которой нужно сделать проверку
   * @return true в случае если примыкает, иначе false
   */
  def isAdjacentTo(anotherCell: Cell) = {
    adjacentCells contains anotherCell
  }

  /**
   * Возвращает рандомную примыкающую ячейку
   * @return
   */
  def randomAdjacentCell = {
    Random.shuffle(adjacentCells).last
  }

  /**
   * Возвращает примыкающие ячейки
   * @return список примыкающих ячеек
   */
  private def adjacentCells = {
      val adjacentPositions = curPosition.positionsAround
      adjacentPositions.filter(gridModel.isPositionInBounds(_)).map(gridModel.cellAt(_))
  }

}
