package com.isk.puzzle.view

import scala.swing.Button
import com.isk.puzzle.models.CellPosition
import scala.swing.event.ButtonClicked

/**
 * @author imustafin
 */

/**
 * Отображаемая ячейка во вьюшке
 * @param _label текст для отображения
 * @param pos позиция ячейки
 * @param clickHandler обработчик события по клику на ячейке
 */
class CellWidget(private var _label: String, val pos: CellPosition, clickHandler: (CellPosition) => Unit) extends Button {

  reactions += {
    case ButtonClicked(b) =>  clickHandler(pos)
  }

  text = label // устанавливаем текст ячейки

  def label = _label

  def label_=(value: String) = {
    _label = value
    text = value // при смене значения меняем текст у кнопки
  }

}
