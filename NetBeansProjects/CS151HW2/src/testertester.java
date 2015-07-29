import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jeffrey Su
 */
public class testertester
{

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 400;
    private static final int CLOCK_WIDTH = 100;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        ClockIcon icon = new ClockIcon();
        final JLabel lab = new JLabel((Icon) icon);
        frame.setLayout(new FlowLayout());
        frame.add(lab);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        final int DELAY = 10;



    }
}