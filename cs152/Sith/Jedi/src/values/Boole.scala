/*
Eric Tam
007989423
CS-152
*/
package values
import expressions._

case class Boole(val value: Boolean) extends Literal{
	def &&(other: Boole): Boole = new Boole(value&&other.value)
	def ||(other: Boole): Boole = new Boole(value||other.value)
	def ! = new Boole(!value)
	override def toString() = value.toString
}

object Boole{
  def test{
    var a = new Boole(true)
    var b = new Boole(false)
    println("Boole test")
    println("Expected false Actual: "+(b&&a))
    println("Expected false Actual: "+(b&&a))
    println("Expected true Actual: "+(b||a))
    println("Expected true Actual: "+(b||a))
    println("Expected true Actual: "+(b!))
    println("Expected false Actual: "+(a!))
    println("")
  }
}