/*
 * Eric Tam
 * 007989423
 * CS154
 * 3/7/2015
 */
public class Lab6Tester {
	
	public static void main(String[] args) {
		
		System.out.println("natRegEx test number from 0 to 100");
		Lab6 temp = new Lab6();
		boolean alltrue = true;
		for(int i = 0; i<100;i++){
			if(!temp.natRegEx(""+i)) {
				alltrue = false;
				System.out.println(i + " is false");
			}
		}
		if(alltrue) System.out.println("all numbers from 0 to 100 is true");
		System.out.println("-5: " + temp.natRegEx("-5"));
		System.out.println("7.5: " + temp.natRegEx("7.5"));
		System.out.println("0.6: " + temp.natRegEx("0.6"));
		
		
		System.out.println("\n\ndateRegEx Test");
		System.out.println("03/15/50: "+ temp.dateRegEx("03/15/50"));
		System.out.println("300/455/99: "+ temp.dateRegEx("300/455/99"));
		System.out.println("000/00/00: "+ temp.dateRegEx("000/00/00"));
		System.out.println("03/01/05: "+ temp.dateRegEx("03/01/05"));
		System.out.println("12/01/99: "+ temp.dateRegEx("12/01/99"));
		System.out.println("11/11/11: "+ temp.dateRegEx("11/11/11"));
		System.out.println("00/00/08: "+ temp.dateRegEx("00/00/08"));
		System.out.println("10/05/12: "+ temp.dateRegEx("10/05/12"));
		
		System.out.println("\n\nnameRegEx Test");
		System.out.println("aa: "+ temp.nameRegEx("aa"));
		System.out.println("abcde: "+ temp.nameRegEx("abcde"));
		System.out.println("a9: "+ temp.nameRegEx("a9"));
		System.out.println("9: "+ temp.nameRegEx("9"));
		System.out.println("c9a7c5b: "+ temp.nameRegEx("c9a7c5b"));
		System.out.println("cc5cc7: "+ temp.nameRegEx("cc5cc7"));
		System.out.println("b: "+ temp.nameRegEx("b"));
		System.out.println("ac0: "+ temp.nameRegEx("ac0"));
		System.out.println("a0b0c: "+ temp.nameRegEx("a0b0c"));
		System.out.println("a00000ca: "+ temp.nameRegEx("a00000ca"));
		
		
		
	}

}
