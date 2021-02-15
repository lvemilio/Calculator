package calculator.model.subtractOperations

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering._
import calculator.model.addOperations._
import calculator.model.dividePressed.dividePressed
import calculator.model.multiplyPressed._
class subtractPressed (calculator: Calculator) extends CalcState(calculator) {

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
    calculator.state = new numberAfterSubtract(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.state = new multiplyPressed(calculator)
  }
  override def subtractPressed(): Unit = {

  }

  override def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {

  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalAfterSubtract(calculator)
  }
}
