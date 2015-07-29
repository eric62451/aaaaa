/*
 * Eric Tam
 * 007989423
 * CS154
 * Assignment 3
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticInterpreter {
	public static double Interpret(String s) throws Exception{
		
		String pattern = "(-?[0-9]+(\\.[0-9]+)?)(.)(-?[0-9]+(\\.[0-9]+)?)";
		Pattern p = Pattern.compile(pattern);
		s = s.replaceAll(" ", "");
		if(!s.matches(pattern)) throw new Exception("Invalid number");
		Matcher a = p.matcher(s);
		a.find();
//		System.out.println(a.group(1));
//		System.out.println(a.group(2));
//		System.out.println(a.group(3));
//		System.out.println(a.group(4));
//		System.out.println(a.group(5));
		String one = a.group(1);
		String two = a.group(2);
		String symbol = a.group(3);
		String four = a.group(4);
		String five = a.group(5);
		if(two==null) two = "";
		if(five==null) five = "";
		double first = Double.parseDouble(one);
		double second = Double.parseDouble(four);
//		System.out.println(first);
//		System.out.println(second);
		if(symbol.equals("+")) return first + second;
		else if(symbol.equals("-")) return first - second;
		else if(symbol.equals("*")) return first * second;
		else if(symbol.equals("/")) return first / second;
		throw new Exception("invalid operator");
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s;
		while(true){
			System.out.print("->");
			s = in.nextLine();
			if(s.equalsIgnoreCase("quit")) {
				System.out.println("Bye");
				break;
			}
			else
				try {
					System.out.println(Interpret(s));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
		
	}
}
