package com.isk.puzzle.view

import scala.swing._
import com.isk.puzzle.models.CellPosition


/**
 * @author welcometo
 */

/**
 * Реализация вьюшки для пятнашек
 * @param width ширина поля
 * @param height высота поля
 */
class PuzzleViewImpl(labels: Seq[String], width: Int, height: Int) extends BoxPanel(Orientation.NoOrientation) with PuzzleView {

  // добавляем пустое значение
  private val _labels = labels :+ ""

  // формируем массив ячеек, передаем в каждую из них отображаемое значение и обработчик события по клику
  private val _cellsViews = {
    for (x <- 1 to width;
         y <- 1 to height)
         yield {
            val oneDimensionalIndex = ((x - 1) * width) + (y - 1); // вычисляем индекс для одномерного масива
            new CellWidget(_labels(oneDimensionalIndex), new CellPosition(x, y), cellClicked)
          }
  }

  def swapCells(posFrom: CellPosition, posTo: CellPosition) = {
    val cellFrom = _cellsViews.find(_.pos == posFrom)
    val cellTo = _cellsViews.find(_.pos == posTo)
    if (cellFrom.isDefined && cellTo.isDefined) {
      val previousLabel = cellFrom.get.label
      cellFrom.get.label = cellTo.get.label
      cellTo.get.label = previousLabel
    }
  }

  // доавяляем ячейки в панель
  contents += new GridPanel(width, height)  {
    _cellsViews.foreach(contents += _)
  }

  def showDialog(message: String, title: String = "", dialogType: Dialog.Message.Value = Dialog.Message.Info) {
    Dialog.showMessage(
      this,
      message = message,
      title = title,
      messageType = dialogType
    )
  }

  def asComponent: Component = this // возвращаем this т.к. наследуемся от панели, которая в свою очредь является Component
}
