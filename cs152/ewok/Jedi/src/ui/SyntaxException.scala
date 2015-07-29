/*
Eric Tam
007989423
CS-152
*/
package ui
import scala.util.parsing.combinator._

class SyntaxException(val result: Parsers#Failure = null) extends JediException("Syntax error") {}