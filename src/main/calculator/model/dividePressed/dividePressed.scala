package calculator.model.dividePressed

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.{initialState, numberPressed}
import calculator.model.addOperations.addPressed
import calculator.model.multiplyPressed._
import calculator.model.subtractOperations.subtractPressed

class dividePressed (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.secondNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new initialState(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.secondNum = number
    calculator.state = new numberAfterDivide(calculator)
  }

  override def dividePressed(): Unit = {
  }

  override def multiplyPressed(): Unit = {
    calculator.state = new multiplyPressed(calculator)
  }

  override def subtractPressed(): Unit = {
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalAfterDivide(calculator)
  }
}
