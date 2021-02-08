package calculator.model.subtractOperations

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.numberPressed
import calculator.model.addOperations.{addPressed, numberAfterDecimalAdd}

class decimalAfterSubtract (calculator: Calculator) extends CalcState(calculator) {
  override def displayNumber(): Double = {
    calculator.secondNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.secondNum = (calculator.secondNum.toInt.toString + "." + pressedNr).toDouble
    calculator.state = new numberAfterDecimalSubtract(calculator)
  }

  override def dividePressed(): Unit = {
    //TODO
  }

  override def multiplyPressed(): Unit = {

  }
  def subtractPressed(): Unit = {
  }

  def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  def equalsPressed(): Unit = {
  }

  def decimalPressed(): Unit = {
  }
}
