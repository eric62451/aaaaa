import java.util.function.UnaryOperator;


public class Parser implements UnaryOperator{
	
	private UnaryOperator<Result> op;
	
	@Override
	public Object apply(Object arg0) {
		return apply((Result) arg0);
	}
	
	public Result apply(Result a){
		if (op == null) return a;
		return op.apply(a);
	}
	
	public void setParser(UnaryOperator<Result> a){
		op = a;
	}
	

}
