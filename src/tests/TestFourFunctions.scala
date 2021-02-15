import org.scalatest._
import calculator.model._

class TestFourFunctions extends FunSuite{
  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }


  test("Basic integer operations work"){
    ////////////////////Add
    val calculator:Calculator = new Calculator
    calculator.numberPressed(7)
    calculator.addPressed()
    calculator.numberPressed(9)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 16.0), calculator.displayNumber())
    ///////////////////Subtract
    calculator.clearPressed()
    calculator.numberPressed(3)
    calculator.subtractPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1.0), calculator.displayNumber())
    ////////////////////Multiply
    calculator.clearPressed()
    calculator.numberPressed(7)
    calculator.multiplyPressed()
    calculator.numberPressed(6)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 42.0), calculator.displayNumber())
    ////////////////////Divide
    calculator.clearPressed()
    calculator.numberPressed(49)
    calculator.dividePressed()
    calculator.numberPressed(7)
    assert(equalDoubles(calculator.displayNumber(), 7.0), calculator.displayNumber())
  }

  test("Adding and subtracting with decimal points works"){
    ///////////////////////////Add
    val calculator:Calculator = new Calculator
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.numberPressed(9)
    calculator.addPressed()
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.numberPressed(8)
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 15.53), calculator.displayNumber())
    ///////////////////////Subtract
    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(7)
    calculator.subtractPressed()
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 4.93), calculator.displayNumber())
  }

  test("Adding and subtracting works with irregular inputs."){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.decimalPressed()// Note, the following tests will contain random multiple decimal presses to check if it doesn't change anything
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(3)

    calculator.addPressed()

    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(7)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 2.373), calculator.displayNumber())
    calculator.clearPressed()
    ////////////////////////
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(8)

    calculator.addPressed()

    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 5.238), calculator.displayNumber())
    /////////////////////////////Subtract
    /////////////////////////////
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(9)

    calculator.subtractPressed()

    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -8.401), calculator.displayNumber())
    /////////////////////////////
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(0)

    calculator.subtractPressed()

    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(7)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 4.18), calculator.displayNumber())
  }
  test("Multiplying and dividing works with decimal points"){
    ///////////////////////Multiply
    val calculator:Calculator = new Calculator
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(8)

    calculator.multiplyPressed()

    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(1)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 44.9098), calculator.displayNumber())
    calculator.clearPressed()
    //////////////////////////
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(1)

    calculator.multiplyPressed()

    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.2275), calculator.displayNumber())
    /////////////////////////////Divide
    /////////////////////////////
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(1)

    calculator.dividePressed()

    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(8)
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1.97303), calculator.displayNumber())
    calculator.clearPressed()
    ///////////////////////////////
    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(4)

    calculator.dividePressed()

    calculator.numberPressed(1)
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.numberPressed(9)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 3.6923076923076925), calculator.displayNumber())
    calculator.clearPressed()
  }

  test("Multiplying and dividing works with irregular inputs"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(0)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(1)

    calculator.multiplyPressed()

    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 3.85241), calculator.displayNumber())
    calculator.clearPressed()
    ////////////////////////
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(1)

    calculator.multiplyPressed()

    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.505202), calculator.displayNumber())
    /////////////////////////////Divide
    /////////////////////////////
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(1)

    calculator.dividePressed()

    calculator.numberPressed(6)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1.4364649681528663), calculator.displayNumber())
    /////////////////////////////
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(5)
    calculator.numberPressed(2)
    calculator.decimalPressed()
    calculator.numberPressed(0)

    calculator.dividePressed()

    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.decimalPressed()
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.3173803), calculator.displayNumber())
  }
  test("Operations work with large inputs"){
    //////////////////////////Add
    //////////////////////////
    val calculator:Calculator = new Calculator
    calculator.numberPressed(5)
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.numberPressed(8)
    calculator.numberPressed(5)
    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.numberPressed(9)

    calculator.addPressed()

    calculator.numberPressed(6)
    calculator.numberPressed(2)
    calculator.numberPressed(8)
    calculator.numberPressed(9)
    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1141771.73), calculator.displayNumber())
    ///////////////////////////Subtract
    ///////////////////////////
    calculator.numberPressed(9)
    calculator.numberPressed(2)
    calculator.numberPressed(4)
    calculator.numberPressed(8)
    calculator.numberPressed(5)
    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(9)

    calculator.subtractPressed()

    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.numberPressed(2)
    calculator.numberPressed(9)
    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 781943.05), calculator.displayNumber())
    /////////////////////////Multiply
    /////////////////////////
    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.numberPressed(5)
    calculator.numberPressed(7)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(9)

    calculator.multiplyPressed()

    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.numberPressed(2)
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(4)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 2074954.4435999999), calculator.displayNumber())
    ////////////////////////////Divide
    ////////////////////////////
    calculator.numberPressed(8)
    calculator.numberPressed(2)
    calculator.numberPressed(3)
    calculator.numberPressed(5)
    calculator.numberPressed(8)
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(9)

    calculator.dividePressed()

    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.numberPressed(2)
    calculator.numberPressed(4)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(8)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 578.3243146452446), calculator.displayNumber())
  }
  test("Decimal after operation works"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(5)
    calculator.addPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 5.2), calculator.displayNumber())
    ///////////////////////////
    calculator.numberPressed(5)
    calculator.subtractPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 4.8), calculator.displayNumber())
    ///////////////////////////
    calculator.numberPressed(5)
    calculator.multiplyPressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1), calculator.displayNumber())
    //////////////////////////////
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.decimalPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 25), calculator.displayNumber())
  }

}
