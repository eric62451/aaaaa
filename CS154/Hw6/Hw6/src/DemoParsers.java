public class DemoParsers {
   public static Parser number = Combinators.regEx("[0-9]+");
   public static Parser operator = Combinators.regEx("\\+|\\*|&&|\\|\\||!");
   public static Parser boole = Combinators.regEx("true|false");
   public static Parser name = Combinators.regEx("[a-zA-Z][a-zA-Z0-9]*");
   public static Parser term = Combinators.alt(name, Combinators.alt(number, boole));
   public static Parser list1 = Combinators.rep(term);
   public static Parser list2 = new Parser();
   public static Parser product = Combinators.seq(term, Combinators.rep(Combinators.seq(operator, term)));
   public static Parser sum = new Parser();
   
   public static Parser exp = new Parser();
   static {
	      list2.setParser(
	    		  Combinators.seq(term, Combinators.opt(list2))
	    		  );
	      sum.setParser(
	    		  Combinators.alt(product, Combinators.seq(term, sum))
	    		  );
	      
	   }
}