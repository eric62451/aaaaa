
public class Testing {
public static void main(String[] args) {
	Literal r1 = new Literal("cat");
	Literal r4 = new Literal("dog");
	Iteration r2 = new Iteration(r1);
	Concat r3 = new Concat(r1,r4);
	Concat r5 = new Concat(r2,r4);
	RegEx r6 = new Option(r2);
	System.out.println(r2.matches("catc"));
	System.out.println(r2.matches("catcat"));
	System.out.println(r2.matches("catcatcat"));
	System.out.println(r2.matches("cat3"));
	System.out.println(r2.matches("cat423"));
	System.out.println(r3.matches("catdog"));
	System.out.println(r5.matches("catcatdog"));
	System.out.println(r3.matches("dogcat"));
	System.out.println(r6.matches("catcat"));
	System.out.println(r6.matches("ca"));
	System.out.println(r6.matches(""));
}
}
