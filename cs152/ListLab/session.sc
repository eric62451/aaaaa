/*
Eric Tam
007989423
CS-152
ListLab
*/

object session {
  // PROBLEM 1
  def cubeOddSumsIter(list: List[Int]) = {
    var a = 0
    for (i <- list) {
      if (i % 2 == 1) a = a + (i * i * i)
    }
    a
  }                                               //> cubeOddSumsIter: (list: List[Int])Int
  cubeOddSumsIter(List(1, 2, 3, 4, 5, 6))         //> res0: Int = 153
  cubeOddSumsIter(List(1, 2, 3, 7, 5, 1))         //> res1: Int = 497
  cubeOddSumsIter(List(2, 4, 6, 8, 10))           //> res2: Int = 0
  cubeOddSumsIter(List(1, 3, 5, 7, 9))            //> res3: Int = 1225

  def cubeOddSumsRecur(list: List[Int]): Int = {
    var a = 0;
    if (list.isEmpty) a
    else if (list.head % 2 == 1) {
      a = list.head * list.head * list.head
      a + cubeOddSumsRecur(list.tail)
    } else a + cubeOddSumsRecur(list.tail)

  }                                               //> cubeOddSumsRecur: (list: List[Int])Int
  cubeOddSumsRecur(List(1, 2, 3, 4, 5, 6))        //> res4: Int = 153
  cubeOddSumsRecur(List(1, 2, 3, 7, 5, 1))        //> res5: Int = 497
  cubeOddSumsRecur(List(2, 4, 6, 8, 10))          //> res6: Int = 0
  cubeOddSumsRecur(List(1, 3, 5, 7, 9))           //> res7: Int = 1225

  def cubeOddSumsTailRecur(list: List[Int]) = {
    def helper(list: List[Int], total: Int): Int = {
      if (list.isEmpty) total
      else if (list.head % 2 == 1) helper(list.tail, total + (list.head * list.head * list.head))
      else helper(list.tail, total)
    }
    helper(list, 0)
  }                                               //> cubeOddSumsTailRecur: (list: List[Int])Int
  cubeOddSumsTailRecur(List(1, 2, 3, 4, 5, 6))    //> res8: Int = 153
  cubeOddSumsTailRecur(List(1, 2, 3, 7, 5, 1))    //> res9: Int = 497
  cubeOddSumsTailRecur(List(2, 4, 6, 8, 10))      //> res10: Int = 0
  cubeOddSumsTailRecur(List(1, 3, 5, 7, 9))       //> res11: Int = 1225

  def cubeOddSumsMFR(list: List[Int]) = {
    def filt(a: Int) = a % 2 == 1
    def mp(a: Int) = a * a * a
    var b = list.filter(filt)
    b = b.map(mp)
    if (b.nonEmpty) b.reduceLeft(_ + _)
    else 0
  }                                               //> cubeOddSumsMFR: (list: List[Int])Int
  cubeOddSumsMFR(List(1, 2, 3, 4, 5, 6))          //> res12: Int = 153
  cubeOddSumsMFR(List(1, 2, 3, 7, 5, 1))          //> res13: Int = 497
  cubeOddSumsMFR(List(2, 4, 6, 8, 10))            //> res14: Int = 0
  cubeOddSumsMFR(List(1, 3, 5, 7, 9))             //> res15: Int = 1225

  // PROBLEM 2
  def sumsOfSumsIter(list: List[List[Int]]) = {
    var ans = 0
    for (i <- list) {
      for (j <- i) {
        ans = ans + j
      }
    }
    ans
  }                                               //> sumsOfSumsIter: (list: List[List[Int]])Int
  sumsOfSumsIter(List(List(1, 2, 3, 4), List(9, 10, 11, 12), List(-1, 2)))
                                                  //> res16: Int = 53
  sumsOfSumsIter(List(List(1, 8, 3, 20), List(0, 10, 11, 7), List(-1, 2)))
                                                  //> res17: Int = 61
  sumsOfSumsIter(List(List(), List(), List()))    //> res18: Int = 0
  sumsOfSumsIter(List(List(1, 2, 3)))             //> res19: Int = 6

  def sumsOfSumsRecur(list: List[List[Int]]) = {
    var a = 0
    for (i <- list.head) {
      a = a + i
    }
    if (list.nonEmpty) a + sumsOfSumsIter(list.tail)
    else a
  }                                               //> sumsOfSumsRecur: (list: List[List[Int]])Int
  sumsOfSumsRecur(List(List(1, 2, 3, 4), List(9, 10, 11, 12), List(-1, 2)))
                                                  //> res20: Int = 53
  sumsOfSumsRecur(List(List(1, 8, 3, 20), List(0, 10, 11, 7), List(-1, 2)))
                                                  //> res21: Int = 61
  sumsOfSumsRecur(List(List(), List(), List()))   //> res22: Int = 0
  sumsOfSumsRecur(List(List(1, 2, 3)))            //> res23: Int = 6

  def sumsOfSumsTailRecur(list: List[List[Int]]) = {
    def helper(b: List[List[Int]], total: Int): Int = {
      var a = 0
      for (i <- b.head) {
        a = a + i
      }
      if (b.tail.nonEmpty) helper(b.tail, total + a)
      else total + a
    }
    helper(list, 0)
  }                                               //> sumsOfSumsTailRecur: (list: List[List[Int]])Int
  sumsOfSumsTailRecur(List(List(1, 2, 3, 4), List(9, 10, 11, 12), List(-1, 2)))
                                                  //> res24: Int = 53
  sumsOfSumsTailRecur(List(List(1, 8, 3, 20), List(0, 10, 11, 7), List(-1, 2)))
                                                  //> res25: Int = 61
  sumsOfSumsTailRecur(List(List(), List(), List()))
                                                  //> res26: Int = 0
  sumsOfSumsTailRecur(List(List(1, 2, 3)))        //> res27: Int = 6

  def sumsOfSumsMFR(list: List[List[Int]]) = {
    def mp(a: List[Int]) = {
      var b = 0
      for (i <- a) {
        b = b + i
      }
      b
    }
    var ans = list.map(mp)
    ans.reduceLeft(_ + _)
  }                                               //> sumsOfSumsMFR: (list: List[List[Int]])Int
  sumsOfSumsMFR(List(List(1, 2, 3, 4), List(9, 10, 11, 12), List(-1, 2)))
                                                  //> res28: Int = 53
  sumsOfSumsMFR(List(List(1, 8, 3, 20), List(0, 10, 11, 7), List(-1, 2)))
                                                  //> res29: Int = 61
  sumsOfSumsMFR(List(List(), List(), List()))     //> res30: Int = 0
  sumsOfSumsMFR(List(List(1, 2, 3)))              //> res31: Int = 6

  // PROBLEM 3
  def depth(x: Any): Int = {
    x match {
      case Nil => 1
      case v: List[Any] => {
        var a = 0
        var b = 0
        for (i <- v) {
          b = 1 + depth(i)
          a = Math.max(a, b)
        }
        a
      }
      case _ => 0
    }
  }                                               //> depth: (x: Any)Int
  depth(List(List(1, 2), 1, List(2)))             //> res32: Int = 2
  depth(List(List(List(1, 2, List(3)))))          //> res33: Int = 4
  depth(List(1))                                  //> res34: Int = 1
  depth(List())                                   //> res35: Int = 1

  // PROBLEM 6
  def test(a: Int) = a > 10                       //> test: (a: Int)Boolean

  def countSatisfyIter[T](list: List[T], predicate: T => Boolean) = {
    var count = 0
    for (i <- list) if (predicate(i)) count = count + 1
    count
  }                                               //> countSatisfyIter: [T](list: List[T], predicate: T => Boolean)Int
  countSatisfyIter(List(1, 11, 12, 13, 14), test) //> res36: Int = 4
  countSatisfyIter(List(1, 0, 1, 5, 3), test)     //> res37: Int = 0
  countSatisfyIter(List(14, 14, 14, 14, 14), test)//> res38: Int = 5
  countSatisfyIter(List(), test)                  //> res39: Int = 0

  def countSatisfyRecur[T](list: List[T], predicate: T => Boolean): Int = {
    if (list.nonEmpty) {
      if (predicate(list.head)) 1 + countSatisfyRecur(list.tail, predicate)
      else 0 + countSatisfyRecur(list.tail, predicate)
    } else 0
  }                                               //> countSatisfyRecur: [T](list: List[T], predicate: T => Boolean)Int
  countSatisfyRecur(List(1, 11, 12, 13, 14), test)//> res40: Int = 4
  countSatisfyRecur(List(1, 0, 1, 5, 3), test)    //> res41: Int = 0
  countSatisfyRecur(List(14, 14, 14, 14, 14), test)
                                                  //> res42: Int = 5
  countSatisfyRecur(List(), test)                 //> res43: Int = 0

  def countSatisfyTailRecur[T](list: List[T], predicate: T => Boolean) = {
    def Helper(b: List[T], predicate: T => Boolean, total: Int): Int = {
      if (b.nonEmpty) {
        if (predicate(b.head)) Helper(b.tail, predicate, total + 1)
        else Helper(b.tail, predicate, total)
      } else total
    }
    Helper(list, predicate, 0)
  }                                               //> countSatisfyTailRecur: [T](list: List[T], predicate: T => Boolean)Int
  countSatisfyTailRecur(List(1, 11, 12, 13, 14), test)
                                                  //> res44: Int = 4
  countSatisfyTailRecur(List(1, 0, 1, 5, 3), test)//> res45: Int = 0
  countSatisfyTailRecur(List(14, 14, 14, 14, 14), test)
                                                  //> res46: Int = 5
  countSatisfyTailRecur(List(), test)             //> res47: Int = 0

  def countSatisfyMFR[T](list: List[T], predicate: T => Boolean) = {
    def mp(a: T) = {
      if (predicate(a)) 1
      else 0
    }
    var b = list.map(mp)
    if (b.nonEmpty) b.reduce(_ + _)
    else 0
  }                                               //> countSatisfyMFR: [T](list: List[T], predicate: T => Boolean)Int
  countSatisfyMFR(List(1, 11, 12, 13, 14), test)  //> res48: Int = 4
  countSatisfyMFR(List(1, 0, 1, 5, 3), test)      //> res49: Int = 0
  countSatisfyMFR(List(14, 14, 14, 14, 14), test) //> res50: Int = 5
  countSatisfyMFR(List(), test)                   //> res51: Int = 0

  // PROBLEM 7
  def satisfyAllIter[T](list: List[T], predicate: T => Boolean) = {
    var ans = true
    for (i <- list) {
      ans = ans && predicate(i)
    }
    ans
  }                                               //> satisfyAllIter: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAllIter(List(1, 1, 1, 1, 1), test)       //> res52: Boolean = false
  satisfyAllIter(List(1, 0, 1, 5, 14), test)      //> res53: Boolean = false
  satisfyAllIter(List(14, 14, 14, 14, 14), test)  //> res54: Boolean = true
  satisfyAllIter(List(), test)                    //> res55: Boolean = true

  def satisfyAllRecur[T](list: List[T], predicate: T => Boolean): Boolean = {
    if (list.nonEmpty) {
      if (predicate(list.head)) true && satisfyAllRecur(list.tail, predicate)
      else false && satisfyAllRecur(list.tail, predicate)
    } else true
  }                                               //> satisfyAllRecur: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAllRecur(List(1, 1, 1, 1, 1), test)      //> res56: Boolean = false
  satisfyAllRecur(List(1, 0, 1, 5, 14), test)     //> res57: Boolean = false
  satisfyAllRecur(List(14, 14, 14, 14, 14), test) //> res58: Boolean = true
  satisfyAllRecur(List(), test)                   //> res59: Boolean = true

  def satisfyAllTailRecur[T](list: List[T], predicate: T => Boolean) = {
    def Helper(list: List[T], predicate: T => Boolean, answer: Boolean): Boolean = {
      if (list.nonEmpty) {
        if (predicate(list.head)) Helper(list.tail, predicate, answer && true)
        else Helper(list.tail, predicate, answer && false)
      } else answer
    }
    Helper(list, predicate, true)
  }                                               //> satisfyAllTailRecur: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAllTailRecur(List(1, 1, 1, 1, 1), test)  //> res60: Boolean = false
  satisfyAllTailRecur(List(1, 0, 1, 5, 14), test) //> res61: Boolean = false
  satisfyAllTailRecur(List(14, 14, 14, 14, 14), test)
                                                  //> res62: Boolean = true
  satisfyAllTailRecur(List(), test)               //> res63: Boolean = true

  def satisfyAllMFR[T](list: List[T], predicate: T => Boolean) = {
    def mp(a: T) = predicate(a)
    var b = list.map(mp)
    if (b.nonEmpty) b.reduce(_ && _)
    else true
  }                                               //> satisfyAllMFR: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAllMFR(List(1, 1, 1, 1, 1), test)        //> res64: Boolean = false
  satisfyAllMFR(List(1, 0, 1, 5, 14), test)       //> res65: Boolean = false
  satisfyAllMFR(List(14, 14, 14, 14, 14), test)   //> res66: Boolean = true
  satisfyAllMFR(List(), test)                     //> res67: Boolean = true

  // PROBLEM 8
  def satisfyAnyIter[T](list: List[T], predicate: T => Boolean) = {
    var ans = false
    for (i <- list) {
      ans = ans || predicate(i)
    }
    ans
  }                                               //> satisfyAnyIter: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAnyIter(List(1, 1, 1, 1, 1), test)       //> res68: Boolean = false
  satisfyAnyIter(List(1, 0, 1, 5, 14), test)      //> res69: Boolean = true
  satisfyAnyIter(List(14, 14, 14, 14, 14), test)  //> res70: Boolean = true
  satisfyAnyIter(List(), test)                    //> res71: Boolean = false

  def satisfyAnyRecur[T](list: List[T], predicate: T => Boolean): Boolean = {
    if (list.nonEmpty) {
      if (predicate(list.head)) true || satisfyAnyRecur(list.tail, predicate)
      else false || satisfyAnyRecur(list.tail, predicate)
    } else false
  }                                               //> satisfyAnyRecur: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAnyRecur(List(1, 1, 1, 1, 1), test)      //> res72: Boolean = false
  satisfyAnyRecur(List(1, 0, 1, 5, 14), test)     //> res73: Boolean = true
  satisfyAnyRecur(List(14, 14, 14, 14, 14), test) //> res74: Boolean = true
  satisfyAnyRecur(List(), test)                   //> res75: Boolean = false

  def satisfyAnyTailRecur[T](list: List[T], predicate: T => Boolean) = {
    def Helper(list: List[T], predicate: T => Boolean, answer: Boolean): Boolean = {
      if (list.nonEmpty) {
        if (predicate(list.head)) Helper(list.tail, predicate, answer || true)
        else Helper(list.tail, predicate, answer || false)
      } else answer
    }
    Helper(list, predicate, false)
  }                                               //> satisfyAnyTailRecur: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAnyTailRecur(List(1, 1, 1, 1, 1), test)  //> res76: Boolean = false
  satisfyAnyTailRecur(List(1, 0, 1, 5, 14), test) //> res77: Boolean = true
  satisfyAnyTailRecur(List(14, 14, 14, 14, 14), test)
                                                  //> res78: Boolean = true
  satisfyAnyTailRecur(List(), test)               //> res79: Boolean = false
  
  def satisfyAnyMFR[T](list: List[T], predicate: T => Boolean) = {
    def mp(a: T) = predicate(a)
    var b = list.map(mp)
    if (b.nonEmpty) b.reduce(_ || _)
    else false
  }                                               //> satisfyAnyMFR: [T](list: List[T], predicate: T => Boolean)Boolean
  satisfyAnyMFR(List(1, 1, 1, 1, 1), test)        //> res80: Boolean = false
  satisfyAnyMFR(List(1, 0, 1, 5, 14), test)       //> res81: Boolean = true
  satisfyAnyMFR(List(14, 14, 14, 14, 14), test)   //> res82: Boolean = true
  satisfyAnyMFR(List(), test)                     //> res83: Boolean = false
}