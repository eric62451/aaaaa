import java.util.LinkedList;
import java.util.ListIterator;

public class Homework6CDraft
{
   public static void reverse(LinkedList<String> list)
   {
      ListIterator<String> iter = list.listIterator();
      while(!(list.size() == 0)){
          list.removeFirst();
      }
   }
}