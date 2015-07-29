package ui

import expressions._
import values._

object system {
  
  def execute(opcode: Identifier, args: List[Value]): Value = {
    opcode.name match {
      case "add" => add(args)
      case "sub" => sub(args)
      case "div" => div(args)
      case "mul" => mul(args)
      case "equals" => equals(args)
      case "less" => less(args)
      case "not" => not(args)
      // mul, sub, div, equals, less, etc.
      case _ => throw new UndefinedException(opcode.name)
    }
  }

  private def add(vals: List[Value]): Value = {
    if (vals.isEmpty) throw new TypeException("addition expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Number])
    if (ok.length < vals.length) throw new TypeException("all addition inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Number])
    args2.reduce(_+_)
  }

  private def mul(vals: List[Value]): Value = {
    if (vals.isEmpty) throw new TypeException("multiplication expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Number])
    if (ok.length < vals.length) throw new TypeException("all multiplication inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Number])
    args2.reduce(_*_)
  }
  
  private def sub(vals: List[Value]): Value = {
    if (vals.isEmpty) throw new TypeException("subtaction expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Number])
    if (ok.length < vals.length) throw new TypeException("all subtraction inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Number])
    args2.reduce(_-_)
  }
  
  private def equals(vals: List[Value]): Value = {
    if (vals.isEmpty) throw new TypeException("equals expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Number])
    if (ok.length < vals.length) throw new TypeException("all inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Number])
    var answer = new Boole(true)
    for(i <- 1 to args2.length-1){
      answer = answer&&(args2(0)==args2(i))
    }
    answer
  }
  
  private def less(vals: List[Value]): Value = {
    if (vals.isEmpty) throw new TypeException("less expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Number])
    if (ok.length < vals.length) throw new TypeException("all inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Number])
    var answer = new Boole(true)
    for(i <- 1 to args2.length-1){
      answer = answer&&(args2(i-1)<args2(i))
    }
    answer
  }
  
  private def div(vals: List[Value]): Value = {
    if (vals.isEmpty) throw new TypeException("division expects > 0 inputs")
    val ok = vals.filter(_.isInstanceOf[Number])
    if (ok.length < vals.length) throw new TypeException("all division inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Number])
    args2.reduce(_/_)
  }
  
  private def not(vals: List[Value]): Value = {
    if (vals.length != 1) throw new TypeException("not expects 1 inputs")
    val ok = vals.filter(_.isInstanceOf[Boole])
    if (ok.length < vals.length) throw new TypeException("all division inputs must be numbers")
    val args2 = vals.map(_.asInstanceOf[Boole])
    args2(0)!
  }
  
  def test(){
    val globalEnv = new Environment()
    val num1 = new Number(100.0)
    val num2 = new Number(42.0)
    val b = new Number(100.0)
    val c = new Number(100.0)
    val d = new Number(104.0)
    val e = new Number(1.0)
    val bool1 = new Boole(true)
    val id1 = new Identifier("x")
    val id2 = new Identifier("y")
    val id3 = new Identifier("z")
    globalEnv.put(List(id1, id2, id3), List(num1, num2, bool1))
    var a = List(num1,num2)
    
    println("System test")
    var op = new Identifier("add")
    println("... Expected: 142.0 Actual: " + execute(op, a))
    op = new Identifier("div")
    println("... Expected: 2.3809 Actual: "+ execute(op, a))
    op = new Identifier("sub")
    println("... Expected: 58.0 Actual: "+execute(op, a))
    op = new Identifier("mul")
    println("... Expected: 4200.0 Actual: "+execute(op, a))
    op = new Identifier("less")
    println("... Expected: false Actual: "+execute(op, a))
    println("... Expected: true Actual: "+execute(op, List(e,num2,num1,d)))
    println("... Expected: false Actual: "+execute(op, List(e,num2,d,num1)))
    op = new Identifier("equals")
    println("... Expected: false Actual: "+execute(op, a))
    println("... Expected: true Actual: "+execute(op, List(num1,b,c)))
    println("... Expected: true Actual: "+execute(op, List(num1,c,b)))
    println("... Expected: false Actual: "+execute(op, List(num1,num2,c)))
    println("... Expected: true Actual: "+execute(op, List(num1)))
    op = new Identifier("not")
    println("... Expected: false Actual: "+execute(op, List(bool1)))
    println("")
  }
  // etc.
}