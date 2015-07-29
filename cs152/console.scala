/*
Eric Tam
007989423
CS152
Jon Pearce
Console Lab
*/

import sun.org.mozilla.javascript.internal.regexp.SubString

class UnrecognzizedCommandException extends Exception {}

object console {
   def execute(cmmd: String): String = {
     var a = cmmd.split("\\s+")
     try{
     if(a(0) == "add") a(1).toDouble + a(2).toDouble + ""
     else if(a(0) == "mul") a(1).toDouble * a(2).toDouble + ""
     else if(a(0) == "sub") a(1).toDouble - a(2).toDouble + ""
     else if(a(0) == "div") a(1).toDouble / a(2).toDouble + ""
     else throw new UnrecognzizedCommandException()
     }catch{
       case e: NumberFormatException => "invalid argument: " + e.toString().substring(e.toString().indexOf("\"")+1, e.toString().indexOf("\"", e.toString().indexOf("\"")+1))
       case e: UnrecognzizedCommandException => "Unrecognized command: " + a(0)
       
     }
     
   }
   
   def repl {
     var cmmd = ""
     var answer = ""
     var continue = true
     while(continue){
       cmmd = readLine("-> ");
       if(cmmd == "quit"){
         println("Bye")
         continue = false
       } else if(cmmd == "help")
         println("commands: add, mul, sub, div, quit, help")
         else println(execute(cmmd))
     }
   }
   
   def main(args: Array[String]): Unit = { repl }
}