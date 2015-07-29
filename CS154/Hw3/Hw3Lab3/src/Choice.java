/*
 * Eric Tam
 * 007989423
 * CS154
 * Assignment 3
 */

public class Choice implements RegEx{
	private RegEx one;
	private RegEx two;
	
	public Choice(RegEx o,RegEx t) {
		one = o;
		two = t;
	}
	
	@Override
	public boolean matches(String s) {
		if(one.matches(s)||two.matches(s)) return true;
		else return false;
	}
}
