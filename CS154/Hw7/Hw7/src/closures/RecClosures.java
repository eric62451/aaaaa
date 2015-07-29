package closures;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class RecClosures {
	
	public static Predicate<Integer> union(Predicate<Integer> memA, Predicate<Integer> memB) {
		return (Integer x) ->{
			return memA.test(x) || memB.test(x);
		};
	}
	
	public static Predicate<Integer> intersect(Predicate<Integer> memA, Predicate<Integer> memB) {
		return (Integer x) ->{
			return memA.test(x) && memB.test(x);
		};
	}
	
	public static Predicate<Integer> diff(Predicate<Integer> memA, Predicate<Integer> memB){
		return (Integer x) ->{
			return memA.test(x) && !memB.test(x);
		};
	}
	
	public static BiPredicate<Integer, Integer> cartesian(Predicate<Integer> memA, Predicate<Integer> memB){
		return (Integer x, Integer y) ->{
			return memA.test(x) && memB.test(y);
		};
	}
	

}
