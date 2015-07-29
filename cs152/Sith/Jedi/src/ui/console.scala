/*
Eric Tam
007989423
CS-152
*/
package ui

import values._
import expressions._
import scala.util.parsing.combinator._

object console {
  val parsers = new SithParsers // for now
  val globalEnv = new Environment()

  def execute(cmmd: String): String = {
    val tree = parsers.parseAll(parsers.expression, cmmd)
    tree match {
      case t: parsers.Failure => throw new SyntaxException(t)
      case _ => "" + tree.get.execute(globalEnv)
    }
  }

  def repl {
    var more = true // declare locals
    var read = ""
    while (more) {
      try {
        read = readLine("-> "); // read/execute/print
        if (read == "quit") {
          println("Bye")
          more = false
        } else{
          println(execute(read))
        }
      } catch {
        case e: SyntaxException => {
          println(e.msg)
          println(e.result.msg)
          println("line # = " + e.result.next.pos.line)
          println("column # = " + e.result.next.pos.column)
          println("token = " + e.result.next.first) 
        }
        case e: UndefinedException => {
          println(e.msg)
        }
        // handle other types of exceptions
      } finally {
        Console.flush
      }
    }
  }

  def main(args: Array[String]): Unit = { repl }
}