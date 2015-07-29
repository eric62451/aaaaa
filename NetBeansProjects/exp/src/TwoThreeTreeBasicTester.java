public class TwoThreeTreeBasicTester
{
   public static void main(String[] args)
   {
      testIncreasing();
      testDecreasing();
   }

   public static void testIncreasing()
   {
      TwoThreeTree t = new TwoThreeTree();
      for(int i = 1; i < 15; i++)
         t.insert(i*2);
      System.out.println(t.search(1));
      System.out.println("Expected:  2");
      System.out.println(t.search(2));
      System.out.println("Expected:  2");
      System.out.println(t.search(3));
      System.out.println("Expected:  2");
      System.out.println(t.search(4));
      System.out.println("Expected:  4");
      System.out.println(t.search(5));
      System.out.println("Expected:  6");
      System.out.println(t.search(6));
      System.out.println("Expected:  6");
      System.out.println(t.search(7));
      System.out.println("Expected:  6");
      System.out.println(t.search(8));
      System.out.println("Expected:  8 16");
      System.out.println(t.search(9));
      System.out.println("Expected:  10");
      System.out.println(t.search(10));
      System.out.println("Expected:  10");
      System.out.println(t.search(11));
      System.out.println("Expected:  10");
      System.out.println(t.search(12));
      System.out.println("Expected:  12");
      System.out.println(t.search(13));
      System.out.println("Expected:  14");
      System.out.println(t.search(14));
      System.out.println("Expected:  14");
      System.out.println(t.search(15));
      System.out.println("Expected:  14");
      System.out.println(t.search(16));
      System.out.println("Expected:  8 16");
      System.out.println(t.search(17));
      System.out.println("Expected:  18");
      System.out.println(t.search(18));
      System.out.println("Expected:  18");
      System.out.println(t.search(19));
      System.out.println("Expected:  18");
      System.out.println(t.search(20));
      System.out.println("Expected:  20 24");
      System.out.println(t.search(21));
      System.out.println("Expected:  22");
      System.out.println(t.search(22));
      System.out.println("Expected:  22");
      System.out.println(t.search(23));
      System.out.println("Expected:  22");
      System.out.println(t.search(24));
      System.out.println("Expected:  20 24");
      System.out.println(t.search(25));
      System.out.println("Expected:  26 28");
      System.out.println(t.search(26));
      System.out.println("Expected:  26 28");
      System.out.println(t.search(27));
      System.out.println("Expected:  26 28");
      System.out.println(t.search(28));
      System.out.println("Expected:  26 28");
      System.out.println(t.search(29));
      System.out.println("Expected:  26 28");
   }

   public static void testDecreasing()
   {
      TwoThreeTree t = new TwoThreeTree();
      for(int i = -1; i > -15; i--)
         t.insert(i*2);
      System.out.println(t.search(-1));
      System.out.println("Expected:  -2");
      System.out.println(t.search(-2));
      System.out.println("Expected:  -2");
      System.out.println(t.search(-3));
      System.out.println("Expected:  -2");
      System.out.println(t.search(-4));
      System.out.println("Expected:  -4");
      System.out.println(t.search(-5));
      System.out.println("Expected:  -6");
      System.out.println(t.search(-6));
      System.out.println("Expected:  -6");
      System.out.println(t.search(-7));
      System.out.println("Expected:  -6");
      System.out.println(t.search(-8));
      System.out.println("Expected:  -16 -8");
      System.out.println(t.search(-9));
      System.out.println("Expected:  -10");
      System.out.println(t.search(-10));
      System.out.println("Expected:  -10");
      System.out.println(t.search(-11));
      System.out.println("Expected:  -10");
      System.out.println(t.search(-12));
      System.out.println("Expected:  -12");
      System.out.println(t.search(-13));
      System.out.println("Expected:  -14");
      System.out.println(t.search(-14));
      System.out.println("Expected:  -14");
      System.out.println(t.search(-15));
      System.out.println("Expected:  -14");
      System.out.println(t.search(-16));
      System.out.println("Expected:  -16 -8");
      System.out.println(t.search(-17));
      System.out.println("Expected:  -18");
      System.out.println(t.search(-18));
      System.out.println("Expected:  -18");
      System.out.println(t.search(-19));
      System.out.println("Expected:  -18");
      System.out.println(t.search(-20));
      System.out.println("Expected:  -24 -20");
      System.out.println(t.search(-21));
      System.out.println("Expected:  -22");
      System.out.println(t.search(-22));
      System.out.println("Expected:  -22");
      System.out.println(t.search(-23));
      System.out.println("Expected:  -22");
      System.out.println(t.search(-24));
      System.out.println("Expected:  -24 -20");
      System.out.println(t.search(-25));
      System.out.println("Expected:  -28 -26");
      System.out.println(t.search(-26));
      System.out.println("Expected:  -28 -26");
      System.out.println(t.search(-27));
      System.out.println("Expected:  -28 -26");
      System.out.println(t.search(-28));
      System.out.println("Expected:  -28 -26");
      System.out.println(t.search(-29));
      System.out.println("Expected:  -28 -26");
   }
}