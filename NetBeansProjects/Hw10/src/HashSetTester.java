import java.util.Iterator;

/**
   This program demonstrates the hash set class.
*/
public class HashSetTester
{
   public static void main(String[] args)
   {
      HashSet names = new HashSet(5);

      names.add("Harry");
      names.add("Sue");
      names.add("Nina");
      names.add("Susannah");
      names.add("Larry");

      names.add("Eve");

      System.out.println(names.size() + " " + names.getlength());
      System.out.println("Expected: 6 10");

      names.add("Sarah");
      names.add("Adam");
      names.add("Tony");
      names.add("Katherine");
      names.add("Juliet");
      names.add("Romeo");

      System.out.println(names.getCollisions());
      System.out.println("Expected: 3");

      System.out.println(names.size() + " " + names.getlength());
      System.out.println("Expected: 12 20");

      names.remove("Romeo");
      names.remove("George");

      names.remove("Harry");
      names.remove("Larry");

      System.out.println(names.size() + " " + names.getlength());
      System.out.println("Expected: 9 10");


      names.remove("Juliet");
      names.remove("Katherine");
      names.remove("Tony");
      names.remove("Adam");
      names.remove("Sue");

      System.out.println(names.size() + " " + names.getlength());
      System.out.println("Expected: 4 5");

      Iterator iter = names.iterator();
      while (iter.hasNext())
      {
         System.out.print(iter.next()+ " ");
      }

      System.out.println("\nExpected: Sarah Nina Eve Susannah");
   }
}