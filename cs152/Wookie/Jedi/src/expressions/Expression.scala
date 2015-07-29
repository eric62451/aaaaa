/*
Eric Tam
007989423
CS-152
*/

package expressions
import values._
trait Expression {
def execute(env : Environment):Value
}