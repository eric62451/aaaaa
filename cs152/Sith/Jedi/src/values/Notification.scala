/*
Eric Tam
007989423
CS-152
*/
package values

class Notification(val msg: String) extends Value{
	override def toString() = msg.toString()
}

object Notification{
  val OK = new Notification("OK")
  val VARIABLEUPDATED = new Notification("variable updated")
  val BINDINGCREATED = new Notification("binding created")
  val ERROR = new Notification("error")
  val UNKNOWN = new Notification("unknown")
  
}