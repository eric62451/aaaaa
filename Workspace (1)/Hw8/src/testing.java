import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testing {
	public static void main(String[] args) {
		System.out.println(exp(0));
		System.out.println(exp(1));
		System.out.println(exp(2));
		System.out.println(exp(3));
		System.out.println(exp(4));
		
		System.out.println();
		System.out.println();
		
		System.out.println(hyperexp(0));
		System.out.println(hyperexp(1));
		System.out.println(hyperexp(2));
		System.out.println(hyperexp(3));
		System.out.println(hyperexp(4));
		
		System.out.println();
		System.out.println();
		
		System.out.println(hyper2exp(0));
		System.out.println(hyper2exp(1));
		System.out.println(hyper2exp(2));
		System.out.println(hyper2exp(3));
		//System.out.println(hyper2exp(4));
		
		System.out.println();
		System.out.println();
		
		System.out.println(hyper3exp(0));
		System.out.println(hyper3exp(1));
		System.out.println(hyper3exp(2));
		
	}
	
	public static int Double(int x){
		return x*2;
	}
	public static int exp(int x){
		int a= 1;
		for(int i = 0; i<x; i++){
			a = Double(a);
		}
		return a;
	}
	
	public static int hyperexp(int x){
		int a= 1;
		for(int i = 0; i<x; i++){
			a = exp(a);
		}
		return a;
	}
	
	public static int hyper2exp(int x){
		int a= 1;
		for(int i = 0; i<x; i++){
			a = hyperexp(a);
		}
		return a;
	}
	
	public static int hyper3exp(int x){
		int a= 1;
		for(int i = 0; i<x; i++){
			a = hyper2exp(a);
		}
		return a;
	}
	
	
}
