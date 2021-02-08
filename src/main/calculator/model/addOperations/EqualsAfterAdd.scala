package calculator.model.addOperations

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.{decimalPressed, numberPressed}
import calculator.model.subtractOperations._

class EqualsAfterAdd (calculator: Calculator) extends CalcState(calculator) {

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
    // TODO
  }

  override def multiplyPressed(): Unit = {
    // TODO
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
    calculator.firstNum = calculator.firstNum + calculator.secondNum
  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalPressed(calculator)
  }
}
