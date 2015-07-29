package expressions

import values._
import ui._

case class Assignment(val id: Identifier, val exp: Expression) extends SpecialForm {
	def execute(env: Environment): Value = {
	  if(!id.execute(env).isInstanceOf[Variable]) throw new JediException("Assignment must be to a Variable")
	  id.execute(env).asInstanceOf[Variable].content = exp.execute(env)
	  new Notification("Done")
	  
	}
}