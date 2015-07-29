/*
 * Eric Tam
 * 007989423
 * CS154
 * 3/7/2015
 */
public class Lab6 {	
	FSM natReg;
	FSM dateReg;
	FSM nameReg;
	
	public Lab6() {
		natReg = new FSM();
		natReg.addTransition('0', 0, 2);
		for(int i = 1; i<10;i++){
			natReg.addTransition((""+i).charAt(0), 0, 1);
		}
		for(int i = 0; i<10;i++){
			natReg.addTransition((""+i).charAt(0), 1, 1);
		}
		natReg.addFinalState(2);
		natReg.addFinalState(1);
		
		dateReg = new FSM();
		for(int i = 0; i<10;i++){
			dateReg.addTransition((""+i).charAt(0), 0, 1);
		}
		for(int i = 0; i<10;i++){
			dateReg.addTransition((""+i).charAt(0), 1, 2);
		}
		dateReg.addTransition('/', 2, 3);
		for(int i = 0; i<10;i++){
			dateReg.addTransition((""+i).charAt(0), 3, 4);
		}
		for(int i = 0; i<10;i++){
			dateReg.addTransition((""+i).charAt(0), 4, 5);
		}
		dateReg.addTransition('/', 5, 6);
		for(int i = 0; i<10;i++){
			dateReg.addTransition((""+i).charAt(0), 6, 7);
		}
		for(int i = 0; i<10;i++){
			dateReg.addTransition((""+i).charAt(0), 7, 8);
		}
		dateReg.addFinalState(8);
		
		nameReg = new FSM();
		nameReg.addTransition('a', 0, 1);
		nameReg.addTransition('b', 0, 1);
		nameReg.addTransition('c', 0, 1);
		nameReg.addTransition('a', 1, 1);
		nameReg.addTransition('b', 1, 1);
		nameReg.addTransition('c', 1, 1);
		for(int i = 0; i<10;i++){
			nameReg.addTransition((""+i).charAt(0), 1, 1);
		}
		nameReg.addFinalState(1);
		
	}
	
	public boolean natRegEx(String s){
		
		return natReg.accept(s);
	}
	
	public boolean dateRegEx(String s){
		return dateReg.accept(s);
	}
	
	public boolean  nameRegEx(String s){
		return nameReg.accept(s);
	}
}
