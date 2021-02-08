package calculator.model.addOperations

import calculator.model.NumberEntering.{numberAfterDecimal, numberPressed}
import calculator.model.{CalcState, Calculator}

class decimalAfterAdd (calculator: Calculator) extends CalcState(calculator) {
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
    calculator.state = new numberAfterDecimalAdd(calculator)
  }

  override def dividePressed(): Unit = {
    //TODO
  }

  override def multiplyPressed(): Unit = {

  }
  def subtractPressed(): Unit = {
    // TODO
  }

  def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  def equalsPressed(): Unit = {

  }

  def decimalPressed(): Unit = {
    // TODO
  }
}
