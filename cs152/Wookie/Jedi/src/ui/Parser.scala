/*
Eric Tam
007989423
CS-152
*/
package ui
import scala.util.parsing.combinator._
import expressions._
import values._

class Parser extends RegexParsers {

  val truefalse = """true|false""".r
  val numbers = """(/+|-)?[0-9]+(\.[0-9]+)?"""".r
  val alphanum = """[a-zA-Z][a-zA-Z0-9]*""".r

  def declaration: Parser[Expression] = "def" ~ identifier ~ "=" ~ expression ^^
    {
      case "def" ~ id ~ "=" ~ exp => Declaration(id, exp)
    }

  def expression: Parser[Expression] = declaration

  def operands: Parser[List[Expression]] = "(" ~> opt(expression~rep("," ~> expression)) <~ ")" ^^
      {
    case None => Nil
    case Some(e ~ Nil) => List(e)
    case Some(e ~ exp) => e::exp
      }

  def funcall: Parser[Expression] = term ~ opt(operands) ^^
  {
    case foo ~ None => foo
    case foo ~ Some(args) => FunCall(foo.asInstanceOf[Identifier],args)
    case foo: Literal => throw new JediException
  }

  def inequality: Parser[Expression] = sum ~ rep("<" ~> sum) ^^
    {
      case exp ~ Nil => exp
      case exp ~ expList => FunCall(Identifier("equals"), exp :: expList)
    }

  def sum: Parser[Expression] =
    product ~ rep(("+" | "-") ~ product ^^ { case "+" ~ s => s case "-" ~ s => negate(s) }) ^^ {
      case p ~ Nil => p
      case p ~ rest => FunCall(Identifier("add"), p :: rest)
    }
  
  def product: Parser[Expression] =
    product ~ rep(("/" | "*") ~ product ^^ { case "*" ~ s => s case "/" ~ s => invert(s) }) ^^ {
      case p ~ Nil => p
      case p ~ rest => FunCall(Identifier("mul"), p :: rest)
    }

  def negate(exp: Expression): Expression = {
    val sub = Identifier("sub")
    val zero = Number(0)
    FunCall(sub, List(zero, exp))
  }

  def invert(exp: Expression): Expression = {
    val div = Identifier("div")
    val one = Number(1)
    FunCall(div,List(one,exp))
  }
  
  def equality: Parser[Expression] = inequality ~ rep("==" ~> inequality) ^^
    {
      case exp ~ Nil => exp
      case exp ~ expList => FunCall(Identifier("equals"), exp :: expList)
    }

  def conjunction: Parser[Expression] = equality ~ rep("&&" ~> equality) ^^
    {
      case exp ~ Nil => exp
      case exp ~ expList => Conjunction(exp :: expList)
    }

  def disjunction: Parser[Expression] = equality ~ rep("||" ~> equality) ^^
    {
      case exp ~ Nil => exp
      case exp ~ expList => Disjunction(exp :: expList)
    }

  def term: Parser[Expression] = literal | identifier | "(" ~> expression <~ ")"

  def identifier: Parser[Identifier] = alphanum ^^
    {
      case e => Identifier(e)
    }

  def literal: Parser[Literal] = boole | numeral

  def boole: Parser[Boole] = truefalse ^^
    {
      case e => Boole(true)
    }

  def numeral: Parser[Number] = numbers ^^
    {
      case e => Number(e.toDouble)
    }

}