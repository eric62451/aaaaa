
/**
 *  2-3 Tree
 *  CS146
 *  Section 4
 *  Eric Tam
 */
public class TwoThreeTree {

    Node head;
    boolean tempStarted;
    Node tempFirst;
    Node tempSecond;
    boolean recentSplit = false;

    class Node {

        boolean startedOne;
        boolean startedTwo;
        int[] keys = new int[3];
        Node[] child = new Node[3];
        public Node father;

        /**
        Search for value x in the tree, and return the node containing x or the leaf that x should be on.
        @param x, value to search for.
         */
        public Node search(int x) {
            Node iter = this;
            while (!(iter.child[0] == null && iter.child[1] == null && iter.child[2] == null)) {
                if (x == iter.keys[0] && iter.startedOne) {
                    break;
                }
                if (x == iter.keys[1] && iter.startedTwo) {
                    break;
                }
                if (x > iter.keys[0] && iter.startedTwo == false) {
                    iter = iter.child[1];
                } else if (x < iter.keys[0]) {
                    iter = iter.child[0];
                } else if (x > iter.keys[0] && x > iter.keys[1]) {
                    iter = iter.child[2];
                } else {
                    iter = iter.child[1];
                }
            }
            return iter;
        }

        /**
        Returns a string representation of the a node
         */
        public String toString() {
            if (startedOne == false && startedTwo == false) {
                return "";
            }
            if (startedOne && startedTwo) {
                return keys[0] + " " + keys[1];
            }
            if (startedOne && !startedTwo) {
                return "" + keys[0];
            }
            return null;
        }
    }

    /**
    Constructs an empty 2-3 tree
     */
    public TwoThreeTree() {
        Node a = new Node();
        a.startedOne = false;
        a.startedTwo = false;
        head = a;
    }

    /**
    Inserts value x into the 2-3 Tree
    @param x value to be inserted, repeated values will be ignored and return false
    @return True if successfully inserted x into the tree, otherwise false
     */
    public boolean insert(int x) {
        Node a = head.search(x);
        if (a.startedOne == false) {
            a.keys[0] = x;
            a.startedOne = true;
            return true;
        } else if (a.startedOne == true && a.startedTwo == false) {
            if (x > a.keys[0]) {
                a.keys[1] = x;
                a.startedTwo = true;
                return true;
            } else if (x != a.keys[0]) {
                a.keys[1] = a.keys[0];
                a.keys[0] = x;
                a.startedTwo = true;
            } else if (x == a.keys[0]) {
                return false;
            }
        } else {
            if (x == a.keys[0] || x == a.keys[1]) {
                return false;
            } else if (x > a.keys[0] && x > a.keys[1]) {
                int temp = a.keys[1];
                a.keys[1] = x;
                a.keys[2] = temp;
                tempStarted = true;
            } else if (x > a.keys[0] && x < a.keys[1]) {
                a.keys[2] = x;
                tempStarted = true;
            } else if (x < a.keys[0] && x < a.keys[1]) {
                int temp = a.keys[0];
                a.keys[0] = x;
                a.keys[2] = temp;
                tempStarted = true;
            }

        }
        Node iter = a;
        while (tempStarted == true) {
            iter = raise(iter);
        }
        return true;
    }

    /**
    Search for x value in the 2-3 tree
    @return a string representation of the node containing x or the leaf where x should be in.
     */
    public String search(int x) {
        return head.search(x).toString();
    }

    /**
    Raises a key on a node containing 3 keys
    @return returns the father of the given node
     */
    private Node raise(Node a) {
        if (a.father == null) {
            a.father = new Node();
            a.father.keys[0] = a.keys[2];
            head = a.father;
            a.keys[2] = 0;
            tempStarted = false;
            a.father.startedOne = true;

            split(a);
            a.father.child[0] = tempFirst;
            a.father.child[1] = tempSecond;
            tempFirst = null;
            tempSecond = null;
            recentSplit = false;
            return null;
        }
        int temp = a.keys[2];
        a.keys[2] = 0;
        if (a.father.startedOne == true && a.father.startedTwo == false) {
            if (a.father.keys[0] != temp) {
                if (a.father.keys[0] < temp) {
                    a.father.keys[1] = temp;
                    a.father.startedTwo = true;
                } else {
                    a.father.keys[1] = a.father.keys[0];
                    a.father.keys[0] = temp;
                    a.father.startedTwo = true;
                }
                tempStarted = false;
                split(a);
                int i;
                for (i = 0; i < 2; i++) {
                    if (a.father.child[i] == null) {
                        break;
                    }
                }
                if(i==0)a.father.child[2] = a.father.child[1];
                a.father.child[i] = tempFirst;
                a.father.child[i + 1] = tempSecond;
                tempFirst = null;
                tempSecond = null;
                recentSplit = false;
            }
        } else if (a.father.startedOne == true && a.father.startedTwo == true) {
            if (a.father.keys[0] > temp && temp < a.father.keys[1]) {
                a.father.keys[2] = a.father.keys[0];
                a.father.keys[0] = temp;
            } else if (a.father.keys[0] < temp && temp > a.father.keys[1]) {
                a.father.keys[2] = a.father.keys[1];
                a.father.keys[1] = temp;
            } else if (a.father.keys[0] < temp && temp < a.father.keys[1]) {
                a.father.keys[2] = temp;
            }
            split(a);
            return a.father;
        }
        return null;
    }

    /**
    Splits the given node
     */
    private void split(Node current) {
        Node a = new Node();
        Node b = new Node();
        if (recentSplit == true) {
            for (int i = 0; i < 3; i++) {
                if (current.father.child[i] == current) {
                    current.father.child[i] = null;
                }
            }
            a.father = current.father;
            b.father = current.father;
            a.keys[0] = current.keys[0];
            b.keys[0] = current.keys[1];
            a.startedOne = true;
            b.startedOne = true;
            if (current.child[0] == null) {
                a.child[0] = tempFirst;
                a.child[0].father = a;
                a.child[1] = tempSecond;
                a.child[1].father = a;
                b.child[0] = current.child[1];
                b.child[0].father = b;
                b.child[1] = current.child[2];
                b.child[1].father = b;
            } else if (current.child[1] == null) {
                a.child[0] = current.child[0];
                a.child[0].father = a;
                a.child[1] = tempFirst;
                a.child[1].father = a;
                b.child[0] = tempSecond;
                b.child[0].father = b;
                b.child[1] = current.child[2];
                b.child[1].father = b;
            } else if (current.child[2] == null) {
                a.child[0] = current.child[0];
                a.child[0].father = a;
                a.child[1] = current.child[1];
                a.child[1].father = a;
                b.child[0] = tempFirst;
                b.child[0].father = b;
                b.child[1] = tempSecond;
                b.child[1].father = b;
            }
            tempFirst = a;
            tempSecond = b;
        } else {
            for (int i = 0; i < 3; i++) {
                if (current.father.child[i] == current) {
                    current.father.child[i] = null;
                }
            }
            a.father = current.father;
            b.father = current.father;
            a.keys[0] = current.keys[0];
            b.keys[0] = current.keys[1];
            a.startedOne = true;
            b.startedOne = true;
            recentSplit = true;
            tempFirst = a;
            tempSecond = b;
        }

    }
}
