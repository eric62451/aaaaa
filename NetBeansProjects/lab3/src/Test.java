import java.util.*;

public class Test
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      String line = in.nextLine();
      if (line.startsWith(args[0]))
         System.out.println("match");
      else
         System.out.println("no match");
   }
}