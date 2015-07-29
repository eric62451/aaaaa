/*
Eric Tam
007989423
CS-152
*/
package values
import expressions._

case class Number(val value: Double) extends Literal{
   def +(other: Number): Number = new Number(value+other.value)
   def -(other: Number): Number = new Number(value-other.value)
   def *(other: Number): Number = new Number(value*other.value)
   def /(other: Number): Number = new Number(value/other.value)
   def ==(other: Number): Boole = new Boole(value==other.value)
   def <(other: Number): Boole = new Boole(value<other.value)
   override def toString = value.toString;
}

object Number {
  def test{
    var a = new Number(5)
    var b = new Number(3)
    println("Number test")
    println("Expected 8.0 Actual: "+(a+b))
    println("Expected 8.0 Actual: "+(b+a))
    println("Expected 2.0 Actual: "+ (a-b))
    println("Expected -2.0 Actual: "+(b-a))
    println("Expected 15.0 Actual: "+(a*b))
    println("Expected 15.0 Actual: "+(b*a))
    println("Expected 1.66667 Actual: "+(a/b))
    println("Expected 0.6 Actual: "+(b/a))
    println("Expected false Actual: "+(b==a))
    println("Expected false Actual: "+(a==b))
    println("Expected true Actual: "+(b<a))
    println("Expected false Actual: "+(a<b))
    println("")
  }
}