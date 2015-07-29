/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class CircleTester
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(10.1);
        Circle c2 = new Circle(25.7);
        Circle c3 = new Circle(10.1);
        System.out.println(c1.compareTo(c2));
        System.out.println("Expected: -1");
        System.out.println(c1.compareTo(c3));
        System.out.println("Expected: 0");
        System.out.println(c2.compareTo(c1));
        System.out.println("Expected: 1");
    }
}