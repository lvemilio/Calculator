package calculator.model.multiplyPressed

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.{decimalPressed, initialState, numberAfterDecimal, numberPressed}
import calculator.model.addOperations.addPressed
import calculator.model.dividePressed.dividePressed
import calculator.model.subtractOperations.subtractPressed

class EqualsAfterMultiply (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    calculator.firstNum = number
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.secondNum = 0
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.secondNum = 0
    calculator.state = new multiplyPressed(calculator)
  }
  override def subtractPressed(): Unit = {
    calculator.secondNum = 0
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.secondNum = 0
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.firstNum = calculator.firstNum * calculator.secondNum
  }

  override def decimalPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new decimalPressed(calculator)
  }
}
