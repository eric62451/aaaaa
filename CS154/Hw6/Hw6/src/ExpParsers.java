public class ExpParsers {
   public static Parser number = Combinators.regEx("[0-9]+");
   public static Parser operator = Combinators.regEx("\\+|\\*");
   public static Parser iter = Combinators.rep(Combinators.regEx("(abc)+"));
   public static Parser opt = Combinators.seq(Combinators.opt(Combinators.regEx("abc")), number);
   public static Parser exp = new Parser();
   static {
	      exp.setParser(
	         Combinators.alt(
	               Combinators.seq(
	                     number,
	                     Combinators.seq(operator, exp)),
	                number));
	      
	   }
}