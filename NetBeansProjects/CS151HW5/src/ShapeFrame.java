
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 5
 */
public class ShapeFrame extends JFrame {

    ShapePanel panel = new ShapePanel();
    private Box bpanel = Box.createHorizontalBox();

    public ShapeFrame() {
        add(panel, "Center");
        add(bpanel, "North");
    }

    public void addShape(final CompositeShape a) {
        JButton button = new JButton(new ShapeIcon(a, 50, 50));
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                panel.set(a);
            }
        });
        bpanel.add(button);
    }

    class ShapePanel extends JPanel {

        CompositeShape shape;
        ArrayList<PositionedShape> array = new ArrayList<PositionedShape>();

        public ShapePanel() {
            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    if (shape == null) {
                        return;
                    }
                    array.add(new PositionedShape(e.getPoint(), shape));
                    repaint();
                }
            });

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (PositionedShape i : array) {
                i.draw(g2);
            }
        }

        public void set(CompositeShape a) {
            shape = a;
        }
    }
}
