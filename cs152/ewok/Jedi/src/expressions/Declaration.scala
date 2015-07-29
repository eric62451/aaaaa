/*
Eric Tam
007989423
CS-152
*/

package expressions
import values._

case class Declaration(val iden: Identifier, val exp: Expression) extends SpecialForm {
	def execute(env: Environment): Value = {
	  env.put(iden,exp.execute(env))
	  Notification.OK
	}
}