package com.isk.puzzle.models

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * @author welcometo
 */
class GridModelSuite extends FunSuite with BeforeAndAfter {

  var gridModel = GridModel(GridSize(4, 4))

  test("moving to empty slot adjacent cell") {
    val cell = gridModel.cellAt(CellPosition(4, 3)) // empty cell is by default on last position (4, 4)
    gridModel.trySwapWithEmptySlot(cell, isShuffle = false)
    assert(cell.curPosition === CellPosition(4, 4))

  }
}
