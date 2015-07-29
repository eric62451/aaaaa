/*
Eric Tam
007989423
CS-152
*/
package expressions
import values._
import ui._

case class FunCall(op: Expression, args: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
    var temp = args.map(_.execute(env))
    try{
      if(op.execute(env).isInstanceOf[Closure]) op.execute(env).asInstanceOf[Closure].apply(temp)
      else if(op.isInstanceOf[FunCall]) system.execute(op.asInstanceOf[FunCall].op.asInstanceOf[Identifier], temp)
      else throw new UndefinedException
    }catch{
      case e: UndefinedException => system.execute(op.asInstanceOf[Identifier], temp)
    }
  }
}