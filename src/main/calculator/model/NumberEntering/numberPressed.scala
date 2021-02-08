package calculator.model.NumberEntering

import calculator.model.addOperations.addPressed
import calculator.model.{CalcState, Calculator}

class numberPressed (calculator: Calculator) extends CalcState(calculator) {

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
  }

  override def dividePressed(): Unit = {
    // TODO
  }

  override def multiplyPressed(): Unit = {
    // TODO
  }
  override def subtractPressed(): Unit = {
    // TODO
  }

  override def addPressed(): Unit = {
    calculator.state = new addPressed(calculator)
  }

  override def equalsPressed(): Unit = {
    calculator.firstNum = calculator.firstNum + calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalPressed(calculator)
  }
}