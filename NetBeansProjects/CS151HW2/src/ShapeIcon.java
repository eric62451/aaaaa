import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   An icon that contains a moveable shape.
*/
public class ShapeIcon implements Icon
{
    private ArrayList<MoveableShape> a;
   public ShapeIcon(ArrayList<MoveableShape> shape,
      int width, int height)
   {
      a = shape;
      this.width = width*shape.size();
      this.height = height*shape.size();
   }

   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for(MoveableShape i : a){
        i.draw(g2);
      }
   }

   private int width;
   private int height;
   private MoveableShape shape;
}


