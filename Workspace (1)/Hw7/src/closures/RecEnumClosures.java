package closures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class RecEnumClosures {
	
	public static Function<Integer, Integer> union(
			Function<Integer, Integer> enumA, Function<Integer, Integer> enumB) {
		return (Integer x) -> {
			ArrayList<Integer> a = new ArrayList<Integer>();
			int temp = x;
			for (int i = 0; i <= temp; i++) {
				if (i % 2 == 0) {
					if(!a.contains(enumA.apply(i/2)))a.add(enumA.apply(i/2));
					else temp++;
				}
				else if(!a.contains(enumB.apply((i - 1) / 2)))a.add(enumB.apply((i - 1) / 2));
				else temp++;
			}
			return a.get(x);
		};
	}
	
	public static Function<Integer, Integer> intersect(Function<Integer, Integer> enumA, Function<Integer, Integer> enumB) {
		return (Integer x) ->{
			ArrayList<Integer> array = new ArrayList<Integer>();
			ArrayList<Integer> arrayB = new ArrayList<Integer>();
			ArrayList<Integer> intersected = new ArrayList<Integer>();
			for(int i = 0; intersected.size() <= x; i++){
				array.add(enumA.apply(i));
				arrayB.add(enumB.apply(i));
				if(arrayB.contains(enumA.apply(i))){
					if(!intersected.contains(enumA.apply(i)))intersected.add(enumA.apply(i));
				}
				if(array.contains(enumB.apply(i))){
					if(!intersected.contains(enumB.apply(i)))intersected.add(enumB.apply(i));
				}
			}
			return intersected.get(x);

		};
	}
	
	public static Function<Integer, CartesianProductPair> cartersian(Function<Integer, Integer> enumA, Function<Integer, Integer> enumB) {
		return (Integer x) ->{
			int count = 0;
			int i;
			x = x+1;
			for(i = 1; count < x; i++){
				count = count + i;
			}
			i = i-1;
			int a, b;
			if(i%2 == 1){
				a = i - (count - x);
				b = 1 + (count - x);
			} else {
				a = 1 + (count - x);
				b = i - (count - x);
			}
			CartesianProductPair answer = new CartesianProductPair();
			answer.x = enumA.apply(a-1);
			answer.y = enumB.apply(b-1);
			return answer;
		};
	}
	

}
