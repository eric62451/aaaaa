/*
Eric Tam
007989423
CS 152
Function Lab 1-4
*/

object session {

  def inc(x: Double) = x + 1                      //> inc: (x: Double)Double
  def double(x: Double) = 2 * x                   //> double: (x: Double)Double

  // PROBLEM 1
  def compose[T](f: T => T, g: T => T) = {
    def a(x: T) = {
      f(g(x))
    }
    a _
  }                                               //> compose: [T](f: T => T, g: T => T)T => T

  compose(inc, double)(1)                         //> res0: Double = 3.0
  compose(inc, double)(100)                       //> res1: Double = 201.0
  compose(inc, double)(2)                         //> res2: Double = 5.0
  compose(inc, double)(-5)                        //> res3: Double = -9.0

  def selfIter[T](f: T => T, n: Int) = {
    def r(x: T) = {
      var b = x
      for (i <- 0 to n - 1) {
        b = f(b)
      }
      b
    }
    r _
  }                                               //> selfIter: [T](f: T => T, n: Int)T => T

  selfIter(inc, 0)(1)                             //> res4: Double = 1.0
  selfIter(double, 3)(100)                        //> res5: Double = 800.0
  selfIter(inc, 5)(2)                             //> res6: Double = 7.0
  selfIter(inc, 50)(-5)                           //> res7: Double = 45.0

  // PROBLEM 3
  def countPass[T](x: Array[T], y: T => Boolean) = {
    var count = 0
    for (i <- x) {
      if (y(i)) count = count + 1
    }
    count
  }                                               //> countPass: [T](x: Array[T], y: T => Boolean)Int

  def test(x: Int) = {
    if (x > 5) true
    else false
  }                                               //> test: (x: Int)Boolean

  countPass(Array(1, 2, 3, 20), test)             //> res8: Int = 1

  // PROBLEM 4
  def makeAccount(initBalance: Double = 0.0) = {
    var balance = initBalance
    var delegate: (String) => String = (y: String) => "error"
    def dispatch(msg: String)(amt: Double): String = {
    if(msg == "withdraw"){
    	balance = balance - amt
      "$" + (balance)
      } else if(msg == "deposit"){
      balance = balance + amt
      "$" + (balance)
      } else if(msg == "get balance"){
      "$" + (balance)
      } else delegate(msg)
    }
    dispatch _
  }                                               //> makeAccount: (initBalance: Double)String => (Double => String)

  val savings = makeAccount(100)                  //> savings  : String => (Double => String) = <function1>
  val checking = makeAccount(200)                 //> checking  : String => (Double => String) = <function1>
  println(savings("withdraw")(30))                //> $70.0
	println(savings("transfer")(30))          //> error
}