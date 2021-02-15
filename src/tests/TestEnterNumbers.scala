import calculator.model.Calculator
import org.scalatest._

class TestEnterNumbers extends FunSuite{
  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }



  test("Correct number is displayed"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(7)
    calculator.numberPressed(8)
    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 780.0), calculator.displayNumber())
  }

  test("Decimal numbers are correctly displayed"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(4)
    assert(equalDoubles(calculator.displayNumber(), 12.4), calculator.displayNumber())
  }

  test("Decimal point numbers are correctly displayed"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(6)
    calculator.numberPressed(8)
    assert(equalDoubles(calculator.displayNumber(), 0.268), calculator.displayNumber())
  }

  test("Decimal point numbers are correctly displayed without pressing 0"){
    val calculator:Calculator = new Calculator
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.numberPressed(9)
    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 0.690), calculator.displayNumber())
  }

  test("Repetitive 0 presses before decimal do not change the value"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(4)
    calculator.numberPressed(9)
    assert(equalDoubles(calculator.displayNumber(), 0.49), calculator.displayNumber())
  }

  test("Repetitive decimal presses do not change value"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(3)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(6)
    assert(equalDoubles(calculator.displayNumber(), 3.96), calculator.displayNumber())
  }
  test("Numbers with a large digit amount are displayed"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.numberPressed(4)
    calculator.numberPressed(5)
    calculator.numberPressed(6)
    calculator.numberPressed(7)
    calculator.numberPressed(8)
    calculator.numberPressed(9)
    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 1234567890.0), calculator.displayNumber())
  }
  test("Decimals with a large digit amount are displayed"){
    val calculator:Calculator = new Calculator
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.numberPressed(4)
    calculator.numberPressed(5)
    calculator.numberPressed(6)
    calculator.numberPressed(7)
    calculator.numberPressed(8)
    calculator.numberPressed(9)
    calculator.numberPressed(0)
    assert(equalDoubles(calculator.displayNumber(), 0.1234567890), calculator.displayNumber())
  }
  test("Negative numbers can also be entered"){
    val calculator:Calculator = new Calculator
    calculator.subtractPressed()
    calculator.numberPressed(3)
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(7)
    assert(equalDoubles(calculator.displayNumber(), -35.7), calculator.displayNumber())
  }



}
