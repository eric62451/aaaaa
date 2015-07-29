import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

/**
 * An application to dtermine is a point is a specified distance from the origin
 *
 * @author Kathleen O'Brien
 */
public class Homework6BTester
{

    public static void main(String[] args)
    {
        Point[] points = {
      };

      //Comparator to determine which point is closer to the origin
      class DistanceComparator implements Comparator
      {
         public int compare(Object o1, Object o2)
         {
            Point p1 = (Point) o1;
            Point p2 = (Point) o2;
            double d1 = Math.pow(p1.getX(), 2) + Math.pow(p1.getY(), 2);
            double d2 = Math.pow(p2.getX(), 2) + Math.pow(p2.getY(), 2);
            return (int) (d1 - d2);
         }
      }
Arrays.sort(points, new DistanceComparator());
      BinarySearcherWithComparator searcher =
              new BinarySearcherWithComparator(points, new DistanceComparator());

      //we want to know if any of the points are 5 from the origin. Create an Point
      //that is 5 from the origin to use as target.
      //The easiest one to make is the one at (0, 5)
      Object target = new Point(0, 5);
      int index = searcher.search(target );
      printResults(index, target);
      System.out.println("Expected: Point a distance of 5.0 is in the array at index 2");

      //now see idf there is a point 7 from origin
      target = new Point(0, 7);
      index = searcher.search(target );
      printResults(index, target);
      System.out.println("Expected: Point a distance of 7.0 is NOT in the array");

    }

    static void printResults(int index, Object target)
    {
       Point p1 = (Point)target;
       double distanceToOrigin = Math.sqrt(Math.pow(p1.getX(), 2)
                + Math.pow(p1.getY(), 2));

       System.out.print("Point a distance of " + distanceToOrigin + " is ");
       if (index >=0)
       {
          System.out.println("in the array at index " + index);
       }
       else
       {
          System.out.println("NOT in the array");
       }
    }

}