package TM;

import java.util.Map;
import java.util.Set;

public class TuringMachine {
	   private Tape tape;
	   private Map<Trigger, Action> program;
	   private Set<Integer> finalStates; // run halts when state is a member
	   private int state; // the current state
	   public void run() { ??? }
	   // etc.
	}