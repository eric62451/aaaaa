/*
Eric Tam
007989423
CS-152
*/
package expressions
import values._
import ui.system

case class FunCall(op: Identifier, args: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
    var temp = args.map(_.execute(env))
    system.execute(op, temp)
  }
}