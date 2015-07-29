import java.util.ArrayList;

public class TwoThreeTree
{
    private Node root;
    public TwoThreeTree()
    {
        root=null;
    }

    public boolean insert(int x)
    {
        if(root==null)
        {
            Node newNode = new Node(x);
            root=newNode;
            return true;
        }
        return root.insert(x);
    }

    public String search(int x)
    {
        if (root==null) return null;
        return root.search(x)+ "";
    }

    class Node
    {
        Node parent=null;
        ArrayList<Node> child=new ArrayList<Node>();
        ArrayList<Integer> keys=new ArrayList<Integer>(); //keys, or values.

        public Node(){}
        public Node(int value){keys.add(value);}
        public Node(int value, Node n1, Node n2)
        {
            keys.add(value);
            child.add(n1);
            child.add(n2);
            n1.parent=this;
            n2.parent=this;
        }

        public boolean insert(int value)
        {
            Node rightPosition=search(value);
            //checks for dupulicate values.
            if (rightPosition.keys.contains(value)) return false;
            Node newNode= new Node(value);
            newNode.parent=rightPosition.parent;
            rightPosition.split(newNode);
            return true;
        }

        public Node search(int value)
        {
            if(keys.contains(value)) return this;
            int i=0;
            while(!isLeaf() && i<keys.size())
            {
                if(value<keys.get(i)) return child.get(i).search(value);
                else if (i==keys.size()-1) return child.get(i+1).search(value);
                i++;
            }
            return this;
        }

        private void split(Node adding)
        {
            //finding the right index of the new key value(shifting right keys as well)
            int keyIndex=keys.size()-1;
            int value=adding.keys.get(0);
            keys.add(0); //adding a dummy value to make the array bigger.
            while(keyIndex>=0 && value<=keys.get(keyIndex))
            {
                    keys.set(keyIndex+1,keys.get(keyIndex));
                    keyIndex--;
            }
            keyIndex++;
            keys.set(keyIndex,value);

            //copy the child into the arrays
            if(!adding.child.isEmpty())
            {
                child.add(new Node()); //adding a dummy value to make the array bigger.
                child.add(new Node());
                int i;
                for(i=child.size()-3;i>=keyIndex;i--)
                {
                    child.set(i+2,child.get(i));
                }
                child.set(keyIndex,adding.child.get(0));
                child.set(keyIndex+1,adding.child.get(1));
            }

            //it will split if there is more than 3 keys
            if(keys.size()==3)
            {
                Node left,right;
                if (isLeaf()) //3keys but no chil situation
                {
                    left= new Node(keys.get(0));
                    right= new Node(keys.get(2));
                }
                else  //3keys 4 nodes situation
                {
                    left=new Node(keys.get(0),child.get(0),child.get(1));
                    right= new Node(keys.get(2),child.get(2),child.get(3));
                }
                keys.remove(2);
                keys.remove(0);
                child.clear();
                child.add(left);
                child.add(right);
		left.parent=this;
                right.parent=this;
                if(!isRoot()) //any split in non-root nodes situation
                {
                    Node oldParent=parent;
                    parent=parent.parent;
            	    oldParent.child.remove(this);
     	            oldParent.split(this);
                }
            }
        }

        private boolean isLeaf()
        {
            if (child.isEmpty()) return true;
            else return false;
        }

        private boolean isRoot()
        {
            if (parent==null) return true;
            else return false;
        }

        @Override
        public String toString()
        {
            String result="";
            for (int i=0;i<keys.size();i++)
            {
                if (i!=0) result=result+" ";
                result+=keys.get(i);
            }
            return result;
        }
    }
}