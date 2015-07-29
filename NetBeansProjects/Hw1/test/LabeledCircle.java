

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class LabeledCircle extends Circle {

    private double radii;
    private String color;

    public LabeledCircle(int radius, String color) {
        super(radius);
        radii = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Labeled"+super.toString() + "[Label=" + color.toString() + "]";
    }

    public boolean equals(LabeledCircle lCircle) {
        if (radii == lCircle.getRadius() && color.equalsIgnoreCase(lCircle.color)) {
            return true;
        }
        return false;
    }
}
