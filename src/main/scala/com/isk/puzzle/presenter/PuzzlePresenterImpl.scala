package com.isk.puzzle.presenter

import com.isk.puzzle.view.PuzzleView
import scala.swing.Frame
import com.isk.puzzle.models.GridModel


/**
 * @author welcometo
 */

/**
 * Реализация презентера для пятнашек
 * @param view представление (view) которым оперирует презентер
 * @param puzzleModel модель поля игры
 */
class PuzzlePresenterImpl(val view: PuzzleView, puzzleModel: GridModel) extends PuzzlePresenter {

  bind()

  puzzleModel.shuffle()

  /**
   * Метод связывает представление с презентером. Устанавливает обработчики событий и т.п.
   */
  def bind() {
    // при изменении модели отображаем изменения в UI
    puzzleModel.onCellsSwap{ (posFrom, posTo) =>
      view.swapCells(posFrom, posTo)
    }

    puzzleModel.onGameWon {
      view.showDialog("Победа!")
    }

    // меняем модель по событиям в UI
    view.onCellClicked{ clickedCellPosition =>
      puzzleModel.trySwapWithEmptySlot(clickedCellPosition)
    }
  }

  def start(rootPanel: Frame) = {
    rootPanel.contents = view // неявное преобразование из View в Component
  }

}