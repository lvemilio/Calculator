package calculator.model

abstract class CalcState(calculator: Calculator) {
  def displayNumber(): Double

  def clearPressed()

  def numberPressed(number: Int)

  def dividePressed()

  def multiplyPressed()

  def subtractPressed()

  def addPressed()

  def equalsPressed()

  def decimalPressed()
}
