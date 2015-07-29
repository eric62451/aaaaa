import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class Homework5CTester
{

   public static void main(String[] args)
   {
      Point[] points =
      {
         new Point(3, 4),
         new Point(0, 6),
         new Point(4, 0),
         new Point(2, 2)
      };

      class PointComparator implements Comparator
      {

         public int compare(Object o1, Object o2)
         {
            Point c1 = (Point) o1;
            Point c2 = (Point) o2;

            if (((c1.getX()*c1.getX())+(c1.getY()*c1.getY())) < ((c2.getX()*c2.getX())+(c2.getY()*c2.getY())))
            {
               return -1;
            } else if (((c1.getX()*c1.getX())+(c1.getY()*c1.getY())) > ((c2.getX()*c2.getX())+(c2.getY()*c2.getY())))
            {
               return 1;
            } else
            {
               return 0;
            }
         }
      }


SelectionSorterWithComparator sorter = new SelectionSorterWithComparator(points,new PointComparator());
sorter.sort();

      System.out.println(Arrays.toString(points));
      System.out.println("Expected: [java.awt.Point[x=2,y=2], java.awt.Point[x=4,y=0], java.awt.Point[x=3,y=4], java.awt.Point[x=0,y=6]]");

   }
}
