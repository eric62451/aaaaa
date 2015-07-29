/*
Eric Tam
007989423
CS-152
*/
package ui
import scala.util.parsing.combinator._
import expressions._
import values._

class SithParsers extends RegexParsers {

  val truefalse = """true|false""".r
  val numbers = """(/+|-)?[0-9]+(\.[0-9]+)?""".r
  val alphanum = """[a-zA-Z][a-zA-Z0-9]*""".r

  def declaration: Parser[Expression] = "def" ~ identifier ~ "=" ~ expression ^^
    {
      case "def" ~ id ~ "=" ~ exp => Declaration(id, exp)
    }

  def expression: Parser[Expression] = declaration | conditional | disjunction | failure("Invalid expression")

  def conditional: Parser[Conditional] = "if" ~ "(" ~ expression ~ ")" ~ expression ~ opt("else" ~ expression) ^^
    {
      case "if" ~ "(" ~ exp1 ~ ")" ~ exp2 ~ None => Conditional(exp1, exp2)
      case "if" ~ "(" ~ exp1 ~ ")" ~ exp2 ~ Some("else" ~ exp3) => Conditional(exp1, exp2, exp3)
    }

  def operands: Parser[List[Expression]] = "(" ~> opt(expression ~ rep("," ~> expression)) <~ ")" ^^
    {
      case None => Nil
      case Some(e ~ Nil) => List(e)
      case Some(e ~ exp) => e :: exp
    }

  def funcall: Parser[Expression] = term ~ opt(operands) ^^
    {
      case foo ~ None => foo
      case foo ~ Some(args) => FunCall(foo.asInstanceOf[Expression], args)
      case foo: Literal => throw new JediException
    }

  def inequality: Parser[Expression] = sum ~ rep("<" ~> sum) ^^
    {
      case exp ~ Nil => exp
      case exp ~ expList => FunCall(Identifier("less"), exp :: expList)
    }

  def sum: Parser[Expression] =
    product ~ rep(("+" | "-") ~ product ^^ { case "+" ~ s => s case "-" ~ s => negate(s) }) ^^ {
      case p ~ Nil => p
      case p ~ rest => FunCall(Identifier("add"), p :: rest)
    }

  def product: Parser[Expression] =
    funcall ~ rep(("/" | "*") ~ funcall ^^ { case "*" ~ s => s case "/" ~ s => invert(s) }) ^^ {
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
    FunCall(div, List(one, exp))
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

  def disjunction: Parser[Expression] = conjunction ~ rep("||" ~> conjunction) ^^
    {
      case exp ~ Nil => exp
      case exp ~ expList => Disjunction(exp :: expList)
    }

  def term: Parser[Expression] = assignment | iteration | deref | lambda | block | literal | identifier | "(" ~> expression <~ ")"

  def identifier: Parser[Identifier] = alphanum ^^
    {
      case e => Identifier(e)
    }

  def literal: Parser[Literal] = boole | numeral

  def boole: Parser[Boole] = truefalse ^^
    {
      case e => Boole(e.toBoolean)
    }

  def numeral: Parser[Number] = numbers ^^
    {
      case e => Number(e.toDouble)
    }
  
  def lambda: Parser[Expression] = "lambda"~"("~identifier~rep(","~identifier)~")"~expression^^{
    case "lambda" ~ "(" ~ id ~ Nil ~ ")" ~ exp => Lambda(List(id),exp)
    case "lambda" ~ "(" ~ id ~ id2 ~ ")" ~ exp => Lambda(id::id2.asInstanceOf[List[Identifier]],exp)
    
  }
  
  def block: Parser[Expression] = "{" ~ expression ~ rep(";" ~> expression) ~ "}" ^^
    {
      case "{" ~ exp ~ Nil ~ "}" => Block(List(exp))
      case "{" ~ exp ~ exp2 ~ "}" => Block(exp :: exp2)
    }
  
  def deref: Parser[Expression] = "["~expression~"]"^^
  {
    case "["~exp~"]" => FunCall(Identifier("content"), List(exp))
  }
  
  def assignment: Parser[Expression] = identifier ~ "=" ~ expression^^
  {
    case id ~"=" ~ exp => Assignment(id,exp)
  }
  
  def iteration: Parser[Expression] = "while"~"("~expression~")"~expression^^
  {
    case "while"~"("~exp~")"~exp2 => Iteration(exp,exp2)
  }
  

}