package calculator.model.dividePressed

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.initialState
import calculator.model.addOperations.addPressed
import calculator.model.multiplyPressed.{EqualsAfterMultiply, multiplyPressed}
import calculator.model.subtractOperations.subtractPressed

class numberAfterDecimalDivide(calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.secondNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.firstNum = 0
    calculator.state = new initialState(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.secondString+=pressedNr
    calculator.secondNum = calculator.secondString.toDouble

  }

  override def dividePressed(): Unit = {
    calculator.firstNum /= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.firstNum /= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new multiplyPressed(calculator)
  }
  override def subtractPressed(): Unit = {
    calculator.firstNum /= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.firstNum /= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.firstNum = calculator.firstNum / calculator.secondNum
    calculator.state = new EqualsAfterDivide(calculator)
  }

  override def decimalPressed(): Unit = {
  }
}
