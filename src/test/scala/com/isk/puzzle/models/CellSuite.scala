package com.isk.puzzle.models

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * @author welcometo
 */
class CellSuite extends FunSuite with BeforeAndAfter {

  var gridModel: GridModel = _

  before {
    gridModel = new GridModel(GridSize(4, 4))
  }

  test("current position of new cell is equal to initial position") {
    val cell = new Cell(CellPosition(3, 3), gridModel)
    assert(cell.curPosition === cell.initPosition)
  }

  test("cell is not at initial position") {
    val cell = new Cell(CellPosition(3, 3), gridModel)
    cell.curPosition = CellPosition(2, 2)
    assert(cell.isAtInitialPosition === false)
  }

  test("Cell(3,3) is adjacent to Cell(3, 4) in gridSize(4, 4) and vice-versa") {
    val cell = new Cell(CellPosition(3, 3), gridModel)
    val adjacentCell = new Cell(CellPosition(3, 4), gridModel)

    assert(cell.isAdjacentTo(adjacentCell) === true)
    assert(adjacentCell.isAdjacentTo(cell) === true)
  }

}
