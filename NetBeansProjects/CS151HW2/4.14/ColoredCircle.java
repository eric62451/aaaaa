
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class ColoredCircle implements Icon {

    private int size = 100;
    private Color a = Color.RED;

    public ColoredCircle() {
    }

    public void changeColor(Color b) {
        a = b;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double icon = new Ellipse2D.Double(x, y,
                size, size);
        g2.setColor(a);
        g2.fill(icon);
    }

    public int getIconWidth() {
        return size;
    }

    public int getIconHeight() {
        return size;
    }
}
