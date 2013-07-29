package com.isk.puzzle.view

import scala.swing.Component

/**
 * @author welcometo
 */

/**
 * Базовый интерфейс для представлений (вьюшек)
 */
trait View {

  /**
   * Представляет текущее представление (вьюшку) в виде компонента который может быть отрисован на экране
   * @return
   */
  def asComponent(): Component // любая вьюшка должна уметь отрисовывать себя

}

/**
 * Объект компаньон для базовой вьшюки
 */
object View {

  /**
   * Метод неявно преобразует [[com.isk.puzzle.view.View]]  в [[scala.swing.Component]].
   * Используется презентерами чтобы не было необходимости постоянно вызывать [[com.isk.puzzle.view.View.asComponent()]]
   * @param view представление которое нужно неявно преобразовать
   * @return объект представления с интерфейсом [[scala.swing.Component]]
   */
  implicit def view2Component(view: View): Component = view.asComponent()
}