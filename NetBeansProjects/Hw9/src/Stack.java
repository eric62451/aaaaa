
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack {

    private int position;
    private ArrayList<Object> buffer;

    public Stack() {
        final int INITIAL_SIZE = 10;
        buffer = new ArrayList<Object>();
        position = 0;
    }

    public Object pop() {
        if(position <= 0) throw new NoSuchElementException("Stack is empty");
        else{
        Object temp = buffer.get(position-1);
        position--;
        return temp;
        }
    }

    public boolean empty(){
        if(position<=0) return true;
        else return false;
    }

    public void push(Object obj) {
        buffer.add(obj);
        position++;
    }

    public int size() {
        return position;
    }

    public String toString(){
        return buffer.toString();
    }
}
