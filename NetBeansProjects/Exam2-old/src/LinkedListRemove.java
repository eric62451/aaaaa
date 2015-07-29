import java.util.LinkedList;
import java.util.ListIterator;



public class LinkedListRemove
{
   public static void main(String[] args)
   {
      LinkedList list = new LinkedList();
      for (int i = 1; i <= 20; i++)
      {
         list.addLast("" + i);
      }
      reduceIt(3, list);
      System.out.println(list);
      System.out.println("Expected: [1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20]");
   }

   private static void reduceIt(int n, LinkedList list)
   {
      ListIterator iterator = list.listIterator();
      int count = 1;
      while (iterator.hasNext())
      {
         iterator.next();
         if (count % n == 0)
         {
            iterator.remove();
         }
         count++;
      }
   }
}