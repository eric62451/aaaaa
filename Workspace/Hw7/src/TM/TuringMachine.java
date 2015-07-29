package TM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TuringMachine {
	private Tape tape;
	private Map<Trigger, Action> program;
	private Set<Integer> finalStates; // run halts when state is a member
	private int state; // the current state

	public TuringMachine() {
		program = new HashMap<Trigger, Action>();
		finalStates = new HashSet<Integer>();
		state = 0;
	}

	public void run() {
		while (!finalStates.contains(state)) {
			//System.out.println(state + "    " + tape.read());
			Action act = program.get(new Trigger(state, tape.read()));
			tape.write(act.newBit);
			state = act.nextState;
			tape.moveHead(act.direction);
		}
	}

	public void addFinalStates(int state) {
		finalStates.add(state);
	}

	public void setTape(Tape tape) {
		this.tape = tape;
	}
	
	public void addTriggerAction(Trigger trig, Action act){
		program.put(trig, act);
	}

	// etc.
}