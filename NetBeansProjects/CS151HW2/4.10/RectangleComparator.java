
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class RectangleComparator implements Comparator<Rectangle2D.Double>{

    public int compare(Double o1, Double o2) {
        if(o1.x > o2.x) return 1;
        if(o1.x < o2.x) return -1;
        if(o1.y > o2.y) return 1;
        if(o1.y < o2.y) return -1;
        if(o1.width > o2.width) return 1;
        if(o1.width < o2.width) return -1;
        if(o1.height > o2.height) return 1;
        if(o1.height > o2.height) return -1;
        return 0;
    }


}
