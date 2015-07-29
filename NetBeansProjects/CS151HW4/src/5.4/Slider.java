
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.4
 */
public class Slider {

    private CarShape car;
    private JFrame frame;

    public Slider() {
        car = new CarShape();
        frame = new JFrame();
        final JSlider slide = new JSlider(SwingConstants.HORIZONTAL, 0, 300, 150);
        slide.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                car.resize(slide.getValue());
                frame.repaint();
            }
        });
        frame.add(slide, BorderLayout.NORTH);
        frame.add(car, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setVisible(true);
    }
}
