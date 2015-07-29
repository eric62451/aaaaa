
import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient element insertion and
 * removal. This class contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedList {

    private Node first;
    private LinkedList list;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        first = null;
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

    public boolean contains(Object obj) {
        Node temp = first;
        while (!(temp == null)) {
            if (obj.equals(temp.data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void reverse() {
        /*
         list = new LinkedList();
         Node temp = first;
         while (!(temp == null)) {
         list.addFirst(temp.data);
         temp = temp.next;
         }
         first = list.first;
         //System.out.println(temp.data.toString());
         */
        if (first == null || first.next == null) {
            return;
        }
        Node temp = first;
        Node aTemp;
        Node afirst = null;
        while (!(temp.next == null)) {
            temp = temp.next;
            afirst = temp;
        }
        while (!(first == afirst)) {
            aTemp = first;
            while (!(aTemp.next == temp)) {
                aTemp = aTemp.next;
                temp.next = aTemp;
            }
            if (aTemp == first) {
                temp.next = first;
                temp.next.next = null;
                first = afirst;
                return;
            }
            temp = first;
            while (!(temp.next == aTemp)) {
                temp = temp.next;
                aTemp.next = temp;
            }
            if (temp == first) {
                aTemp.next = first;
                aTemp.next.next = null;
                first = afirst;
                return;
            }
        }


    }

    /**
     * Returns the first element in the linked list.
     *
     * @return the first element in the linked list
     */
    public Object getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     *
     * @return the removed element
     */
    public Object removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Object element = first.data;
        first = first.next;
        return element;
    }

    /**
     * Adds an element to the front of the linked list.
     *
     * @param element the element to add
     */
    public void addFirst(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }

    /**
     * Returns an iterator for iterating through this list.
     *
     * @return an iterator for iterating through this list
     */
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    class Node {

        public Object data;
        public Node next;
    }

    class LinkedListIterator implements ListIterator {

        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
         * Constructs an iterator that points to the front of the linked list.
         */
        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
         * Moves the iterator past the next element.
         *
         * @return the traversed element
         */
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = position; // Remember for remove
            isAfterNext = true;

            if (position == null) {
                position = first;
            } else {
                position = position.next;
            }

            return position.data;
        }

        /**
         * Tests if there is an element after the iterator position.
         *
         * @return true if there is an element after the iterator position
         */
        public boolean hasNext() {
            if (position == null) {
                return first != null;
            } else {
                return position.next != null;
            }
        }

        /**
         * Adds an element before the iterator position and moves the iterator
         * past the inserted element.
         *
         * @param element the element to add
         */
        public void add(Object element) {
            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }

            isAfterNext = false;
        }

        /**
         * Removes the last traversed element. This method may only be called
         * after a call to the next() method.
         */
        public void remove() {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }

            if (position == first) {
                removeFirst();
            } else {
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
        }

        /**
         * Sets the last traversed element to a different value.
         *
         * @param element the element to set
         */
        public void set(Object element) {
            if (!isAfterNext) {
                throw new IllegalStateException();
            }
            position.data = element;
        }
    }
}
