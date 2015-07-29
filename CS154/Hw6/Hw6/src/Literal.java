
public class Literal extends Result{
	
	String token;
	
	@Override
	public String toString() {
		if(token == null) return "fail";
		return "<"+token+">";
	}

}
