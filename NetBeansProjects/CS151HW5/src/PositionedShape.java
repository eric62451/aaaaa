
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 5
 */
public class PositionedShape {

    private Point2D coor;
    private CompositeShape shape;

    public PositionedShape(Point2D a, CompositeShape b) {
        coor = a;
        shape = b;
    }

    public void draw(Graphics2D g2) {
        AffineTransform transform = g2.getTransform();
        g2.translate(coor.getX(), coor.getY());
        this.shape.draw(g2);
        g2.setTransform(transform);
    }
}
