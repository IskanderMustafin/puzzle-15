package com.isk.puzzle

import scala.swing.{MainFrame, Frame, SimpleSwingApplication}
import java.awt.Dimension
import com.isk.puzzle.presenter.PuzzlePresenterImpl
import com.isk.puzzle.view.PuzzleViewImpl
import com.isk.puzzle.puzzlelabels.{PuzzleLabelsFactory, PuzzleLabelType}
import com.isk.puzzle.models.{GridSize, GridModel}

object Starter extends SimpleSwingApplication {



  def top: Frame = new MainFrame {
    title = "Пятнашки"
    preferredSize = new Dimension(300, 300)

    startApp(this)
  }

  /**
   * Стартует приложение
   * @param rootPanel панель в которой нужно отобразить приложение
   */
  def startApp(rootPanel: Frame) = {
    // размеры поля для пятнашек
    val gridSize = GridSize(4, 4)
    // создаем поле игры и значения поля игры (римские цифры, арабские цифры, алфавит и т.д.)
    val grid = new GridModel(gridSize)
    // отображаемые значении в поле (арабские цифры, римские цифры, алфавит и т.п.)
    val viewLabels = PuzzleLabelsFactory(PuzzleLabelType.ARABIC_NUMERALS, gridSize.size - 1) // Отображаемые значения и размер поля можно вынести в настройки
    // вьюшка не должна знать о модели, передаем конкретные значения
    val view = new PuzzleViewImpl(viewLabels, gridSize.width, gridSize.height)
    // стартуем презентер
    new PuzzlePresenterImpl(view, grid).start(rootPanel)
  }

}