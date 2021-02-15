package calculator.model.dividePressed

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.{initialState, numberPressed}
import calculator.model.addOperations.addPressed
import calculator.model.multiplyPressed.{multiplyPressed, numberAfterDecimalMultiply}
import calculator.model.subtractOperations.{numberAfterDecimalSubtract, subtractPressed}

class decimalAfterDivide (calculator: Calculator) extends CalcState(calculator) {
  override def displayNumber(): Double = {
    calculator.secondNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new initialState(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.secondNum = (calculator.secondNum.toInt.toString + "." + pressedNr).toDouble
    calculator.secondString = calculator.secondNum.toString
    calculator.state = new numberAfterDecimalDivide(calculator)
  }

  override def dividePressed(): Unit = {
  }

  override def multiplyPressed(): Unit = {
    calculator.state = new multiplyPressed(calculator)
  }
  def subtractPressed(): Unit = {
    calculator.state = new subtractPressed(calculator)
  }

  def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  def equalsPressed(): Unit = {
  }

  def decimalPressed(): Unit = {
  }
}
