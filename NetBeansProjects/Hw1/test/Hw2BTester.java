public class Hw2BTester
{
   public static void main(String[] args)
   {
      Circle c1 = new Circle(10.0);
      Circle c2 = new Circle(100.0);
      System.out.println( c1.toString());
      System.out.println("Expected: Circle[r=10.0]");

      System.out.println(c1.equals(c2));
      System.out.println("Expected: false");

      LabeledCircle c3 = new LabeledCircle(10, "red");
      LabeledCircle c4 = new LabeledCircle(10, "blue");

      System.out.println(c3.equals(c4));
      System.out.println("Expected: false");
      System.out.println( c3.toString());
      System.out.println("Expected: LabeledCircle[r=10.0][label=red]");
   }

}