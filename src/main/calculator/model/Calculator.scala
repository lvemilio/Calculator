package calculator.model
import calculator.view.CalculatorButton
import calculator.controller
import calculator.controller.NumberAction
import calculator.model.NumberEntering.numberPressed
import scalafx.scene.control.TextField

class Calculator() {
  // Accessed by View. You should edit this method as you build functionality
  var state:CalcState = new numberPressed(this)
  var firstNum:Double = 0
  var secondNum:Double = 0

  def displayNumber(): Double = {
    this.state.displayNumber()
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def dividePressed(): Unit = {
    // TODO
  }

  def multiplyPressed(): Unit = {
    // TODO
  }

  def subtractPressed(): Unit = {
    this.state.subtractPressed()
  }

  def addPressed(): Unit = {
    this.state.addPressed()
  }

  def equalsPressed(): Unit = {
    this.state.equalsPressed()
  }

  def decimalPressed(): Unit = {
    this.state.decimalPressed()
  }

}