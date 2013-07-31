package com.isk.puzzle.models

import org.scalatest.FunSuite


/**
 * @author welcometo
 */
class CellPositionSuite extends FunSuite {

  test("cell position have four adjacent positions") {
    val position = new CellPosition(3, 3)
    assert(position.getPositionsAround.size === 4)
  }

  test("cell position bottom, above, left and right") {
    val position = new CellPosition(3, 3)
    assert(position.above === new CellPosition(3, 2))
    assert(position.below === new CellPosition(3, 4))
    assert(position.left === new CellPosition(2, 3))
    assert(position.right === new CellPosition(4, 3))
  }
}
