import java.io.FileNotFoundException;

public class TestVM {

	public static void main(String[] args) throws Exception {
		
		System.out.println("compile TEST");
		System.out.println(compileTest());

		System.out.println("\nn + m TEST");
		System.out.println("10 + 10 = " + addition(10,10));
		System.out.println("5 + 7 = " + addition(5,7));
		System.out.println("0 + 0 = " + addition(0,0));
		System.out.println("0 + 5 = " + addition(0,5));
		System.out.println("5 + 0 = " + addition(5,0));
		
		System.out.println("\nn * m TEST");
		System.out.println("2 * 2 = " + mult(2,2));
		System.out.println("10 * 2 = " + mult(10,2));
		System.out.println("2 * 0 = " + mult(2,0));
		System.out.println("7 * 3 = " + mult(7,3));
		System.out.println("8 * 1 = " + mult(8,1));
		
		System.out.println("\nmax(n,m) TEST");
		System.out.println("max(3,5) = " + max(3,5));
		System.out.println("max(0,0) = " + max(0,0));
		System.out.println("max(1,0) = " + max(1,0));
		System.out.println("max(3,11) = " + max(3,11));
		System.out.println("max(7,4) = " + max(7,4));
		
		System.out.println("\nm - n TEST");
		System.out.println("3 - 5 = " + substract(3,5));
		System.out.println("5 - 3 = " + substract(5,3));
		System.out.println("10 - 9 = " + substract(10,9));
		System.out.println("10 - 10 = " + substract(10,10));
		System.out.println("6 - 2 = " + substract(6,2));
		
		System.out.println("\ndouble(x) TEST");
		System.out.println("double(5) = " + Double(5));
		System.out.println("double(1) = " + Double(1));
		System.out.println("double(6) = " + Double(6));
		System.out.println("double(9) = " + Double(9));
		System.out.println("double(11) = " + Double(11));
		
		System.out.println("\nexp(x) TEST");
		System.out.println("exp(0) = " + exp(0));
		System.out.println("exp(1) = " + exp(1));
		System.out.println("exp(2) = " + exp(2));
		System.out.println("exp(3) = " + exp(3));
		System.out.println("exp(4) = " + exp(4));
		System.out.println("exp(5) = " + exp(5));
		System.out.println("exp(6) = " + exp(6));
		
		System.out.println("\nhyperexp(x) TEST");
		System.out.println("hyperexp(0) = " + hyperexp(0));
		System.out.println("hyperexp(1) = " + hyperexp(1));
		System.out.println("hyperexp(2) = " + hyperexp(2));
		System.out.println("hyperexp(3) = " + hyperexp(3));
		System.out.println("hyperexp(4) = " + hyperexp(4));
		
		System.out.println("\nhyper2exp(x) TEST");
		System.out.println("hyper2exp(0) = " + hyper2exp(0));
		System.out.println("hyper2exp(1) = " + hyper2exp(1));
		System.out.println("hyper2exp(2) = " + hyper2exp(2));
		System.out.println("hyper2exp(3) = " + hyper2exp(3));
		
		System.out.println("\nhyper3exp(x) TEST");
		System.out.println("hyper3exp(0) = " + hyper3exp(0));
		System.out.println("hyper3exp(1) = " + hyper3exp(1));
		System.out.println("hyper3exp(2) = " + hyper3exp(2));
	}
	
	public static int addition(int m, int n) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		vm.add("load x "+m);
		vm.add("load y "+n);
		vm.add("loop x");
		vm.add("inc y");
		vm.add("end");
		vm.run();
		return vm.getVariable("y");
		
	}
	
	public static int mult(int m, int n) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		vm.add("load x "+m);
		vm.add("load y "+n);
		vm.add("load z 0");
		vm.add("loop x");
		vm.add("loop y");
		vm.add("inc z");
		vm.add("end");
		vm.add("end");
		vm.run();
		return vm.getVariable("z");
	}
	
	public static int max(int m, int n) throws Exception{
		
		VM vm = new VM();
		vm.printInfo = false;
		vm.add("load x "+m);
		vm.add("load y "+n);
		
		
		//x~y
		vm.add("load a x");
		vm.add("loop y");
		////////// v~1
		vm.add("load b 0");
		vm.add("loop a");
		vm.add("load c b");
		vm.add("inc b");
		vm.add("end");
		////////// 
		vm.add("load a c");
		vm.add("end");
		
		//z = !z
		vm.add("load d y");
		vm.add("loop a");
		vm.add("load d x");
		vm.add("end");
		
		
		
		
		
		vm.run();
		
		
		return vm.getVariable("d");
		
	}
	
	public static int substract(int m, int n) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		vm.add("load x "+m);
		vm.add("load y "+n);
		//x~y
		vm.add("load a x");
		vm.add("loop y");
		////////// v~1
		vm.add("load b 0");
		vm.add("loop a");
		vm.add("load c b");
		vm.add("inc b");
		vm.add("end");
		////////// 
		vm.add("load a c");
		vm.add("end");
		vm.run();
		
		return vm.getVariable("a");
	}
	
	public static int Double(int x) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		vm.add("load x "+x);
		vm.add("loop x");
		vm.add("inc x");
		vm.add("end");
		vm.run();
		return vm.getVariable("x");
		
	}
	
	public static int exp(int x) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		vm.add("load a "+1);
		vm.add("load x "+x);
		vm.add("loop x");
		vm.add("loop a");
		vm.add("inc a");
		vm.add("end");
		vm.add("end");
		vm.run();
		return vm.getVariable("a");
	}
	
	public static int hyperexp(int x) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		
		vm.add("load x "+x);
		
		vm.add("load b "+1);
		vm.add("loop x");
		vm.add("load a 1");
		vm.add("loop b");
		
		vm.add("loop a");
		vm.add("inc a");
		vm.add("end");
		
		vm.add("end");
		vm.add("load b a");
		
		
		vm.add("end");
		
		
		vm.run();
		
		return vm.getVariable("b");
	}
	
	public static int hyper2exp(int x) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		
		vm.add("load x "+x);
		vm.add("load c 1");
		
		vm.add("loop x");
		vm.add("load b "+1);
		vm.add("loop c");
		vm.add("load a 1");
		vm.add("loop b");
		
		vm.add("loop a");
		vm.add("inc a");
		vm.add("end");
		
		vm.add("end");
		vm.add("load b a");
		
		
		vm.add("end");
		
		vm.add("load c b");
		vm.add("end");
		
		
		vm.run();
		
		return vm.getVariable("c");
	}
	
	public static int hyper3exp(int x) throws Exception{
		VM vm = new VM();
		vm.printInfo = false;
		
		vm.add("load x "+x);
		vm.add("load d 1");
		
		vm.add("loop x");
		vm.add("load c 1");
		vm.add("loop d");
		vm.add("load b "+1);
		vm.add("loop c");
		vm.add("load a 1");
		vm.add("loop b");
		
		vm.add("loop a");
		vm.add("inc a");
		vm.add("end");
		
		vm.add("end");
		vm.add("load b a");
		
		
		vm.add("end");
		
		vm.add("load c b");
		vm.add("end");
		vm.add("load d c");
		
		vm.add("end");
		
		
		vm.run();
		
		return vm.getVariable("d");
	}
	
	public static int compileTest() throws Exception{
		VM vm = new VM();
		vm.compile("test.txt");
		vm.run();
		return vm.getVariable("x");
		
	}
	
}
