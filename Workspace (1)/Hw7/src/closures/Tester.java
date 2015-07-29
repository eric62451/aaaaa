package closures;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Tester {
	
	public static void main(String[] args) {
		Predicate<Integer> memA = (Integer x)->{return x<=5 && x>0;};
		Predicate<Integer> memB = (Integer x)->{return x>=4 && x<=10;};
		Function<Integer,Integer> cons = (Integer x)->{return x+1;};
		Function<Integer,Integer> enumA = (Integer x)->{return x*2;};
		Function<Integer,Integer> enumB = (Integer x)->{return x*3;};
		
		
		
		System.out.println("SET A = {1,2,3,4,5} SET B = {4,5,6,7,8,9,10}\n");
		System.out.println("UNION Test");
		Predicate<Integer> union = RecClosures.union(memA, memB);
		for(int i = 0; i<13; i++){
			System.out.println("memABUnion("+i+") = "+ union.test(i));
		}
		
		System.out.println("\nINTERSECT Test");
		Predicate<Integer> intersect = RecClosures.intersect(memA, memB);
		for(int i = 0; i<13; i++){
			System.out.println("memABIntersect("+i+") = "+ intersect.test(i));
		}
		
		System.out.println("\nDIFFER Test");
		Predicate<Integer> differ = RecClosures.diff(memA, memB);
		for(int i = 0; i<13; i++){
			System.out.println("memABDiff("+i+") = "+ differ.test(i));
		}
		
		System.out.println("\nCartesian Test");
		BiPredicate<Integer,Integer> cartesian = RecClosures.cartesian(memA, memB);
		for(int i = 0; i<7; i++){
			for(int j = 3; j<12;j++){
				System.out.println("memABCartesian("+i+","+j+") = "+ cartesian.test(i,j));
			}
			
		}
		
		System.out.println("\nEnum SET A = {0,2,4,6,8,........} SET B = {0,3,6,9,12,.......}\n");
		System.out.println("UNION Test");
		Function<Integer,Integer> unio = RecEnumClosures.union(enumA, enumB);
		for(int i = 0; i<13; i++){
			System.out.println("enumABUnion("+i+") = "+ unio.apply(i));
		}
		
		System.out.println("\nINTERSERCT Test");
		Function<Integer,Integer> inter = RecEnumClosures.intersect(enumA, enumB);
		for(int i = 0; i<13; i++){
			System.out.println("enumABIntersect("+i+") = "+ inter.apply(i));
		}
		
		System.out.println("\nCartesian Test");
		Function<Integer,CartesianProductPair> cart = RecEnumClosures.cartersian(cons, cons);
		for(int i = 0; i<13; i++){
			System.out.println("enumABCartesian("+i+") = "+ cart.apply(i));
		}
		
		
		
	}

}
