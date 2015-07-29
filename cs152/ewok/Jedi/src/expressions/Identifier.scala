/*
Eric Tam
007989423
CS-152
*/
package expressions
import values._
import ui._

import ui.UndefinedException
import javax.management.Notification

case class Identifier(val name: String) extends Expression with Serializable {

  def execute(env: Environment): Value = {
    var temp = env.find(this)
    if (temp == values.Notification.UNKNOWN) throw new UndefinedException("Undefined Identifier: "+name)
    else temp
  }

}