/*
 * Eric Tam
 * 007989423
 * CS154
 * Assignment 3
 */

public class Concat  implements RegEx{
	
	private RegEx first;
	private RegEx second;
	
	public Concat(RegEx one, RegEx two) {
		first = one;
		second = two;
	}
	
	@Override
	public boolean matches(String s) {
		for(int i = 0; i<s.length();i++){
			if(first.matches(s.substring(0, i))&&second.matches(s.substring(i, s.length()))) return true;
		}
//		if(index==-1)return false;
//		else if(second.matches(s.substring(index, s.length()))) return true;
//		else return false;
		return false;
	}

}
