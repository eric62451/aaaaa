
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jeffrey Su
 */
public class ButtonTester
{

    public static void main(String[] args)
    {
        final CircleswButtons circ = new CircleswButtons(30, Color.RED);

        JFrame frame = new JFrame();
        final JLabel lab = new JLabel((Icon) circ);

        JButton Blue = new JButton("Blue");

        Blue.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                circ.setColor(Color.BLUE);
                lab.repaint();

            }
        });

        JButton Green = new JButton("Green");

        Green.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                circ.setColor(Color.GREEN);
                lab.repaint();
            }
        });

        JButton Red = new JButton("Red");

        Red.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                circ.setColor(Color.RED);
                lab.repaint();

            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(Red);
        frame.add(Green);
        frame.add(Blue);
        frame.add(lab);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
