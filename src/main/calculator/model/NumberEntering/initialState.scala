package calculator.model.NumberEntering

import calculator.model.{CalcState, Calculator}
import calculator.model.addOperations.addPressed
import calculator.model.multiplyPressed.multiplyPressed
import calculator.model.subtractOperations.subtractPressed

class initialState (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    calculator.firstNum = (calculator.firstNum.toInt.toString+pressedNr).toDouble
    calculator.state = new numberPressed(calculator)
  }

  override def dividePressed(): Unit = {
  }

  override def multiplyPressed(): Unit = {
  }
  override def subtractPressed(): Unit = {
    var currentNum:Int = calculator.firstNum.abs.toInt
    calculator.firstNum = ("-"+ currentNum.toString).toDouble
    calculator.state = new numberAfterInitialSubtract(calculator)
  }

  override def addPressed(): Unit = {
  }

  override def equalsPressed(): Unit = {

  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalPressed(calculator)
  }
}
