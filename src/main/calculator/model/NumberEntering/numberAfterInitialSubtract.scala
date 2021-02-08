package calculator.model.NumberEntering

import calculator.model.{CalcState, Calculator}
import calculator.model.addOperations.addPressed
import calculator.model.subtractOperations._
class numberAfterInitialSubtract (calculator: Calculator) extends CalcState(calculator) {

  override def displayNumber(): Double = {
    calculator.firstNum
  }

  override def clearPressed(): Unit = {
    calculator.firstNum = 0
    calculator.secondNum = 0
  }

  override def numberPressed(number: Int): Unit = {
    var pressedNr:String = number.toString
    var currentNum:Int = calculator.firstNum.abs.toInt
    println(currentNum)
    calculator.firstNum = ("-"+ currentNum.toString + pressedNr).toDouble
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
    calculator.firstNum = calculator.firstNum + calculator.secondNum
    calculator.secondNum = 0
    calculator.state = new numberPressed(calculator)
  }

  override def decimalPressed(): Unit = {
    calculator.state = new decimalPressed(calculator)
  }
}
