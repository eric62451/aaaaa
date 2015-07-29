package expressions

import values._
import ui._

case class Iteration(val condition: Expression, val body: Expression) extends SpecialForm{
	def execute(env: Environment): Value = {
	  var result = Notification.UNKNOWN.asInstanceOf[Value]
	  if(!condition.execute(env).isInstanceOf[Boole]) throw new JediException("While condition must be a Boolean")
	  else{
	    while(condition.execute(env).asInstanceOf[Boole].value){
	      result = body.execute(env)
	    }
	  }
	  result
	}
}