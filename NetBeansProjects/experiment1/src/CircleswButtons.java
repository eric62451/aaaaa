
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;

/**
 *
 * @author Jeffrey Su
 */
public class CircleswButtons implements Icon
{

    private int sizeofbutton;
    private Color color;

    public CircleswButtons(int size, Color col)
    {
        sizeofbutton = size;
        color = col;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circ = new Ellipse2D.Double(x, y, sizeofbutton, sizeofbutton);

        g2.setColor(color);
        g2.fill(circ);
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color col)
    {
        color = col;
    }

    @Override
    public int getIconWidth()
    {
        return sizeofbutton;
    }

    @Override
    public int getIconHeight()
    {
        return sizeofbutton;
    }
}
