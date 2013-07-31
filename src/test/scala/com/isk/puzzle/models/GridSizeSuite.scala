package com.isk.puzzle.models

import org.scalatest.FunSuite

/**
 * @author welcometo
 */
class GridSizeSuite extends FunSuite {

  test("Size of grid size must be width * height") {
    val gridSize = new GridSize(4 ,4)
    assert(gridSize.size === 16)
  }
}
