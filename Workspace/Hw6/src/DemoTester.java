public class DemoTester {
	
	public static void main(String[] args) {
		testDemoParsers();
	}

	public static void test(Parser p, String s) {
		System.out.println("s = " + s);
		Result tree = p.apply(new Result(s));
		System.out.println("tree = " + tree);
		System.out.println("pending = " + tree.pending());
	}

	public static void testDemoParsers() {
		String s;
		System.out.println("NUMBER parser test");
		s = "29";
		test(DemoParsers.number, s);
		s = "9";
		test(DemoParsers.number, s);
		s = "0";
		test(DemoParsers.number, s);
		s = "-5";
		test(DemoParsers.number, s);
		s = "1.5";
		test(DemoParsers.number, s);
		
		System.out.println("\n\nOPERATOR parser test");
		s = "+";
		test(DemoParsers.operator, s);
		s = "*";
		test(DemoParsers.operator, s);
		s = "&&";
		test(DemoParsers.operator, s);
		s = "||";
		test(DemoParsers.operator, s);
		s = "!";
		test(DemoParsers.operator, s);
		s = "-";
		test(DemoParsers.operator, s);
		s = "/";
		test(DemoParsers.operator, s);
		
		System.out.println("\n\nBOOLE parser test");
		s = "true";
		test(DemoParsers.boole, s);
		s = "false";
		test(DemoParsers.boole, s);
		s = "flse";
		test(DemoParsers.boole, s);
		s = "truep";
		test(DemoParsers.boole, s);
		s = "TRUE";
		test(DemoParsers.boole, s);
		
		System.out.println("\n\nNAME parser test");
		s = "winner1";
		test(DemoParsers.name, s);
		s = "n1n";
		test(DemoParsers.name, s);
		s = "1st";
		test(DemoParsers.name, s);
		s = "F1st";
		test(DemoParsers.name, s);
		
		System.out.println("\n\nTERM parser test");
		s = "winner1";
		test(DemoParsers.term, s);
		s = "3001";
		test(DemoParsers.term, s);
		s = "655z";
		test(DemoParsers.term, s);
		s = "true";
		test(DemoParsers.term, s);
		s = "true1";
		test(DemoParsers.term, s);
		
		System.out.println("\n\nLIST1 parser test");
		s = "winner1 winner2 winner3";
		test(DemoParsers.list1, s);
		s = "1st eric tam";
		test(DemoParsers.list1, s);
		s = "winner1 2nd 3rd";
		test(DemoParsers.list1, s);
		s = "hi how true";
		test(DemoParsers.list1, s);
		
		System.out.println("\n\nLIST2 parser test");
		s = "winner1 winner2 winner3";
		test(DemoParsers.list2, s);
		s = "1st eric tam";
		test(DemoParsers.list2, s);
		s = "winner1 2nd 3rd";
		test(DemoParsers.list2, s);
		s = "hi how true";
		test(DemoParsers.list2, s);
		
		System.out.println("\n\nPRODUCT parser test");
		s = "name * 4 * 5 + true || a";
		test(DemoParsers.product, s);
		s = "5 ! 5z + 6";
		test(DemoParsers.product, s);
		s = "true && false";
		test(DemoParsers.product, s);
		s = "1z + true";
		test(DemoParsers.product, s);
		s = "name - eric";
		test(DemoParsers.product, s);
		
		System.out.println("\n\nSUM parser test");
		s = "name * 4 * 5 + true || a";
		test(DemoParsers.sum, s);
		s = "5 ! 5z + 6";
		test(DemoParsers.sum, s);
		s = "true && false";
		test(DemoParsers.sum, s);
		s = "1z + true";
		test(DemoParsers.sum, s);
		s = "name - eric";
		test(DemoParsers.sum, s);
		s = "name eric 5000 * 5";
		test(DemoParsers.sum, s);
		s = "name eric tam is the best";
		test(DemoParsers.sum, s);
		s = "eric + numero + 1";
		test(DemoParsers.sum, s);
	}

}
