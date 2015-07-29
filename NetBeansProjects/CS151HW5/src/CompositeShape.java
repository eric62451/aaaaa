
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import sun.java2d.pipe.ShapeSpanIterator;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 5
 */
public class CompositeShape implements CompositeShapeInt {

    ArrayList<Shape> array = new ArrayList<Shape>();
    int x, y;

    public CompositeShape(int a, int b) {
        x = a;
        y = b;
    }

    public void add(Shape aShape) {
        array.add(aShape);
    }

    public Rectangle getBounds() {
        if (array.size() != 0) {
            int initialX, initialY, height, width;
            initialX = (int)array.get(0).getBounds().getX();
            initialY = (int)array.get(0).getBounds().getY();
            height = (int)array.get(0).getBounds().getMaxY();
            width = (int)array.get(0).getBounds().getMaxX();
            for (Shape i : array) {
                Rectangle a = i.getBounds();
                if(a.getX()<initialX) initialX = (int)a.getX();
                if(a.getY()<initialY) initialY = (int)a.getY();
                if(a.getMaxX()>width) width = (int)a.getMaxX();
                if(a.getMaxY()>height) height = (int)a.getMaxY();
            }
            return new Rectangle(initialX, initialY, width,height);
        }
        return new Rectangle();
    }

    public void draw(Graphics2D g) {
        for (Shape i : array) {
            g.draw(i);
        }
    }

    public ArrayList<Shape> shape(){
        return (ArrayList)array.clone();
    }
}
