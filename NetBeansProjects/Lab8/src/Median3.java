import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Median3
{
   public static void main(String[] args)
   {
      int n = Integer.parseInt(args[0]);
      List<Double> lst = new ArrayList<Double>(n);
      for (int i = 1; i <= n; i++) lst.add(Math.random());
      System.out.println("Median: " + median(lst));
   }

   public static double median(List<Double> lst)
   {
      return select(lst, lst.size() / 2, 0, lst.size() - 1);
   }

   public static double select(List<Double> lst, int k, int from, int to)
   {
      if (...) // Base case of recursion
      {
	 return ...;
      }

      int p = partition(lst, from, to);
      int leftSize = p - from + 1;
      if (...)
	 return select(...);
      else
	 return select(...);
   }

   private static int partition(List<Double> lst, int from, int to)
   {
      double pivot = a.get(from);
      int i = from - 1;
      int j = to + 1;
      while (i < j)
      {
	 i++; while (a.get(i) < pivot) i++;
	 j--; while (a.get(j) > pivot) j--;
	 if (i < j)
	 {
	    // swap elements at i, j
	    Double temp = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, temp);
	 }
      }
      return j;
   }
}