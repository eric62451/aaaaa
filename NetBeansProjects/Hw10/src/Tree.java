import java.util.List;
import java.util.ArrayList;

/**
   A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
   private Node root;

   class Node
   {
      public Object data;
      public List<Node> children;

      /**
         Computes the size of the subtree whose root is this node.
         @return the number of nodes in the subtree
      */
      public int size()
      {
         int sum = 0;
         for (Node child : children) { sum = sum + child.size(); }
         return 1 + sum;
      }
   }

   /**
      Constructs an empty tree.
   */
   public Tree()
   {
      root = null;
   }

   /**
      Constructs a tree with one node and no children.
      @param rootData the data for the root
   */
   public Tree(Object rootData)
   {
      root = new Node();
      root.data = rootData;
      root.children = new ArrayList<Node>();
   }

   public int leaves(){
       class Temp{
           public int leavesNum(Node temp){
               int number = 0;
               for(Node s : temp.children){
                   if(s.children.isEmpty()) number++;
                   else number = number + leavesNum(s);
               }
               return number;
           }
       }
       if(root == null) return 0;
       if(root.children.isEmpty()) return 1;
       int count = 0;
       Temp check = new Temp();
       for(Node child : root.children){
           if(child.children.isEmpty()) count++;
           else count = count + check.leavesNum(child);
       }
       return count;
   }

   public String printTree(){
       String temp;
       temp = root.data+"";
       for(Node s : root.children){
           temp = temp+" "+s.data;
       }
       //return temp;




       class Temp{
           public String print(int level, Node temp){
               String trees = "";
               level++;
               for(Node s : temp.children){
                   for(int i = 0; i<level;i++){
                       trees = trees + "   ";
                   }
                   if(s.children.isEmpty()) trees = trees + s.data.toString() + "\n";
                   else {
                       trees = trees + s.data.toString() + "\n";
                       trees = trees + print(level, s);
                   }
               }
               return trees;
           }
       }
       if(root == null) return null;
       String str = "";
       str = str + root.data + "\n";
       Temp check = new Temp();
       for(Node child : root.children){
           str = str + "   ";
           if(child.children.isEmpty()) str = str + child.data.toString() + "\n";
           else {
               str = str + child.data.toString() + "\n";
               str = str + check.print(1, child);
           }
       }
       return str;
   }

   /**
      Adds a subtree as the last child of the root.
   */
   public void addSubtree(Tree subtree)
   {
      root.children.add(subtree.root);
   }

   /**
      Computes the size of this tree.
      @return the number of nodes in the tree
   */
   public int size()
   {
      if (root == null) { return 0; }
      else { return root.size(); }
   }

   // Additional methods will be added in later sections.
}