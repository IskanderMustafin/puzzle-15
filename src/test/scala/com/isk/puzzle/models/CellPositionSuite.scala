package com.isk.puzzle.models

import org.scalatest.FunSuite

/**
 * @author welcometo
 */
class CellPositionSuite extends FunSuite {
  test("pop is invoked on a non-empty stack") {

    val cellPosition = new CellPosition(1, 1)
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size
    val result = stack.pop()
    assert(result === 2)
    assert(stack.size === oldSize - 1)
  }
}
