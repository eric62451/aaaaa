public class Arguments
{
   public static void main(String[] args)
   {
      if (args.length < 1)
      {
         System.out.println("Usage java Arguments filename");
         System.exit(1);
      }
      else
      {
         System.out.println(args[0]);
         System.out.println("Expected: smallNames.txt");
      }
   }
}