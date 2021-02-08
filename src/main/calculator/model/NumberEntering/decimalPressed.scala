package calculator.model.NumberEntering

import calculator.model.addOperations.addPressed
import calculator.model.{CalcState, Calculator}

class decimalPressed(calculator: Calculator) extends CalcState(calculator) {
  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.firstNum = (calculator.firstNum.toInt.toString + "." + pressedNr).toDouble
    calculator.state = new numberAfterDecimal(calculator)
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
    // TODO
  }

  def decimalPressed(): Unit = {
    // TODO
  }
}
