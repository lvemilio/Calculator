package calculator.model.addOperations

import calculator.model.NumberEntering.{initialState, numberPressed}
import calculator.model.dividePressed.dividePressed
import calculator.model.{CalcState, Calculator}
import calculator.model.subtractOperations._
import calculator.model.multiplyPressed._

class addPressed (calculator: Calculator) extends CalcState(calculator) {
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
    calculator.state = new numberAfterAdd(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.state = new multiplyPressed(calculator)
  }
  override def subtractPressed(): Unit = {
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
  }

  override def equalsPressed(): Unit = {
  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalAfterAdd(calculator)
  }
}
