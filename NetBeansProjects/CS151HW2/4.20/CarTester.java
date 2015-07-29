import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class CarTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      final ArrayList<MoveableShape> a = new ArrayList<MoveableShape>();
      a.add(new CarShape(0, 0, CAR_WIDTH));
      a.add(new CarShape(5, 50, CAR_WIDTH));
      a.add(new CarShape(50, 100, CAR_WIDTH));
      final MoveableShape shape
            = new CarShape(0, 0, CAR_WIDTH);

      ShapeIcon icon = new ShapeIcon(a,
            ICON_WIDTH, ICON_HEIGHT);

      final JLabel label = new JLabel(icon);
      frame.setLayout(new FlowLayout());
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               for(MoveableShape i : a){
                   i.translate(1, 0);
               }
               label.repaint();
            }
         });
      t.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
