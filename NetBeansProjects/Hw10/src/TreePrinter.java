/**
   This class demonstrates the tree class.
*/
public class TreePrinter
{
   public static void main(String[] args)
   {
      Tree t1 = new Tree("Anne");
      Tree t2 = new Tree("Peter");
      t1.addSubtree(t2);
      Tree t3 = new Tree("Zara");
      t1.addSubtree(t3);
      Tree t4 = new Tree("Savannah");
      t2.addSubtree(t4);
      t1.addSubtree(new Tree("Bill"));
      Tree t5  = new Tree("Carlos");
      t5.addSubtree(new Tree("Fred"));
      t5.addSubtree(new Tree("Jesus"));
      Tree t6 = new Tree("Ching");
      t4.addSubtree(t5);
      t4.addSubtree(t6);
      t3.addSubtree(new Tree("Sarah"));

      System.out.println(t1.printTree());

   }
}