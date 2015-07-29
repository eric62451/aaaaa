/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class CircleTester {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.setRadius(10);
        System.out.println(circle.getRadius());
        System.out.println("Expected: 10.0");
        System.out.println(circle.getArea());
        System.out.println("Expected: 314.1592653589793");
    }
}
