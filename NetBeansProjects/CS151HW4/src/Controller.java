
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * MVC
 */
public class Controller {
    private JButton add;
    private Model data;
    private JTextField text;
    private Viewer frame;

    public Controller(final Model data){
        frame = new Viewer(data);
        data.attach(frame);
        text = new JTextField();
        add = new JButton("Add");
        this.data = data;
        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String Str = text.getText();
                data.add(Str);
            }
        });
        frame.add(add, BorderLayout.NORTH);
        frame.add(text,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
