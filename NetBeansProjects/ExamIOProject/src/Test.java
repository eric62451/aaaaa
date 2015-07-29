
import java.util.*;

public class Test
{
  public static void main(String[] args)
  {
     String[] a1 = new String[0];
     String[] a2 = {""};
     String[] a3 = new String[3];
     a3[0] = "SJSU";
     a3[1] = "";
     a3[2] = null;
     String[] a4 = null;

     System.out.println("length: " + a1.length);
     System.out.println( Arrays.toString(a1) + "\n");
     System.out.println("length: " + a2.length);
     System.out.println(Arrays.toString(a2) );
     System.out.println("string length: " + a2[0].length()+ "\n");
     System.out.println("length: " + a3.length);
     System.out.println(Arrays.toString(a3) + "\n");
     //System.out.println("string length: " + a3[2].length());
     //System.out.println("length: " + a4.length);
     System.out.println(Arrays.toString(a4) + "\n");
  }
}