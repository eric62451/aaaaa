package TM;

public class Action {

	int nextState;
	char newBit;
	int direction;
	
	public Action(int state, char bit, int direct) {
		direction = direct;
		newBit = bit;
		nextState = state;
		// TODO Auto-generated constructor stub
	}
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getNewBit() {
		return newBit;
	}
	public void setNewBit(char newBit) {
		this.newBit = newBit;
	}
	public void setNextState(int nextState) {
		this.nextState = nextState;
	}
}
