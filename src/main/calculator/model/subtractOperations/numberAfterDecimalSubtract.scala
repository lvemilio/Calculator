package calculator.model.subtractOperations

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.numberPressed
import calculator.model.addOperations.{EqualsAfterAdd, addPressed}

class numberAfterDecimalSubtract (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.secondNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.firstNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.secondNum = (calculator.secondNum.toString+pressedNr).toDouble

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
    calculator.firstNum = calculator.firstNum - calculator.secondNum
    calculator.state = new EqualsAfterSubtract(calculator)
  }

  override def decimalPressed(): Unit = {
    // TODO
  }
}