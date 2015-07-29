/*
Eric Tam
007989423
CS-152
*/
package values
import scala.collection.mutable
import ui._
import scala.collection.mutable.HashMap
import expressions._

class Environment(val nextEnv: Environment = null) extends mutable.HashMap[Identifier, Value] with Value {
  def put(names: List[Identifier], vals: List[Value]) {
    if (names.length == vals.length) {
      for (i: Int <- 0 to names.length - 1) {
        put(names(i), vals(i))
      }
    } else throw new TypeException("too few identifiers");
  }
  def find(fnd: Identifier): Value = {
    if (this.contains(fnd)) {
      this(fnd)
    } else if (nextEnv != null) {
      nextEnv.find(fnd)
    } else
      Notification.UNKNOWN

  }

}

object Environment{
  def test{
    var a = new Environment()
    val n1 = new Identifier("n1")
    val n2 = new Identifier("n2")
    val m1 = new Number(1)
    val m2 = new Number(2)
    
    a.put(List(n1,n2), List(m1,m2))
    var b = new Environment(a)
    b. put(List(n2,n1),List(m1))
    
    println("Environment test")
    println("Expected 1 Actual: "+ b.find(n1))
    println("Expected 2 Actual: "+ b.find(n2))
    println("Expected Unknown Actual: "+ b.find(new Identifier("a")))
    println("")

    
  }
}