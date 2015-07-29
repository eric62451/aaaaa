/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
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
        public int level;
        public Node father;
    }

    public TwoThreeTree() {
        Node a = new Node();
        a.startedOne = false;
        a.startedTwo = false;
        a.level = 0;
        head = a;
    }

    public boolean insert(int x) {
        Node iter = head;
        while (!(iter.childOne == null && iter.childTwo == null && iter.childThree == null)) {
            if (x == iter.first && iter.startedOne) {
                return false;
            }
            if (x == iter.second && iter.startedTwo) {
                return false;
            }
            if (x > iter.first && iter.startedTwo == false) {
                iter = iter.childTwo;
            } else if (x < iter.first && iter.startedTwo == false) {
                iter = iter.childOne;
            } else if (x < iter.first && x < iter.second) {
                iter = iter.childOne;
            } else if (x > iter.first && x > iter.second) {
                iter = iter.childThree;
            } else if (x > iter.first && x < iter.second) {
                iter = iter.childTwo;
            }

        }
        return add(iter, x);
    }

    public String search(int x) {
        Node iter = head;
        while (!(iter.childOne == null && iter.childTwo == null && iter.childThree == null)) {
            if (x == iter.first || x == iter.second) {
                if(x==iter.first && iter.startedOne) break;
                if(x==iter.second && iter.startedTwo) break;
            }
            if (x > iter.first && iter.startedTwo == false) {
                iter = iter.childTwo;
            } else if (x < iter.first && iter.startedTwo == false) {
                iter = iter.childOne;
            } else if (x < iter.first && x < iter.second) {
                iter = iter.childOne;
            } else if (x > iter.first && x > iter.second) {
                iter = iter.childThree;
            } else if (x > iter.first && x < iter.second) {
                iter = iter.childTwo;
            }
        }
        if (iter.startedOne == false && iter.startedTwo == false) {
            return "";
        }
        if (iter.startedOne && iter.startedTwo) {
            return iter.first + " " + iter.second;
        }
        if (iter.startedOne && !iter.startedTwo) {
            return "" + iter.first;
        }
        return null;
    }

    private boolean add(Node a, int x) {
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
                a.temp = temp;//raise(a,temp);
                tempStarted = true;
            } else if (x > a.first && x < a.second) {
                a.temp = x;//raise(a, x);
                tempStarted = true;
            } else if (x < a.first && x < a.second) {
                int temp = a.first;
                a.first = x;
                a.temp = temp;//raise(a,temp);
                tempStarted = true;
            }

        }
        Node iter = a;
        while (tempStarted == true) {
            iter = raise(iter);
        }
        return true;
    }

    private Node raise(Node a) {
        if (a.father == null) {
            a.father = new Node();
            a.father.first = a.temp;
            head = a.father;
            a.temp = 0;
            a.father.level = a.level + 1;
            tempStarted = false;
            a.father.startedOne = true;
            
            split(a);
            a.father.childOne = tempFirst;
            a.father.childTwo = tempSecond;
            //a.father.childOne.father = a.father;
            //a.father.childTwo.father = a.father;
            tempFirst = null;
            tempSecond = null;
            recentSplit = false;
            return null;
        }
        int temp = a.temp;
        a.temp = 0;
        //a = a.father;
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
            //a = a.father;
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
            a.level = current.level;
            b.level = current.level;
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
            a.level = current.level;
            b.level = current.level;
            tempFirst = a;
            tempSecond = b;
        }

    }
}
