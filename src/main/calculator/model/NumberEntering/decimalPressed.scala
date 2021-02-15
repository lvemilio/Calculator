package calculator.model.NumberEntering

import calculator.model.addOperations.addPressed
import calculator.model.{CalcState, Calculator}
import calculator.model.subtractOperations._
import calculator.model.multiplyPressed._
class decimalPressed(calculator: Calculator) extends CalcState(calculator) {
  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
    calculator.state = new initialState(calculator)
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.firstNum = (calculator.firstNum.toInt.toString + "." + pressedNr).toDouble
    calculator.firstString = calculator.firstNum.toString
    calculator.state = new numberAfterDecimal(calculator)

  }

  override def dividePressed(): Unit = {
  }

  override def multiplyPressed(): Unit = {
  }
  def subtractPressed(): Unit = {
  }
  def addPressed(): Unit = {
  }

  def equalsPressed(): Unit = {
  }

  def decimalPressed(): Unit = {
  }
}
