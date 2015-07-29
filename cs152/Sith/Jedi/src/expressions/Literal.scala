/*
Eric Tam
007989423
CS-152
*/
package expressions
import values._

class Literal() extends Expression with Value {
  def execute(env: Environment): Value = this
}