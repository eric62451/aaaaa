public class Hw2BTester2
{
   public static void main(String[] args)
   {
      Circle c1 = new Circle(10.0);
      Circle c2 = new Circle(10.0);
      System.out.println(c1.equals(c2));
      System.out.println("Expected: true");

      LabeledCircle c3 = new LabeledCircle(10, "red");

      System.out.println(c3.equals(c1));
      System.out.println("Expected: false");
      System.out.println(c3.equals(c3));
      System.out.println("Expected: true");

   }
}
