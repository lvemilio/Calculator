package calculator.model.subtractOperations

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.numberPressed
import calculator.model.addOperations.{decimalAfterAdd, numberAfterAdd}

class subtractPressed (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.secondNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.secondNum = number
    calculator.state = new numberAfterSubtract(calculator)
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
    // TODO
  }

  override def equalsPressed(): Unit = {

  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalAfterSubtract(calculator)
  }
}
