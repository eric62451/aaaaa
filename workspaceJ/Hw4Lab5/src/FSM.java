import java.util.ArrayList;


public class FSM {
	class Transition{
		public Transition(char character,int from, int to) {
			this.character = Character.toString(character);
			this.from = from;
			this.to = to;
		}
		String character;
		int from;
		int to;
	}
	
	ArrayList<Transition> translist;
	ArrayList<Integer> finalstates;
	
	public FSM() {
		translist = new ArrayList<FSM.Transition>();
		finalstates = new ArrayList<Integer>();
		
	}
	
	public void addTransition(char temp,int from, int to){
		translist.add(new Transition(temp,from, to));
	}
	
	public void addFinalState(int state){
		finalstates.add(state);
	}
	
	public boolean accept(String str){
		int state = 0;
		for(int i = 0; i < str.length();i++){
			boolean changed = false;
			for(Transition temp: translist){
				if(temp.character.equals(str.substring(i, i+1))){
					if(state == temp.from){
						if(!changed){
							state = temp.to;
							changed = true;
						}
					}
				}
			}
			if(!changed) return false;
		}
		return finalstates.contains(new Integer(state));
	}
	
	public void reset(){
		translist = new ArrayList<FSM.Transition>();
		finalstates = new ArrayList<Integer>();
	}
	
	
}
