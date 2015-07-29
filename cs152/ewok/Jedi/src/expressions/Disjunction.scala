/*
Eric Tam
007989423
CS-152
*/

package expressions
import values._
import ui._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Value = {
    var result = false
    var i = 0
    while ((!result) && i < operands.length) {
      if (operands(i).execute(env).isInstanceOf[Boole]) {
        result = operands(i).execute(env).asInstanceOf[Boole].value
        i = i + 1
      } else throw new JediException("Inputs to || must be Booles")
    }
    Boole(result)
  }
}