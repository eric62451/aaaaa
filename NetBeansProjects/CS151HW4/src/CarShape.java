
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.4
 */
public class CarShape extends JPanel {

    /**
    Constructs a car shape.
    @param x the left of the bounding rectangle
    @param y the top of the bounding rectangle
    @param width the width of the bounding rectangle
     */
    public CarShape() {
        this.x = 0;
        this.y = 0;
        this.width = 150;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double body = new Rectangle2D.Double(x, y + width / 6,
                width - 1, width / 6);
        Ellipse2D.Double frontTire = new Ellipse2D.Double(x + width / 6, y + width / 3,
                width / 6, width / 6);
        Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3,
                y + width / 3,
                width / 6, width / 6);

        // The bottom of the front windshield
        Point2D.Double r1 = new Point2D.Double(x + width / 6, y + width / 6);
        // The front of the roof
        Point2D.Double r2 = new Point2D.Double(x + width / 3, y);
        // The rear of the roof
        Point2D.Double r3 = new Point2D.Double(x + width * 2 / 3, y);
        // The bottom of the rear windshield
        Point2D.Double r4 = new Point2D.Double(x + width * 5 / 6, y + width / 6);
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);

        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }

    public boolean contains(Point2D p) {
        return x <= p.getX() && p.getX() <= x + width
                && y <= p.getY() && p.getY() <= y + width / 2;
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void resize(int newWidth) {
        width = newWidth;
    }
    private int x;
    private int y;
    private int width;
}
