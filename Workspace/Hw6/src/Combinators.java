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

   // returns p1 ~ p2
   public static Parser seq(Parser p1, Parser p2) {
	   Parser parser = new Parser();
	      parser.setParser(
	         result->{
	            if (result.fail)return result; 
	            Concatenation answer = new Concatenation();
	            answer.one = p1.apply(result);
	            if(answer.one.fail) return answer.one;
	            answer.two = p2.apply(answer.one);
	            if(answer.two.fail) return answer.two;
	            answer.unseen = answer.two.unseen;
	            return answer;
	      });
	      return parser;
   }
   
   // returns p+ 
   public static Parser rep(Parser p) {
	   Parser parser = new Parser();
	      parser.setParser(
	         result->{
	            if (result.fail)return result; 
//	            if(result.unseen.size() == 0){
//	            	result.fail = true;
//	            	return result;
//	            }
	            Iteration answer = new Iteration();
	            answer.iterat = p.apply(result);
	            if(answer.iterat.fail) return answer.iterat;
	            answer.unseen = answer.iterat.unseen;
	            while(answer.unseen.size()>0){
	            	answer.iterat = p.apply(answer);
		            if(answer.iterat.fail) return answer.iterat;
		            answer.unseen = answer.iterat.unseen;
	            }
	            return answer;
	      });
	      return parser;
   }
   
   // returns p? 
   public static Parser opt(Parser p) {
	   Parser parser = new Parser();
	      parser.setParser(
	         result->{
	            if (result.fail)return result; 
	            Option answer = new Option();
	            answer.opt = p.apply(result);
	            	answer.unseen = answer.opt.unseen;
	            	return answer;

	      });
	      return parser;
   }
   
   // returns p = regExp
   public static Parser regEx(String regex) {
	   Parser parser = new Parser();
	   parser.setParser(
		         result->{
		            if (result.fail)return result; 
		            if(result.unseen.size()>0) {
		            	String temp = result.unseen.get(0);
		            	if(temp.matches(regex))
		            	{
		            		Literal answer = new Literal();
		            		answer.unseen.addAll(result.unseen);
		            		answer.token = answer.unseen.remove(0);
		            		return answer;
		            	}
		            }
		            Literal answer = new Literal();
		            answer.fail = true;
		            answer.unseen.addAll(result.unseen);
		            return answer;
		      });
		      return parser;
   }

   // etc.
}