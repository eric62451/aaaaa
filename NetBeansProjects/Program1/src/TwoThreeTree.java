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
        public int temp;
        public int first;
        public int second;
        public Node childOne;
        public Node childTwo;
        public Node childThree;
        public Node father;

        /**
            Search for value x in the tree, and return the node containing x or the leaf that x should be on.
            @param x, value to search for.
         */
        public Node search(int x){
            Node iter = this;
            while (!(iter.childOne == null && iter.childTwo == null && iter.childThree == null)) {
            if (x == iter.first && iter.startedOne) {
                break;
            }
            if (x == iter.second && iter.startedTwo) {
                break;
            }
            if (x > iter.first && iter.startedTwo == false) {
                iter = iter.childTwo;
            } else if (x < iter.first) {
                iter = iter.childOne;
            } else if (x > iter.first && x > iter.second) {
                iter = iter.childThree;
            } else {
                iter = iter.childTwo;
            }
        }
        return iter;
        }
            /**
                Returns a string representation of the a node
            */
        public String toString(){
            if (startedOne == false && startedTwo == false) {
            return "";
        }
        if (startedOne && startedTwo) {
            return first + " " + second;
        }
        if (startedOne && !startedTwo) {
            return "" + first;
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
            a.first = x;
            a.startedOne = true;
            return true;
        } else if (a.startedOne == true && a.startedTwo == false) {
            if (x > a.first) {
                a.second = x;
                a.startedTwo = true;
                return true;
            } else if (x != a.first) {
                a.second = a.first;
                a.first = x;
                a.startedTwo = true;
            } else if (x == a.first) {
                return false;
            }
        } else if (a.startedOne == true && a.startedTwo == true) {
            if (x == a.first || x == a.second) {
                return false;
            } else if (x > a.first && x > a.second) {
                int temp = a.second;
                a.second = x;
                a.temp = temp;
                tempStarted = true;
            } else if (x > a.first && x < a.second) {
                a.temp = x;
                tempStarted = true;
            } else if (x < a.first && x < a.second) {
                int temp = a.first;
                a.first = x;
                a.temp = temp;
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
            a.father.first = a.temp;
            head = a.father;
            a.temp = 0;
            tempStarted = false;
            a.father.startedOne = true;
            
            split(a);
            a.father.childOne = tempFirst;
            a.father.childTwo = tempSecond;
            tempFirst = null;
            tempSecond = null;
            recentSplit = false;
            return null;
        }
        int temp = a.temp;
        a.temp = 0;
        if (a.father.startedOne == true && a.father.startedTwo == false) {
            if (a.father.first != temp) {
                if (a.father.first < temp) {
                    a.father.second = temp;
                    a.father.startedTwo = true;
                } else {
                    a.father.second = a.father.first;
                    a.father.first = temp;
                    a.father.startedTwo = true;
                }
                tempStarted = false;
                split(a);
                if (a.father.childOne == null) {
                    a.father.childThree = a.father.childTwo;
                    a.father.childOne = tempFirst;
                    a.father.childTwo = tempSecond;
                    tempFirst = null;
                    tempSecond = null;
                    recentSplit = false;
                } else if (a.father.childTwo == null) {
                    a.father.childTwo = tempFirst;
                    a.father.childThree = tempSecond;
                    tempFirst = null;
                    tempSecond = null;
                    recentSplit = false;
                }
            }
        } else if (a.father.startedOne == true && a.father.startedTwo == true) {
            if (a.father.first > temp && temp < a.father.second) {
                a.father.temp = a.father.first;
                a.father.first = temp;
                split(a);
                return a.father;
            } else if (a.father.first < temp && temp > a.father.second) {
                a.father.temp = a.father.second;
                a.father.second = temp;
                split(a);
                return a.father;
            } else if (a.father.first < temp && temp < a.father.second) {
                a.father.temp = temp;
                split(a);
                return a.father;
            }
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
            if (current.father.childOne == current) {
                current.father.childOne = null;
            }
            if (current.father.childTwo == current) {
                current.father.childTwo = null;
            }
            if (current.father.childThree == current) {
                current.father.childThree = null;
            }
            a.father = current.father;
            b.father = current.father;
            a.first = current.first;
            b.first = current.second;
            a.startedOne = true;
            b.startedOne = true;
            if (current.childOne == null) {
                a.childOne = tempFirst;
                a.childOne.father = a;
                a.childTwo = tempSecond;
                a.childTwo.father = a;
                b.childOne = current.childTwo;
                b.childOne.father = b;
                b.childTwo = current.childThree;
                b.childTwo.father = b;
            } else if (current.childTwo == null) {
                a.childOne = current.childOne;
                a.childOne.father = a;
                a.childTwo = tempFirst;
                a.childTwo.father = a;
                b.childOne = tempSecond;
                b.childOne.father = b;
                b.childTwo = current.childThree;
                b.childTwo.father = b;
            } else if (current.childThree == null) {
                a.childOne = current.childOne;
                a.childOne.father = a;
                a.childTwo = current.childTwo;
                a.childTwo.father = a;
                b.childOne = tempFirst;
                b.childOne.father = b;
                b.childTwo = tempSecond;
                b.childTwo.father = b;
            }
            tempFirst = a;
            tempSecond = b;
        } else if (recentSplit == false) {
            if (current.father.childOne == current) {
                current.father.childOne = null;
            }
            if (current.father.childTwo == current) {
                current.father.childTwo = null;
            }
            if (current.father.childThree == current) {
                current.father.childThree = null;
            }
            a.father = current.father;
            b.father = current.father;
            a.first = current.first;
            b.first = current.second;
            a.startedOne = true;
            b.startedOne = true;
            recentSplit = true;
            tempFirst = a;
            tempSecond = b;
        }

    }
}
