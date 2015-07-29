public class Option implements RegEx{
	private RegEx exp;
	
	public Option(RegEx a) {
		exp = a;
	}
	
	@Override
	public boolean matches(String s) {
		if(s.isEmpty()) return true;
		else if(exp.matches(s)) return true;
		return false;
	}
}
