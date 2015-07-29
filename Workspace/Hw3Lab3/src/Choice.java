
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
