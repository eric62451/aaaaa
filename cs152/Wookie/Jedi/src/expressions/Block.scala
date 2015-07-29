package expressions

import values._
import ui._

case class Block(locals: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    var env2 = new Environment(env)
    for (i <- 0 to locals.length - 1) {
      locals(i).execute(env2)
    }
    if (locals.length == 0) throw new JediException("Block cannot be empty")
    locals(locals.length-1).execute(env2)
  }
}