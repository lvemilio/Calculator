package calculator.model.NumberEntering

import calculator.model.addOperations.addPressed
import calculator.model.dividePressed.dividePressed
import calculator.model.{CalcState, Calculator}
import calculator.model.subtractOperations._
import calculator.model.multiplyPressed._
class numberAfterDecimal(calculator: Calculator) extends CalcState(calculator) {

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
      calculator.firstString+=pressedNr
      calculator.firstNum = calculator.firstString.toDouble

    }

    override def dividePressed(): Unit = {
      calculator.state = new dividePressed(calculator)
    }

    override def multiplyPressed(): Unit = {
      calculator.state = new multiplyPressed(calculator)
    }
    override def subtractPressed(): Unit = {
      calculator.state = new subtractPressed(calculator)
    }

    override def addPressed(): Unit = {
      calculator.state = new addPressed(calculator)
    }

    override def equalsPressed(): Unit = {
    }

    override def decimalPressed(): Unit = {
    }
}
