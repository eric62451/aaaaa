/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class Circle implements Comparable{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return (radius * radius * Math.PI);
    }

    public int compareTo(Object otherCircle) {
       Circle other = (Circle) otherCircle;
       if(radius>other.getRadius()) return 1;
       if(radius<other.getRadius()) return -1;
       return 0;
    }

}
