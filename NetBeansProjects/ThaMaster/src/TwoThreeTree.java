/**
 * This class implements a binary search tree whose
 * nodes hold objects that implement the Comparable
 * interface.
 */
public class TwoThreeTree
{
    Node root;
    /**
     * constructor new tree
     */
    public TwoThreeTree()
    {
        Node brandNew = new Node();
        root = brandNew;//refresh the whole tree
        root.oneElement = false;
        root.twoElement = false;
    }
    /**
     * insert x to the correct position and return true if did insert
     * @param x the int that need to insert
     * @return true if inserted else false
     */
    public boolean insert(int x)
    {
        Node some = root.search(x);
        if ((some.oneElement&&some.key[0] == x) || (some.twoElement&&some.key[1] == x)) {
            return false;
        }//search for duplicate
        else if(!some.oneElement && !some.twoElement)//empty array
        {
            some.key[0]=x;
            some.oneElement = true;
            return true;
        }
        else if(some.oneElement && !some.twoElement)//one element in the array
        {
            if(x > some.key[0])//in order
            {
                some.key[1] = x;
                some.twoElement = true;
                return true;
            }
            else
            {
                some.key[1] = some.key[0];
                some.key[0] = x;
                some.twoElement = true;//not in order
                return true;
            }
        }
        else if (some.oneElement && some.twoElement)
        {
            if(x > some.key[0] && x > some.key[1])//
            {
                int temp = some.key[1];
                some.key[1] = x;
                some.key[2] = temp;// not in order for raise, switch the position
            }
            else if(x < some.key[0] && x < some.key[1])
            {
                int temp = some.key[0];
                some.key[0]= x;
                some.key[2]= temp;
            }
            else if(x > some.key[0] && x < some.key[1])
            {
                some.key[2] = x;// they are in order for raise
            }
            raise(some);
        }


        return true;
    }
    /**
     * raise up the key to its parent
     * @param k the node that need to raise and split
     * @return null, don't need a return
     */
     private Node raise(Node k)
    {
        if(k.parent == null) //no parent, make a new node, assign #
        {
            k.parent = new Node();
            k.parent.key[0] = k.key[2];
            root = k.parent;
            k.key[2]= 0;
            k.parent.oneElement = true;
            split(k);
            return null;
        }
        else
        {
            if(k.parent.twoElement)//have two key in the node, should be raise
            {
                if(k.key[2] >k.parent.key[1] )
                {
                    int temp = k.parent.key[1];
                    k.parent.key[1]= k.key[2];
                    k.parent.key[2]= temp;
                }
                else if(k.key[2] < k.parent.key[0] )
                {
                    int temp = k.parent.key[0];
                    k.parent.key[0]=k.key[2];
                    k.parent.key[2] = temp;
                }
                else
                {
                    k.parent.key[2]= k.key[2];
                }
                split(k);
                raise(k.parent);
            }
            else
            {
                if(k.parent.key[0]> k.key[2])
                {
                    int temp = k.parent.key[0];
                    k.parent.key[0]= k.key[2];
                    k.parent.key[1]= temp;
                    k.parent.twoElement= true;
                    split(k);
                    return null;
                }
                else
                {
                    k.parent.key[1]= k.key[2];
                    k.parent.twoElement= true;
                    split(k);
                    return null;
                }
            }
        }
        return null;

    }
     /**
      * split the node after raise
      * @param k the reminder of key in Node k need to split
      * @param a the new Node that created for the split, the left one
      * @param b the new Node that created for the split, the right one
      */
    private void split(Node k)
    {
        Node a = new Node();
        Node b = new Node();
        a.parent = k.parent;
        b.parent = k.parent;
        a.key[0] = k.key[0];
        b.key[0] = k.key[1];
        a.oneElement = true;
        b.oneElement = true;//new node separete left and right, assignment first key, and boolean #
        if(k.children[0]!= null)
        {
            a.children[0]= k.children[0];
            a.children[0].parent = a;
            a.children[1]= k.children[1];
            a.children[1].parent = a;
            b.children[0]= k.children[2];
            b.children[0].parent = b;
            b.children[1]= k.children[3];
            b.children[1].parent = b;
        }
        if(k.parent.children[0]==null && k.parent.children[1]==null && k.parent.children[2]==null){
            k.parent.children[0] = a;
            a.parent = k.parent;
            k.parent.children[1] = b;
            b.parent = k.parent;
        } else if(k.equals(k.parent.children[0])){
            k.parent.children[0] = a;
            a.parent = k.parent;
            Node temp1 = k.parent.children[1];
            Node temp2 = k.parent.children[2];
            k.parent.children[2] = temp1;
            k.parent.children[3] = temp2;
            k.parent.children[1] = b;
            b.parent = k.parent;
        } else if(k.equals(k.parent.children[1])){
            k.parent.children[1] = a;
            a.parent = k.parent;
            Node temp2 = k.parent.children[2];
            k.parent.children[3] = temp2;
            k.parent.children[2] = b;
            b.parent = k.parent;
        } else if(k.equals(k.parent.children[2])){
            k.parent.children[2] = a;
            a.parent = k.parent;
            k.parent.children[3] = b;
            b.parent = k.parent;
        }
        
    }
    /**
     * search for the int x, and return to its position, and toString
     * @param x
     * @return
     */
    public String search(int x)
    {
        return root.search(x).toString();
    }
    class Node
    {
        int [] key = new int [3];
        Node[] children = new Node[4];
        public Node parent;
        boolean oneElement;
        boolean twoElement;
        /**
         * search its position
         * @param x search for int x
         * @return the node that contain x or nearby
         */
        public Node search(int x)
        {
            Node a = this;
            while (!(a.children[0] == null && a.children[1] == null && a.children[2] == null))
            {
                if (x == a.key[1] && a.twoElement) {
                    break; //the x is the second key
                }
                else if (x == a.key[0] && a.oneElement) {
                    break; // the x is the frist key
                }

                else if (x > a.key[0] && a.twoElement == false) {
                    a = a.children[1]; //not found, but go for the second one
                }
                else if (x < a.key[0]) {
                    a = a.children[0]; //move to chilren 1
                }
                else if(x > a.key[0] && x > a.key[1]){
                    a = a.children[2];//move to third children
                }
                else {
                    a = a.children[1];//move to second children
                }
            }
            return a;
        }
        /**
         * toString the two element
         * @return a string contain the node key
         */
        public String toString()
        {
            if (!oneElement && !twoElement)
            {
                return "";

            }
            if(oneElement && !twoElement)
            {
                return "" +key[0];
            }
            if(oneElement && twoElement)
            {
                return key[0] + " " + key[1];
            }
            else
                return null;
        }
    }
}