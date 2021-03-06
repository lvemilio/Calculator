package calculator.model.addOperations

import calculator.model.NumberEntering.{initialState, numberAfterDecimal, numberPressed}
import calculator.model.dividePressed.dividePressed
import calculator.model.multiplyPressed.multiplyPressed
import calculator.model.{CalcState, Calculator}
import calculator.model.subtractOperations._

class decimalAfterAdd (calculator: Calculator) extends CalcState(calculator) {
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
    calculator.state = new numberAfterDecimalAdd(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.state = new multiplyPressed(calculator)
  }
  def subtractPressed(): Unit = {
    calculator.state = new subtractPressed(calculator)
  }

  def addPressed(): Unit = {
  }

  def equalsPressed(): Unit = {
  }

  def decimalPressed(): Unit = {
  }
}
