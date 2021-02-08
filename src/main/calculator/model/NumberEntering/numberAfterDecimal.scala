package calculator.model.NumberEntering

import calculator.model.addOperations.addPressed
import calculator.model.{CalcState, Calculator}
import calculator.model.subtractOperations._

class numberAfterDecimal(calculator: Calculator) extends CalcState(calculator) {

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
      calculator.firstNum = (calculator.firstNum.toString+pressedNr).toDouble

    }

    override def dividePressed(): Unit = {
      // TODO
    }

    override def multiplyPressed(): Unit = {
      // TODO
    }
    override def subtractPressed(): Unit = {
      calculator.state = new subtractPressed(calculator)
    }

    override def addPressed(): Unit = {
      calculator.state = new addPressed(calculator)
    }

    override def equalsPressed(): Unit = {
      // TODO
    }

    override def decimalPressed(): Unit = {
      // TODO
    }
}
