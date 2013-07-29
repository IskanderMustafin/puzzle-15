package com.isk.puzzle.models

/**
 * @author welcometo
 */

/**
 * Модель представления сетки x * y
 * @param width ширина сетки
 * @param height высота сетки
 */
case class GridSize(width: Int, height: Int) {

  /**
   * Площадь сетки
   */
   lazy val size = width * height

}
