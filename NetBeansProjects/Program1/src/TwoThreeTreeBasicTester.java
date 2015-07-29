
public class TwoThreeTreeBasicTester
{
   public static void main(String[] args)
   {
      testFirstSplitLeft();
      testFirstSplitRight();
      testFirstSplitMiddle();
   }

   public static void testFirstSplitLeft()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(9);
      t.insert(15);
      t.insert(1);

      String expected = "9";
      System.out.println(t.search(9));
      System.out.println("Expected:  " + expected);

      expected = "15";
      System.out.println(t.search(15));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(17));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(11));
      System.out.println("Expected:  " + expected);

      expected = "1";
      System.out.println(t.search(1));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(0));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(3));
      System.out.println("Expected:  " + expected);
   }

   public static void testFirstSplitRight()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(1);
      t.insert(9);
      t.insert(15);

      String expected = "9";
      System.out.println(t.search(9));
      System.out.println("Expected:  " + expected);
      expected = "15";
      System.out.println(t.search(15));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(17));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(11));
      System.out.println("Expected:  " + expected);

      expected = "1";
      System.out.println(t.search(1));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(0));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(3));
      System.out.println("Expected:  " + expected);
   }

   public static void testFirstSplitMiddle()
   {
      TwoThreeTree t = new TwoThreeTree();
      t.insert(1);
      t.insert(15);
      t.insert(9);

      String expected = "9";
      System.out.println(t.search(9));
      System.out.println("Expected:  " + expected);
      expected = "15";
      System.out.println(t.search(15));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(17));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(11));
      System.out.println("Expected:  " + expected);

      expected = "1";
      System.out.println(t.search(1));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(0));
      System.out.println("Expected:  " + expected);
      System.out.println(t.search(3));
      System.out.println("Expected:  " + expected);
   }
}