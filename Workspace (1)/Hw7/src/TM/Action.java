package TM;

public class Action {

	int nextState;
	int newBit;
	int direction;
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getNewBit() {
		return newBit;
	}
	public void setNewBit(int newBit) {
		this.newBit = newBit;
	}
	public void setNextState(int nextState) {
		this.nextState = nextState;
	}
}
