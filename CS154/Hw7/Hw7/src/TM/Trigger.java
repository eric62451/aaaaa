package TM;

public class Trigger {
	
	int currentState;
	char currentBit;
	
	public Trigger(int state, char bit) {
		currentState = state;
		currentBit = bit;
		// TODO Auto-generated constructor stub
	}
	
	public int getCurrentBit() {
		return currentBit;
	}
	public void setCurrentBit(char currentBit) {
		this.currentBit = currentBit;
	}
	public int getCurrentState() {
		return currentState;
	}
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	
	@Override
	public boolean equals(Object obj) {
		Trigger a = (Trigger) obj;
		return a.currentBit == currentBit && a.currentState == currentState;
	}
	
	@Override
	public int hashCode() {
		return currentState + currentBit;
	}

}
