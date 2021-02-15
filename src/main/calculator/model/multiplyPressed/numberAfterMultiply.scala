package calculator.model.multiplyPressed

import calculator.model.{CalcState, Calculator}
import calculator.model.NumberEntering.{initialState, numberPressed}
import calculator.model.addOperations.{EqualsAfterAdd, addPressed, decimalAfterAdd}
import calculator.model.dividePressed.dividePressed
import calculator.model.subtractOperations.subtractPressed

class numberAfterMultiply (calculator: Calculator) extends CalcState(calculator) {

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
    calculator.secondNum = (calculator.secondNum.toInt.toString+pressedNr).toDouble
  }

  override def dividePressed(): Unit = {
    calculator.firstNum *= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new dividePressed(calculator)
  }

  override def multiplyPressed(): Unit = {
    calculator.firstNum *= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new multiplyPressed(calculator)
  }
  override def subtractPressed(): Unit = {
    calculator.firstNum *= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new subtractPressed(calculator)
  }

  override def addPressed(): Unit = {
    calculator.firstNum *= calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.firstNum = calculator.firstNum * calculator.secondNum
    calculator.state = new EqualsAfterMultiply(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.secondString = calculator.secondNum.toString
    calculator.state = new decimalAfterNumberMultiply(calculator)
  }
}
