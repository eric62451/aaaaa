/*
Eric Tam
007989423
CS152
Jon Pearce
Recursion Lab
*/

object session {
  def inc(n: Int) = n + 1                         //> inc: (n: Int)Int
  def dec(n: Int) = n - 1                         //> dec: (n: Int)Int

  // PROBLEM 1 (1+5) - TAIL RECURSION INCLUDED ORIGINALLY IN PROBLEM 1
  def add(n: Int, m: Int): Int = {
    var ans = 0
    if (m == 0) {
      n
    } else {
      var em = 0
      ans = inc(n)
      em = dec(m)
      add(ans, em)
    }
  }                                               //> add: (n: Int, m: Int)Int

  add(100, 100)                                   //> res0: Int = 200
  add(100, 1)                                     //> res1: Int = 101
  add(1000, 1000)                                 //> res2: Int = 2000
  add(10000, 10000)                               //> res3: Int = 20000

  // PROBLEM 2
  def mul(n: Int, m: Int): Int = {
    if (m == 1) n
    else if (m == 0) 0
    else {
      var em = dec(m)
      var ans = n + mul(n, em)
      ans
    }
  }                                               //> mul: (n: Int, m: Int)Int

  mul(9, 9)                                       //> res4: Int = 81
  mul(1, 0)                                       //> res5: Int = 0
  mul(0, 1)                                       //> res6: Int = 0
  mul(100, 100)                                   //> res7: Int = 10000
  mul(999, 999)                                   //> res8: Int = 998001

  // PROBLEM 2+5
  def mulTR(n: Int, m: Int) = {
    def times(n: Int, m: Int, o: Int): Int = {
      var ans = 0
      if (m == 1) o
      else if (m == 0) 0
      else {
        var em = 0
        ans = add(o, n)
        em = dec(m)
        times(n, em, ans)
      }
    }
    times(n, m, n)
  }                                               //> mulTR: (n: Int, m: Int)Int

  mulTR(10000, 10000)                             //> res9: Int = 100000000
  mulTR(99, 10000)                                //> res10: Int = 990000
  mulTR(10000, 6)                                 //> res11: Int = 60000
  mulTR(10000, 0)                                 //> res12: Int = 0

  // PROBLEM 3
  def exp2(m: Int): Int = {
    if (m == 0) 1
    else mul(2, exp2(dec(m)))
  }                                               //> exp2: (m: Int)Int

  exp2(2)                                         //> res13: Int = 4
  exp2(1)                                         //> res14: Int = 2
  exp2(3)                                         //> res15: Int = 8
  exp2(0)                                         //> res16: Int = 1

  // PROBLEM 3+5
  def exp2TR(m: Int) = {
    def exp2Helper(m: Int, ans: Int): Int = {
      if (m == 0) 1
      else if (m == 1) ans
      else exp2Helper(dec(m), mulTR(2, ans))
    }
    exp2Helper(m, 2)
  }                                               //> exp2TR: (m: Int)Int

  exp2TR(2)                                       //> res17: Int = 4
  exp2TR(1)                                       //> res18: Int = 2
  exp2TR(3)                                       //> res19: Int = 8
  exp2TR(0)                                       //> res20: Int = 1

  // PROBLEM 4
  def hyperExp(m: Int): Int = {
    if (m == 0) 2
    else exp2TR(hyperExp(dec(m)))
  }                                               //> hyperExp: (m: Int)Int

  hyperExp(2)                                     //> res21: Int = 16
  hyperExp(3)                                     //> res22: Int = 65536
  hyperExp(1)                                     //> res23: Int = 4
  hyperExp(0)                                     //> res24: Int = 2

  // PROBLEM 4+5
  def hyperExpTR(m: Int) = {
    def HyperHelper(m: Int, a: Int): Int = {
      if (m == 0) a
      else {
        val ans = exp2TR(a)
        val em = dec(m)
        HyperHelper(em, ans)
      }
    }
    HyperHelper(m, 2)
  }                                               //> hyperExpTR: (m: Int)Int

  hyperExpTR(2)                                   //> res25: Int = 16
  hyperExpTR(3)                                   //> res26: Int = 65536
  hyperExpTR(1)                                   //> res27: Int = 4
  hyperExpTR(0)                                   //> res28: Int = 2

  // PROBLEM 6
  def tri(n: Int) = {
    (n * (n + 1)) / 2
  }                                               //> tri: (n: Int)Int

  tri(100)                                        //> res29: Int = 5050
  tri(1)                                          //> res30: Int = 1
  tri(5)                                          //> res31: Int = 15
  tri(8)                                          //> res32: Int = 36

  // PROBLEM 7
  def repl {
    var cmmd = ""
    var first = 0.0
    var second = 0.0
    var answer = ""
    var continue = true

    cmmd = readLine("Operator -> ")
    if (cmmd == "quit") {
      println("Bye")
      continue = false
    } else if (cmmd.length == 1 && "+-*/".contains(cmmd)) {
      print("Enter first number -> ")
      first = readDouble()
      print("Enter second number -> ")
      second = readDouble()
      if (cmmd == "+") println(first + second)
      else if (cmmd == "-") println(first - second)
      else if (cmmd == "*") println(first * second)
      else if (cmmd == "/") println(first / second)
    } else println("Invalid operator, use +,-,*,/ or quit")
    if (continue) repl
  }                                               //> repl: => Unit

}