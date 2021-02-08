package calculator.model.NumberEntering

import calculator.model.addOperations.addPressed
import calculator.model.{CalcState, Calculator}
import calculator.model.subtractOperations._

class decimalPressed(calculator: Calculator) extends CalcState(calculator) {
  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
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
    calculator.state = new subtractPressed(calculator)
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
