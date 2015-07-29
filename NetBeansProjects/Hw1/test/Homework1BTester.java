import java.awt.Rectangle;

public class Homework1BTester
{
    public static void main(String[] args)
    {
        Rectangle rec1 = new Rectangle(0,0, 100, 30);
        Rectangle rec2 = new Rectangle(0,0, 200, 10);
        Rectangle rec3 = new Rectangle(0,0, 15, 200);


        RectangleComparatorByArea comparator = new RectangleComparatorByArea();
        System.out.println ( comparator.compare(rec1, rec2));
        System.out.println("Expected: 1");
        System.out.println ( comparator.compare(rec2, rec1));
        System.out.println("Expected: -1");
        System.out.println ( comparator.compare(rec1, rec3));
        System.out.println("Expected: 0");
    }
}