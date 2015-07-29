
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.2
 */
public class BarFrame extends JFrame implements ChangeListener {

    /**
    Constructs a BarFrame object
    @param dataModel the data that is displayed in the barchart
     */
    public BarFrame(final DataModel dataModel) {
        this.dataModel = dataModel;
        a = dataModel.getData();

        setLocation(0, 200);
        setLayout(new BorderLayout());

        final Icon barIcon = new Icon() {

            public int getIconWidth() {
                return ICON_WIDTH;
            }

            public int getIconHeight() {
                return ICON_HEIGHT;
            }

            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(Color.red);

                double max = (a.get(0)).doubleValue();
                for (Double v : a) {
                    double val = v.doubleValue();
                    if (val > max) {
                        max = val;
                    }
                }

                double barHeight = getIconHeight() / a.size();

                int i = 0;
                for (Double v : a) {
                    double value = v.doubleValue();

                    double barLength = getIconWidth() * value / max;

                    Rectangle2D.Double rectangle = new Rectangle2D.Double(0, barHeight * i, barLength, barHeight);
                    i++;
                    g2.fill(rectangle);
                }
            }
        };

        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent event) {
                int y = event.getY()-30;
                int barHeight = barIcon.getIconHeight() / a.size();
                int whichBar = y / (barIcon.getIconHeight() / a.size());
                if (y % (barIcon.getIconHeight() / a.size()) != 0) {
                    whichBar++;
                }
                double max = (a.get(0)).doubleValue();
                for (Double v : a) {
                    double val = v.doubleValue();
                    if (val > max) {
                        max = val;
                    }
                }
                int x = event.getX()-8;
                double percent = (double)x/(barIcon.getIconWidth()-1);
                //System.out.println(percent*max +" "+ percent);
                dataModel.update(whichBar-1, percent * max);
                //System.out.println(event.getX() +" "+event.getY());
            }
        });

        add(new JLabel(barIcon));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
    Called when the data in the model is changed.
    @param e the event representing the change
     */
    public void stateChanged(ChangeEvent e) {
        a = dataModel.getData();
        repaint();
    }
    private ArrayList<Double> a;
    private final DataModel dataModel;
    private static final int ICON_WIDTH = 200;
    private static final int ICON_HEIGHT = 200;
}
