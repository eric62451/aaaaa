
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

/**
 *
 * @author Jay
 */
public class DrawableCar implements Icon {

    private final double width;

    public DrawableCar(double w) {
        width = w;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g2.draw(new Rectangle2D.Double(width, width, width, width));
    }

    @Override
    public int getIconWidth() {
        return (int)width;
    }

    @Override
    public int getIconHeight() {
        return (int)width;
    }
}
