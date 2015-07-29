import java.awt.Rectangle;

public class Homework1CTester
{
    public static void main(String[] args)
    {
        Rectangle[] list = {new Rectangle(0,0, 100, 30),
                            new Rectangle(0,0, 20, 30),
                            new Rectangle(0,0, 100, 20),
                            new Rectangle(0,0, 50, 50),
                            new Rectangle(0,0, 10, 30)};

        RectangleComparatorByArea comparator = new RectangleComparatorByArea();
        Object largest = Util.largest(list, comparator);
        System.out.println(largest.toString());
        System.out.println("Expected java.awt.Rectangle[x=0,y=0,width=100,height=30]");
    }
}