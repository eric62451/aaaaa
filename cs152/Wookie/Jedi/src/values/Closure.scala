/*
Eric Tam
007989423
CS-152
*/
package values

import expressions._
import ui._

class Closure(params: List[Identifier], body: Expression, defEnv: Environment) extends Value {
  def apply(args: List[Value]): Value = {
    var env2 = new Environment(defEnv)
    if (args.length != params.length) throw new TypeException("Number of arguments does not match number of parameters")
    env2.put(params, args)
    body.execute(env2)
  }
}