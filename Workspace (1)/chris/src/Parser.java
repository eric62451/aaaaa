import java.util.function.*;
public class Parser implements UnaryOperator<Result>{
	private UnaryOperator<Result> parser;
	
	@Override
	public Result apply(Result result) {
		return parser.apply(result);
	}


	public void setParser(UnaryOperator<Result> input) {
		this.parser = input;
	}
	
	
}