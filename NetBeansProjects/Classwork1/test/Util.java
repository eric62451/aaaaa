/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Util
{
   public static Comparable smallest(Comparable[] values)
   {
      Comparable smallestSoFar = values[0];
      for (int i = 1; i < values.length; i++)
         if (values[i].compareTo(smallestSoFar) < 0)
            smallestSoFar = values[i];
      return smallestSoFar;
   }
}