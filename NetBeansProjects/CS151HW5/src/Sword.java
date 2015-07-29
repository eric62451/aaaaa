
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 5
 */
public class Sword extends CompositeShape {

    public Sword(int x, int y, int width){
        super(x,y);
        Line2D.Double leftTip = new Line2D.Double((width-x)/2.0, (double) y, (width-x)/4.0, width-y/2.0);
        Line2D.Double rightTip = new Line2D.Double((width-x)/2.0, (double) y, ((width-x)/4.0)*3, width-y/4.0);
        Line2D.Double leftBody = new Line2D.Double((width-x)/4.0, (width-y/2.0), (width-x)/4.0, (width-y/2.0)+width);
        Line2D.Double rightBody = new Line2D.Double(((width-x)/4.0)*3, (width-y/4.0), ((width-x)/4.0)*3, (width-y/2.0)+width);
        Rectangle2D.Double base = new Rectangle2D.Double(x+(width/8), (width-y/2.0)+width, (width/4)*3, width/4);
        Rectangle2D.Double handle = new Rectangle2D.Double((double)((width-x)/2.0)-width/8,((width-y/2.0)+width)+width/4,(double)width/4,(double)width/4);
        add(leftTip);
        add(rightTip);
        add(rightBody);
        add(leftBody);
        add(base);
        add(handle);
    }



}
