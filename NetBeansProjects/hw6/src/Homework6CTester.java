import java.util.LinkedList;

public class Homework6CTester
{

   public static void main(String[] args)
   {
      LinkedList<String> staff = new LinkedList<String>();


      Homework6C.reverse(staff);
      System.out.println(staff);
      System.out.println("Expected: [Maria, Jose, Carlos, Jane, Alice, Richard, Bob, John]");
   }
}