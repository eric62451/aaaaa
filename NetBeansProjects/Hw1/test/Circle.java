/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Circle implements Comparable
{

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

    public double getArea(){
        return (radius*radius*Math.PI);
    }

    public int compareTo(Object otherCircle) {
        Circle other = (Circle) otherCircle;
       if(radius>other.getRadius()) return 1;
       if(radius<other.getRadius()) return -1;
       return 0;
    }

    @Override
    public String toString(){
        return "Circle[r="+radius+"]";
    }

    public boolean equals(Circle comp){
        if(radius==comp.radius) return true;
        return false;
    }

}
