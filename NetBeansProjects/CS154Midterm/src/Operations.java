/*
Eric Tam
007989423
CS154
03/18/2015
*/

import java.util.*;
import java.util.function.*;

public class Operations { 

   public static List<String> transform(List<String> msg, UnaryOperator<String> encrypt) {
      List<String> result = new ArrayList<String>();
      for(String i:msg){
          result.add(encrypt.apply(i));
      }
      return result;
   }
   
   public static void main(String args[]) {
      List<String> test = new ArrayList<String>();
      test.add("one");
      test.add("two");
      test.add("three");
      System.out.println("input: "+ test.toString());
      test = transform(test, (String x)-> x.replaceAll("a|e|i|o|u|A|E|I|O|U","?"));
      System.out.println("output: "+ test.toString());
   }

}