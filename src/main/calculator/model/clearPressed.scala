package calculator.model

import calculator.model.NumberEntering.numberPressed
import calculator.model.addOperations.addPressed

class clearPressed (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
  }

  override def numberPressed(number: Int): Unit = {
    calculator.state = new numberPressed(calculator)
  }

  override def dividePressed(): Unit = {
    // TODO
  }

  override def multiplyPressed(): Unit = {
    // TODO
  }
  override def subtractPressed(): Unit = {
    // TODO
  }

  override def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    // TODO
  }

  override def decimalPressed(): Unit = {
    // TODO
  }
}
