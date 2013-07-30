package com.isk.puzzle.models

import org.scalatest.FunSuite


/**
 * @author welcometo
 */
class CellSuite extends FunSuite {


  test("cell position have four adjacent positions") {
    val pos = new CellPosition(3, 3)
    assert(pos.getPositionsAround.size === 4)

    assert(pos.below === new CellPosition(3, 2))
    assert(pos.left === new CellPosition(2, 3))
    assert(pos.right === new CellPosition(4, 4))
  }




}
