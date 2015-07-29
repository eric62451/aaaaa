/**
   This program tests the binary search tree class.
*/
public class LargestTester
{
   public static void main(String[] args)
   {
      BinarySearchTree t = new BinarySearchTree();
      t.add("D");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("F");
      t.add("F");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
      System.out.println(t.largest());
      System.out.println("Expected: J");

      t = new BinarySearchTree();
      t.add("D");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("X");
      t.add("F");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
      System.out.println(t.largest());
      System.out.println("Expected: X");

      t = new BinarySearchTree();
      t.add("Z");
      t.add("B");
      t.add("A");
      t.add("C");
      t.add("F");
      t.add("F");
      t.add("I");
      t.add("G");
      t.add("H");
      t.add("J");
      System.out.println(t.largest());
      System.out.println("Expected: Z");

      t = new BinarySearchTree();
      System.out.println(t.largest());
      System.out.println("Expected: null");
   }
}