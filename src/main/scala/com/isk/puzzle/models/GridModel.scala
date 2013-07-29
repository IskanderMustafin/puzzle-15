package com.isk.puzzle.models


/**
 * @author imustafin
 */

/**
 * Поле игры
 * @param gridSize размеры поля
 */
case class GridModel(gridSize: GridSize) {

  /**
   * Ячейки поля
   */
  private val _cells = for(
               x <- 1 to gridSize.width;
               y <- 1 to gridSize.height)
                 yield new Cell(CellPosition(x, y),  gridModel = this)

  /**
   *  Пустая ячейка
   */
  private val _emptyCell = _cells.last

  /**
   * Объект колбэка, который исполняется при смене мест двух ячеек
   */
  private var _cellsSwapCallback: Option[(CellPosition, CellPosition) => Unit] = None

  /**
   * Объект колбэка, который исполняется если игра выйграна
   */
  private var _gameWonCallback: Option[() => Unit] = None


  /**
   * Метод меняет местами ячейку с пустой ячейкой, если это возможно
   * @param cellPosition позиция ячейки, которую нужно попробовать сменить
   * @param isShuffle вызывается ли метод из с целью тасования ячеек
   *
   */
  def trySwapWithEmptySlot(cellPosition: CellPosition, isShuffle: Boolean = false): Unit = {
    trySwapWithEmptySlot(cellAt(cellPosition), isShuffle)
  }

  /**
   * Метод меняет местами ячейку с пустой ячейкой, если это возможно
   * @param cell ячейка
   */
  def trySwapWithEmptySlot(cell: Cell, isShuffle: Boolean): Unit = {
    if (canSwapWithEmptyCell(cell)) {
      swapCells(cell, _emptyCell)

      // если это не тасование, то нужно проверить состояние игры
      if (!isShuffle) {
        checkGameWon()
      }
    }
  }

  /**
   * Проверяет возможность смены позиции переданной ячейки с пустой ячейкой
   * @param cell ячейка которую нужно проверить
   * @return true если есть возможность поменять местами с пустой ячейкой, иначе false
   */
  private def canSwapWithEmptyCell(cell: Cell) = {
    cell.isAdjacentTo(_emptyCell)
  }

  /**
   * Проверяет условие победы. В случае победы вызывает колбэк
   */
  private def checkGameWon() = {
    if (isPuzzleSolved && _gameWonCallback.isDefined) {
      _gameWonCallback.get()
    }
  }

  /**
   * Проверка условия победы
   * @return true, если пазл решен, иначе false
   */
  private def isPuzzleSolved = {
    _cells.forall{_.isAtInitialPosition}
  }

  /**
   * Меняет местами 2 ячейки
   * @param cellFrom первая ячейка
   * @param cellTo вторая ячейка
   */
  private def swapCells(cellFrom: Cell, cellTo: Cell) {
    val previousPosition = cellFrom.curPosition
    cellFrom.curPosition = cellTo.curPosition
    cellTo.curPosition = previousPosition

    if (_cellsSwapCallback.isDefined) {
      _cellsSwapCallback.get(cellTo.curPosition, cellFrom.curPosition)
    }
  }

  /**
   * Проверяет входит ли переданная позиция в границы поля игры
   * @param pos
   * @return true если входит в границы
   */
  def isPositionInBounds(pos: CellPosition) = {
    pos.x >= 1 &&
    pos.x <= gridSize.width &&
    pos.y >= 1 &&
    pos.y <= gridSize.height
  }

  /**
   * Возвращает ячейку согласно позиции
   * @param pos позиция ячейки
   * @return ячейка
   */
  def cellAt(pos: CellPosition): Cell = {
    _cells.find(_.curPosition == pos).get
  }

  /**
   * Перемешивание ячеек в поле в рандомном порядке
   */
  def shuffle() {
    for (_ <- 1 to 250) {
      val cellToMove = _emptyCell.randomAdjacentCell
      trySwapWithEmptySlot(cellToMove.curPosition, isShuffle = true)
    }
  }

  /**
   * Колбэк, который исполняется при смене мест двух ячеек
   */
  def onCellsSwap(callback: (CellPosition, CellPosition) => Unit) {
    _cellsSwapCallback = Some(callback)
  }

  /**
   * Колбэк, который исполняется если игра выйграна
   */
  def onGameWon(callback: => Unit) {
    _gameWonCallback = Some(callback _)
  }

}

