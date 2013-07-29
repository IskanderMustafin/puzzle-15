package com.isk.puzzle.presenter

import scala.swing.Frame
import com.isk.puzzle.view.View

/**
 * @author welcometo
 */

/**
 * Базовый трейт для презентеров
 * @tparam ConcreteView вьюшка с которой оперирует презентер
 */
trait Presenter  [ConcreteView <: View] {
  val view : ConcreteView

  /**
   * Добавляет представление (вьюшку) в панель для отображения на экране
   * @param rootPanel панель в которую нужно добавить вюьшку
   */
  def start(rootPanel: Frame): Unit
}
