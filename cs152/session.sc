/*
Eric Tam
007989423
CS152
Jon Pearce
String Lab
*/

import scala.util.Random

object session {

  //PROBLEM 1 and 2
  def isPal(a: String) = {
    var b = a.toLowerCase()
    b = b.replaceAll("[^a-zA-Z0-9]", "")
    //val sub = b.length / 2
    //var odd = 0
    //if (b.length % 2 != 0) odd = 1
    if (b == b.reverse) true
    else false
  }                                               //> isPal: (a: String)Boolean

  isPal("a")                                      //> res0: Boolean = true
  isPal("abc")                                    //> res1: Boolean = false
  isPal("aba")                                    //> res2: Boolean = true
  isPal("pop")                                    //> res3: Boolean = true
  isPal("Rotato.,.,/./ r")                        //> res4: Boolean = true
  isPal("A man, a plan, a canal, Panama!")        //> res5: Boolean = true
  isPal("aaa")                                    //> res6: Boolean = true
  isPal("")                                       //> res7: Boolean = true

  //PROBLEM 3
  def mkPal(a: String) = {
    a + a.reverse
  }                                               //> mkPal: (a: String)String

  mkPal("mars")                                   //> res8: String = marssram

  //PROBLEM 4
  def mkWord(a: Int = 10) = {
    val ran = new Random()
    var word = ""
    var b = a
    for (i <- 0 to b-1) {
      word = word + (ran.nextInt(26) + 97).toChar
    }
    word
  }                                               //> mkWord: (a: Int)String

  mkWord(5)                                       //> res9: String = yzmwu
  mkWord(20)                                      //> res10: String = cdpligdtpsljtnpibvhg
  mkWord()                                        //> res11: String = ngqazzzgcy

  //PROBLEM 5
  def mkSentence(a: Int = 10) = {
    val ran = new Random()
    var sentence = ""
    var b = a
    for (i <- 0 to b - 1) {
    	if(sentence != "") sentence = sentence + " "
      sentence = sentence + mkWord(ran.nextInt(8)+1)
    }
    sentence = sentence.capitalize + "."
    sentence
  }                                               //> mkSentence: (a: Int)String

  mkSentence(5)                                   //> res12: String = Trjs yrglibik tpr v vhoeqw.
  mkSentence()                                    //> res13: String = Rwnqp pzmchve slz r mjacqp aimys iyhgvtw yvtix rtydhwcj iju
                                                  //| gndz.
  mkSentence()                                    //> res14: String = Exp nnayri gkuh klk oe p azrh foqk eugbwjm wegmmx.
  mkSentence()                                    //> res15: String = Cr xyv tf o opumc czlw qrmkimhf hjztel ojc pfryx.

  //PROBLEM 6
  def shuffle(a: String) = {
    a.drop(a.length/2) + a.take(a.length / 2)
  }                                               //> shuffle: (a: String)String

  shuffle("abcdefghij")                           //> res16: String = fghijabcde
  shuffle("abcdefghijk")                          //> res17: String = fghijkabcde
  shuffle("po")                                   //> res18: String = op
  shuffle("a")                                    //> res19: String = a

  //PROBLEM 7
  def countSubstrings(sub: String, string: String): Int = {
    val answer = string.indexOf(sub)
    if (answer != -1) 1 + countSubstrings(sub, string.substring(answer + sub.length))
    else 0
  }                                               //> countSubstrings: (sub: String, string: String)Int

  countSubstrings("a", "a")                       //> res20: Int = 1
  countSubstrings("is", "Mississippi")            //> res21: Int = 2
  countSubstrings("as", "asasasasasas")           //> res22: Int = 6
  countSubstrings("b", "Mississippi")             //> res23: Int = 0

  //PROBLEM 8 and 9
  def add(a: String) = {
    var array = a.split("\\+")
    if (array(0) == a) throw new Exception("missing operator")
    array(0).toDouble + array(1).toDouble

  }                                               //> add: (a: String)Double

  def mult(a: String) = {
    var array = a.split("\\*")
    if (array(0) == a) throw new Exception("missing operator")
    array(0).toDouble * array(1).toDouble

  }                                               //> mult: (a: String)Double

  def eval(math: String): Double = {
    if (math.contains("+")) add(math)
    else mult(math)

  }                                               //> eval: (math: String)Double

  eval("1+ 2")                                    //> res24: Double = 3.0
  eval("1*1")                                     //> res25: Double = 1.0
  eval(" 1 * 6")                                  //> res26: Double = 6.0
  try {
    eval(" 1a * 6")
  } catch {
    case e: Exception => println("exception caught: " + e);
  }                                               //> exception caught: java.lang.NumberFormatException: For input string: "1a"
                                                  //| res27: AnyVal = ()
  add(" 1 + 1")                                   //> res28: Double = 2.0
  add(" 1 + 13")                                  //> res29: Double = 14.0
  add(" 11+11")                                   //> res30: Double = 22.0
  try {
    add("1 * 1")
  } catch {
    case e: Exception => println("exception caught: " + e);
  }                                               //> exception caught: java.lang.Exception: missing operator
                                                  //| res31: AnyVal = ()
  mult(" 10 * 10 ")                               //> res32: Double = 100.0
  mult("9* 5")                                    //> res33: Double = 45.0
  mult("5*3 ")                                    //> res34: Double = 15.0
  try {
    mult("1 + 1")
  } catch {
    case e: Exception => println("exception caught: " + e);
  }                                               //> exception caught: java.lang.Exception: missing operator
                                                  //| res35: AnyVal = ()
  
  //PROBLEM 10
  def first(a: Array[String]) = {
  var temp = a(0)
  var check = 0
  for(i <- 1 to a.length-1){
  check = temp.compareToIgnoreCase(a(i))
  if(check >= 1) temp = a(i)
  }
  temp
  }                                               //> first: (a: Array[String])String
  
  first(Array("cat", "rat", "bat"))               //> res36: String = bat
  first(Array("zat", "pat", "wat"))               //> res37: String = pat
  first(Array("aat", "aaa", "bat"))               //> res38: String = aaa
  first(Array("foo", "you", "poo"))               //> res39: String = foo
  first(Array("cat", "a", "bat"))                 //> res40: String = a
  first(Array("aaa", "a", "aa"))                  //> res41: String = a
}