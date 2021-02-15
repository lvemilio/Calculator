import org.scalatest._
import calculator.model._

class TestFullFunctionality extends FunSuite{
  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }
  test("Consecutive operations produce the correct result"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(8)
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.subtractPressed()
    calculator.numberPressed(4)
    calculator.multiplyPressed()
    calculator.numberPressed(9)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 40.5), calculator.displayNumber())
    calculator.clearPressed()
    ///////////////////////////
    ///////////////////////////
    calculator.numberPressed(8)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(3)
    calculator.multiplyPressed()
    calculator.numberPressed(5)
    calculator.subtractPressed()
    calculator.numberPressed(4)
    calculator.dividePressed()
    calculator.numberPressed(7)
    calculator.addPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 7.807142857142857), calculator.displayNumber())
    //////////////////////////////
    //////////////////////////////
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(9)
    calculator.numberPressed(3)
    calculator.dividePressed()
    calculator.numberPressed(5)
    calculator.multiplyPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(9)
    calculator.addPressed()
    calculator.numberPressed(4)
    calculator.dividePressed()
    calculator.numberPressed(7)
    calculator.subtractPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 3.484857142857143), calculator.displayNumber())
    /////////////////////////////
    /////////////////////////////
    calculator.numberPressed(8)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.subtractPressed()
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.numberPressed(9)
    calculator.multiplyPressed()
    calculator.numberPressed(4)
    calculator.dividePressed()
    calculator.numberPressed(7)
    calculator.subtractPressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -1.938128078817734), calculator.displayNumber())
    //////////////////////////////////
    //////////////////////////////////
    calculator.subtractPressed()////Testing negative number input
    calculator.numberPressed(0)
    calculator.decimalPressed()
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.numberPressed(4)
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.numberPressed(1)
    calculator.numberPressed(2)
    calculator.multiplyPressed()
    calculator.numberPressed(9)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.subtractPressed()
    calculator.numberPressed(1)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.09570197044334972), calculator.displayNumber())
  }
  test("The same consecutive operations work (with other minor functionality tests)"){
    val calculator:Calculator = new Calculator
    calculator.subtractPressed() ////Testing negative number input
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(0)
    calculator.numberPressed(1)
    calculator.subtractPressed()
    calculator.subtractPressed()//Testing if consecutive presses don't change anything
    calculator.numberPressed(5)
    calculator.subtractPressed()
    calculator.numberPressed(8)
    calculator.subtractPressed()
    calculator.numberPressed(9)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -27.01), calculator.displayNumber())
    calculator.clearPressed() //Testing clear pressed
    //////////////////////////////////////
    //////////////////////////////////////
    calculator.numberPressed(9)
    calculator.numberPressed(2)
    calculator.addPressed()
    calculator.numberPressed(2)
    calculator.numberPressed(7)
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(6)
    calculator.addPressed()
    calculator.numberPressed(7)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 131.6), calculator.displayNumber())
    /////////////////////////////////////
    /////////////////////////////////////
    calculator.numberPressed(5)
    calculator.numberPressed(1)
    calculator.multiplyPressed()
    calculator.numberPressed(8)
    calculator.numberPressed(2)
    calculator.multiplyPressed()
    calculator.numberPressed(5)
    calculator.decimalPressed()
    calculator.numberPressed(1)
    calculator.multiplyPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 63984.6), calculator.displayNumber())
    calculator.clearPressed()
    assert(equalDoubles(calculator.displayNumber(), 0), calculator.displayNumber())
    assert(calculator.firstNum == 0 && calculator.secondNum == 0)
    //////////////////////////////////
    //////////////////////////////////
    calculator.numberPressed(1)
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.numberPressed(5)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.dividePressed()
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 0.3), calculator.displayNumber())
  }
  test("New operations work after equals is pressed and changing operations before inputting RHS changes the performed operation"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(6)
    calculator.addPressed()
    calculator.numberPressed(7)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 13), calculator.displayNumber())
    calculator.numberPressed(9)
    calculator.subtractPressed()
    calculator.multiplyPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 72), calculator.displayNumber())
    /////////////////////////////
    /////////////////////////////
    calculator.numberPressed(8)
    calculator.multiplyPressed()
    calculator.subtractPressed()
    calculator.addPressed()
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 13), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
    calculator.numberPressed(8)
    calculator.multiplyPressed()
    calculator.subtractPressed()
    calculator.dividePressed()
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 1.6), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
    calculator.numberPressed(8)
    calculator.multiplyPressed()
    calculator.subtractPressed()
    calculator.dividePressed()
    calculator.subtractPressed()
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 3), calculator.displayNumber())
    /////////////////////////
    /////////////////////////
    calculator.numberPressed(4)
    calculator.multiplyPressed()
    calculator.subtractPressed()
    calculator.dividePressed()
    calculator.multiplyPressed()
    calculator.numberPressed(5)
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 20), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
  }
  test("Multiple equals presses after an operation repeats that operation"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(6)
    calculator.addPressed()
    calculator.numberPressed(9)
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 42), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
    calculator.numberPressed(6)
    calculator.subtractPressed()
    calculator.numberPressed(4)
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), -10), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
    calculator.numberPressed(9)
    calculator.multiplyPressed()
    calculator.numberPressed(3)
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(), 729), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
    calculator.numberPressed(4)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(),0.25 ), calculator.displayNumber())
    //////////////////////////
    //////////////////////////
    calculator.numberPressed(4)
    calculator.dividePressed()
    calculator.numberPressed(2)
    calculator.addPressed()
    calculator.numberPressed(7)
    calculator.multiplyPressed()
    calculator.numberPressed(8)
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    calculator.equalsPressed()
    assert(equalDoubles(calculator.displayNumber(),36864), calculator.displayNumber())
  }
  test("No result is given if equals is pressed without RHS"){
    val calculator:Calculator = new Calculator
    calculator.numberPressed(6)
    calculator.addPressed()
    assert(equalDoubles(calculator.displayNumber(),0), calculator.displayNumber())
    calculator.subtractPressed()
    assert(equalDoubles(calculator.displayNumber(),0), calculator.displayNumber())
    calculator.multiplyPressed()
    assert(equalDoubles(calculator.displayNumber(),0), calculator.displayNumber())
    calculator.dividePressed()
    assert(equalDoubles(calculator.displayNumber(),0), calculator.displayNumber())
  }

}
