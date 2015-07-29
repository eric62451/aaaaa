/**
   This class demonstrates the tree class.
*/
public class TreeTester
{
   public static void main(String[] args)
   {
      Tree t = new Tree();
      System.out.println(t.leaves());
      System.out.println("Expected: " + 0);

      Tree t1 = new Tree("Anne");
      System.out.println(t1.leaves());
      System.out.println("Expected: " + 1);

      Tree t2 = new Tree("Peter");
      t1.addSubtree(t2);
      Tree t3 = new Tree("Zara");
      t1.addSubtree(t3);
      Tree t4 = new Tree("Savannah");
      t2.addSubtree(t4);
      t1.addSubtree(new Tree("Bill"));
      t2.addSubtree(new Tree("a"));
      t2.addSubtree(new Tree("b"));
      System.out.println(t1.leaves());
      System.out.println("Expected: " + 3);

      Tree t5  = new Tree("Carlos");
      Tree t6 = new Tree("Ching");
      t4.addSubtree(t5);
      t4.addSubtree(t6);
      t3.addSubtree(new Tree("Sarah"));
      System.out.println(t1.leaves());
      System.out.println("Expected: " + 4);

   }
}
