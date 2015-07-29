
import java.awt.geom.Ellipse2D;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 5
 */
public class SnowMan extends CompositeShape {

    public SnowMan(int x, int y, int width){
        super(x,y);
        Ellipse2D.Double top = new Ellipse2D.Double(x, y, width, width);
        Ellipse2D.Double bot = new Ellipse2D.Double(x, y+width, width, width);
        add(bot);
        add(top);
    }



}
