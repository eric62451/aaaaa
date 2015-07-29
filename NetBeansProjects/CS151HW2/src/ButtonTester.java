
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class ButtonTester {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        final ColoredCircle icon = new ColoredCircle();
        final JLabel label = new JLabel(icon);

        JButton rButton = new JButton("Red");

        rButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                icon.changeColor(Color.RED);
                label.repaint();

            }
        });

        JButton bButton = new JButton("Blue");

        bButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                icon.changeColor(Color.BLUE);
                label.repaint();
            }
        });

        JButton gButton = new JButton("Green");

        gButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                icon.changeColor(Color.GREEN);
                label.repaint();
            }
        });

      frame.setLayout(new FlowLayout());

      frame.add(gButton);
      frame.add(rButton);
      frame.add(bButton);
      frame.add(label);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
    }
}
