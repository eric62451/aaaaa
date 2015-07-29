package TM;

import java.util.HashMap;
import java.util.Map;

public class Tester {
	
	public static int twoN(int n){
		String a = "B";
		for(int i = 0; i<n;i++) a = a + "1";
		a = a + "R";
		Tape tap = new Tape(a);
		TuringMachine tm = new TuringMachine();
		tm.setTape(tap);
		tm.addTriggerAction(new Trigger(0,'B'), new Action(1, 'B', 1));
		tm.addTriggerAction(new Trigger(1,'1'), new Action(2, '0', 1));
		tm.addTriggerAction(new Trigger(1,'0'), new Action(1, '0', 1));
		tm.addTriggerAction(new Trigger(1,'R'), new Action(5, 'R', 0));
		tm.addTriggerAction(new Trigger(2,'1'), new Action(2, '1', 1));
		tm.addTriggerAction(new Trigger(2,'R'), new Action(2, 'R', 1));
		tm.addTriggerAction(new Trigger(2,'0'), new Action(3, '1', 1));
		tm.addTriggerAction(new Trigger(3,'0'), new Action(4, '1', -1));
		tm.addTriggerAction(new Trigger(4,'1'), new Action(4, '1', -1));
		tm.addTriggerAction(new Trigger(4,'0'), new Action(4, '0', -1));
		tm.addTriggerAction(new Trigger(4,'R'), new Action(4, 'R', -1));
		tm.addTriggerAction(new Trigger(4,'B'), new Action(0, 'B', 0));
		tm.addFinalStates(5);
		tm.run();
		String temp = tap.getCells().toString();
		temp = temp.replace(", ", "");
		//System.out.println(temp);
		temp = temp.replace("0","");
		String[] arr = temp.split("R");
		arr[1] = arr[1].replaceAll("[^1]", "");
		//System.out.println(arr[1]);
		return arr[1].length();
	}
	
	public static int nSquare(int n){
		String b = "B";
		String c = "C";
		for(int i = 0; i<n;i++) {
			b = b + "1";
			c = c + "1";
		}
		b = b + c + "R";
		Tape tape = new Tape(b);
		//System.out.println(b);
		TuringMachine tm = new TuringMachine();
		tm.setTape(tape);
		tm.addTriggerAction(new Trigger(0,'B'), new Action(0, 'B', 1));
		tm.addTriggerAction(new Trigger(0,'1'), new Action(0, '1', 1));
		tm.addTriggerAction(new Trigger(0,'-'), new Action(0, '-', 1));
		tm.addTriggerAction(new Trigger(0,'C'), new Action(1, 'C', 1));
		tm.addTriggerAction(new Trigger(1,'1'), new Action(2, '0', -1));
		tm.addTriggerAction(new Trigger(1,'0'), new Action(1, '0', 1));
		tm.addTriggerAction(new Trigger(1,'R'), new Action(12, 'R', 0));
		tm.addTriggerAction(new Trigger(2,'C'), new Action(2, 'C', -1));
		tm.addTriggerAction(new Trigger(2,'R'), new Action(2, 'R', -1));
		tm.addTriggerAction(new Trigger(2,'-'), new Action(2, '-', -1));
		tm.addTriggerAction(new Trigger(2,'1'), new Action(2, '1', -1));
		tm.addTriggerAction(new Trigger(2,'0'), new Action(2, '0', -1));
		tm.addTriggerAction(new Trigger(2,'B'), new Action(3, 'B', 1));
		tm.addTriggerAction(new Trigger(3,'1'), new Action(4, '-', 1));
		tm.addTriggerAction(new Trigger(3,'-'), new Action(3, '-', 1));
		tm.addTriggerAction(new Trigger(3,'C'), new Action(6, 'C', 1));
		tm.addTriggerAction(new Trigger(4,'C'), new Action(4, 'C', 1));
		tm.addTriggerAction(new Trigger(4,'1'), new Action(4, '1', 1));
		tm.addTriggerAction(new Trigger(4,'-'), new Action(4, '-', 1));
		tm.addTriggerAction(new Trigger(4,'0'), new Action(4, '0', 1));
		tm.addTriggerAction(new Trigger(4,'R'), new Action(5, 'R', 1));
		tm.addTriggerAction(new Trigger(5,'0'), new Action(2, '1', -1));
		tm.addTriggerAction(new Trigger(5,'1'), new Action(5, '1', 1));
		tm.addTriggerAction(new Trigger(6,'0'), new Action(6, '0', 1));
		tm.addTriggerAction(new Trigger(6,'1'), new Action(7, '0', -1));
		tm.addTriggerAction(new Trigger(6,'R'), new Action(12, 'R', 0));
		tm.addTriggerAction(new Trigger(7,'C'), new Action(7, 'C', -1));
		tm.addTriggerAction(new Trigger(7,'R'), new Action(7, 'R', -1));
		tm.addTriggerAction(new Trigger(7,'-'), new Action(7, '-', -1));
		tm.addTriggerAction(new Trigger(7,'1'), new Action(7, '1', -1));
		tm.addTriggerAction(new Trigger(7,'0'), new Action(7, '0', -1));
		tm.addTriggerAction(new Trigger(7,'B'), new Action(8, 'B', 1));
		tm.addTriggerAction(new Trigger(8,'1'), new Action(8, '1', 1));
		tm.addTriggerAction(new Trigger(8,'-'), new Action(9, '1', 1));
		tm.addTriggerAction(new Trigger(8,'C'), new Action(1, 'C', 1));
		tm.addTriggerAction(new Trigger(9,'C'), new Action(9, 'C', 1));
		tm.addTriggerAction(new Trigger(9,'-'), new Action(9, '-', 1));
		tm.addTriggerAction(new Trigger(9,'1'), new Action(9, '1', 1));
		tm.addTriggerAction(new Trigger(9,'0'), new Action(9, '0', 1));
		tm.addTriggerAction(new Trigger(9,'R'), new Action(10, 'R', 1));
		tm.addTriggerAction(new Trigger(10,'0'), new Action(7, '1', -1));
		tm.addTriggerAction(new Trigger(10,'1'), new Action(10, '1', 1));
		tm.addFinalStates(12);
		tm.run();
		String temp = tape.getCells().toString();
		temp = temp.replace(", ", "");
		//System.out.println(temp);
		temp = temp.replace("0","");
		String[] arr = temp.split("R");
		arr[1] = arr[1].replaceAll("[^1]", "");
		//System.out.println(arr[1]);
		return arr[1].length();
	}
	
	public static boolean onezeroone(String n){
		String line = "B" + n + "R";
		Tape tape = new Tape(line);
		TuringMachine tm = new TuringMachine();
		tm.setTape(tape);
		tm.addTriggerAction(new Trigger(0,'B'), new Action(1, 'B', 1));
		tm.addTriggerAction(new Trigger(1,'1'), new Action(2, '-', 1));
		tm.addTriggerAction(new Trigger(1,'-'), new Action(1, '-', 1));
		tm.addTriggerAction(new Trigger(1,'R'), new Action(20, 'R', 0));
		tm.addTriggerAction(new Trigger(1,'0'), new Action(5, '0', 1));
		tm.addTriggerAction(new Trigger(2,'1'), new Action(2, '1', 1));
		tm.addTriggerAction(new Trigger(2,'0'), new Action(2, '0', 1));
		tm.addTriggerAction(new Trigger(2,'R'), new Action(3, 'R', 1));
		tm.addTriggerAction(new Trigger(3,'1'), new Action(3, '1', 1));
		tm.addTriggerAction(new Trigger(3,'0'), new Action(4, '1', -1));
		tm.addTriggerAction(new Trigger(4,'0'), new Action(4, '0', -1));
		tm.addTriggerAction(new Trigger(4,'1'), new Action(4, '1', -1));
		tm.addTriggerAction(new Trigger(4,'R'), new Action(4, 'R', -1));
		tm.addTriggerAction(new Trigger(4,'-'), new Action(1, '-', 1));
		tm.addTriggerAction(new Trigger(5,'0'), new Action(20, '0', 0));
		tm.addTriggerAction(new Trigger(5,'-'), new Action(5, '-', 1));
		tm.addTriggerAction(new Trigger(5,'1'), new Action(6, '-', 1));
		tm.addTriggerAction(new Trigger(6,'1'), new Action(6, '1', 1));
		tm.addTriggerAction(new Trigger(6,'R'), new Action(7, 'R', 1));
		tm.addTriggerAction(new Trigger(7,'1'), new Action(8, '-', -1));
		tm.addTriggerAction(new Trigger(7,'-'), new Action(7, '-', 1));
		tm.addTriggerAction(new Trigger(7,'0'), new Action(20, '2', 0));
		tm.addTriggerAction(new Trigger(8,'-'), new Action(8, '-', -1));
		tm.addTriggerAction(new Trigger(8,'R'), new Action(8, 'R', -1));
		tm.addTriggerAction(new Trigger(8,'1'), new Action(8, '1', -1));
		tm.addTriggerAction(new Trigger(8,'0'), new Action(5, '0', 1));
		tm.addTriggerAction(new Trigger(5,'R'), new Action(20, 'R', 0));
		tm.addFinalStates(20);
		tm.run();
		String temp = tape.getCells().toString();
		temp = temp.replace(", ", "");
		//System.out.println(temp);
		temp = temp.replace("0","");
		String[] arr = temp.split("R");
		arr[1] = arr[1].replaceAll("0|\\]", "");
		//System.out.println(arr[1]);
		if(arr[1].contains("2") || arr[1].contains("1")) return false;
		return arr[1].contains("-");
	}
	
	public static void main(String[] args) {
		System.out.println("twoN TEST");
		System.out.println("twoN(3) = "+twoN(3));
		System.out.println("twoN(10) = "+twoN(10));
		System.out.println("twoN(2) = "+twoN(2));
		System.out.println("twoN(7) = "+twoN(7));
		System.out.println("twoN(0) = "+twoN(0));
		System.out.println("\nnSquare TEST");
		System.out.println("nsquare(5) = "+nSquare(5));
		System.out.println("nsquare(3) = "+nSquare(3));
		System.out.println("nsquare(0) = "+nSquare(0));
		System.out.println("nsquare(9) = "+nSquare(9));
		System.out.println("nsquare(4) = "+nSquare(4));	
		System.out.println("nsquare(10) = "+nSquare(10));
		System.out.println("\n1n 0 1n TEST");
		System.out.println("onezeroone(11011) = " + onezeroone("11011"));
		System.out.println("onezeroone(0) = " + onezeroone("0"));
		System.out.println("onezeroone(10) = " + onezeroone("10"));
		System.out.println("onezeroone(01) = " + onezeroone("01"));
		System.out.println("onezeroone(101) = " + onezeroone("101"));
		System.out.println("onezeroone(111111) = " + onezeroone("111111"));
	}

}
