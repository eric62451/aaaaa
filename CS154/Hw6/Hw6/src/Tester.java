
public class Tester {
	
	public static void main(String[] args) {
		testExpParsers();
	}
	
	public static void testExpParsers() {
		System.out.println("abc".matches("(abc)+"));
		   String s = "42";
		   test(ExpParsers.number, s);
		   s = "29z";
		   test(ExpParsers.number, s);
		   s = "*";
		   test(ExpParsers.operator, s);
		   s = "-";
		   test(ExpParsers.operator, s);
		   s = "42 + 91 * 13 + 2";
		   test(ExpParsers.exp, s);
		   s = "123";
		   test(ExpParsers.exp, s);
		   s = "15 * 6 - 10";
		   test(ExpParsers.exp, s);
		   s = "abc";
		   test(ExpParsers.iter, s);
		   s = "abcabc";
		   test(ExpParsers.iter, s);
		   s = "abc abc abc";
		   test(ExpParsers.iter, s);
		   s = "abc 123";
		   test(ExpParsers.opt, s);
		   s = "123";
		   test(ExpParsers.opt, s);
		   s = "abcabca";
		   test(ExpParsers.iter, s);
		}
	
	public static void test(Parser p, String s) {
		   System.out.println("s = " + s);
		   Result tree =  p.apply(new Result(s));
		   System.out.println("tree = " + tree);
		   System.out.println("pending = " + tree.pending());
		}
}
