package com.isk.puzzle.view

import scala.swing.Dialog
import com.isk.puzzle.models.CellPosition

/**
 * @author welcometo
 */

/**
 * Представление для игры Пятнашки
 */
trait PuzzleView extends View {

  /**
   * Колбэк который нужно исполнить при клики по ячейке. Параметр - позиция кликнутой ячейки
   */
  private var _onCellClickedCallback: Option[(CellPosition) => Unit] = None

  /**
   * Меняет местами две ячейки
   * @param posFrom позиция первой ячейки
   * @param posTo позиция второй ячейки
   */
  def swapCells(posFrom: CellPosition, posTo: CellPosition)

  protected def cellClicked(pos: CellPosition): Unit = {
    if (_onCellClickedCallback.isDefined)
      _onCellClickedCallback.get(pos)
  }

  /**
   * Колбэк при клике по ячейке
   * @param callback колбэк, параметр - позиция кликнутой ячейки
   */
  def onCellClicked(callback: (CellPosition) => Unit) {
    _onCellClickedCallback = Some(callback)
  }

  /**
   * Метод отображает диалог
   */
  def showDialog(message: String, title: String = "", dialogType: Dialog.Message.Value = Dialog.Message.Info): Unit
}
