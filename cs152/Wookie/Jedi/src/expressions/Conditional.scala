/*
Eric Tam
007989423
CS-152
*/

package expressions
import values._
import ui._

case class Conditional(condition: Expression, consequent: Expression, alternate: Expression = null) extends SpecialForm {
	def execute(env: Environment): Value = {
	  if(!condition.execute(env).isInstanceOf[Boole]) throw new JediException("condition has to be a boole")
	  if(alternate == null){
	    if(condition.execute(env).asInstanceOf[Boole].value) consequent.execute(env)
	    else Notification.UNKNOWN 
	  } else if(condition.execute(env).asInstanceOf[Boole].value) consequent.execute(env)
		  else alternate.execute(env)
	  
	}
}