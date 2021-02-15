package calculator.model.subtractOperations

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.{initialState, numberPressed}
import calculator.model.addOperations.addPressed
import calculator.model.dividePressed.dividePressed
import calculator.model.multiplyPressed.multiplyPressed

class decimalAfterNumberSubtract (calculator: Calculator) extends CalcState(calculator) {
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
    calculator.state = new numberAfterDecimalSubtract(calculator)
  }

  override def dividePressed(): Unit = {
    calculator.firstNum-=calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.firstNum-=calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new multiplyPressed(calculator)
  }
  override def subtractPressed(): Unit = {
    calculator.firstNum-=calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.firstNum-=calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new addPressed(calculator)
  }

  def equalsPressed(): Unit = {
    calculator.firstNum -= calculator.secondNum
    calculator.state = new EqualsAfterSubtract(calculator)
  }

  def decimalPressed(): Unit = {
  }
}
