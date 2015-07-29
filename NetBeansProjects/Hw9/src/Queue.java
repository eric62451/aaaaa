
import java.util.NoSuchElementException;

public class Queue {

    private Node first;
    private Node position;
    private int size;

    public Queue() {
        first = null;
        position = null;
        size = 0;
    }

    class Node {

        public Object data;
        public Node next;
    }

    public void add(Object obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.next = null;
        if (first == null) {
            first = newNode;
            position = newNode;
        } else {
            position.next = newNode;
            position = newNode;
        }
        size++;
    }

    public Object remove() {
        if (first == null) {
            throw new NoSuchElementException("Queue is empty");
        } else if (first == position) {
            Object temp = first.data;
            first = null;
            position = null;
            return temp;

        } else {
            Object temp = first.data;
            first = first.next;
            return temp;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node temp = first;
        String elements = "[";
        while (!(temp == null)) {
            if (!(temp == first)) {
                elements = elements + ", ";
            }
            elements = elements + temp.data.toString();
            temp = temp.next;
        }
        elements = elements + "]";
        return elements;
    }
}
