/*
 * Eric Tam
 * 007989423
 * CS154
 * Assignment 3
 */

public class Literal implements RegEx {
	private String regex;
	public Literal(String a) {
		regex = a;// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean matches(String s) {
		return regex.equals(s);
	}
}
