public class Iteration implements RegEx{
	private RegEx exp;
	public Iteration(RegEx a) {
		exp = a;
	}
	
	@Override
	public boolean matches(String s) {
		int i;
		for(i = 0; i<s.length();i++){
			if(exp.matches(s.substring(0, i))) break;
		}
		if(s.length()==0) return exp.matches(s);
		if(s.length()%i != 0) return false;
		else{
			boolean answer = true;
			for(int j = i;j<=s.length();j = j+i){
				answer = answer&exp.matches(s.substring(j-i, j));
			}
			return answer;
		}
	}
}
