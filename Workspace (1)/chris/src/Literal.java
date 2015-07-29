public class Literal extends Result{
	protected String token;
    public Literal() {}

	public String toString(){
		System.out.println(token);
		if(token != null){
		System.out.println("return this because not null");
		return "<" + token + ">";
		}
		else{
			System.out.println("We return false cause token is null");
			return "false";
		}
	}
}