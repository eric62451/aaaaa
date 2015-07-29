import java.util.*;
import java.util.function.*;
public class Combinators {
   
   // returns p1 | p2
   public static Parser alt(Parser p1, Parser p2) {
      Parser parser = new Parser();
      parser.setParser(
         result->{
            if (result.fail)return result; 
            Choice answer = new Choice();
            answer.choice = p1.apply(result);
            if (answer.choice.fail)  {
               answer.choice = p2.apply(result);
            }
            if (answer.choice.fail) return answer.choice;
            answer.unseen = answer.choice.unseen;
            return answer;
      });
      return parser;
   }
   
   public static Parser seq(Parser p1, Parser p2) {
	   Parser parser = new Parser();
       parser.setParser(
           result -> {
               if (result.fail) {
                   return result;
               }

               Concatination answer = new Concatination();
               answer.kid0 = p1.apply(result);
               if (answer.kid0.fail)  {
                   return answer.kid0;
               }

               answer.unseen = answer.kid0.unseen;
               answer.kid1 = p2.apply(answer.kid0);
               if (answer.kid1.fail) {
                   return answer.kid1;
               }
              
               answer.unseen = answer.kid1.unseen;
               //System.out.println(answer.unseen);
               return answer;
		});
		return parser;
   }
   public static Parser regEx(String regEx) {
	   Parser parser = new Parser();
	   parser.setParser(
       result->{
    	  Literal answer = new Literal();
    	  if (result.fail){
    		  result.fail = true;
    		  return result;
    	  }
    	  //Literal answer = new Literal();
    	  if(result.pending() ==0){
    		  answer.fail = true;
    		  return answer;
    	  }
    	  String value = result.unseen.get(0);
    	  
          if(value.matches(regEx)){
        	 
        	  answer.token = value;
        	  result.unseen.remove(0);
        	  answer.unseen = result.unseen;
        	 
          	} 
          else{
        	 
        	  System.out.println(result.unseen);
        	  answer.fail = true;
        	  answer.unseen = result.unseen;
          }
          //System.out.println(answer.token);
          return answer;
        
     });
     return parser;
	   
 
   }
   }
