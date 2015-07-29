
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * MVC
 */
public class Viewer extends JFrame implements ChangeListener{
    private JTextArea textArea = new JTextArea(10,20);
    private Model data;
    public Viewer(Model data){
        this.data = data;
        setSize(200,300);
        textArea.setEditable(false);
        setLayout(new BorderLayout());
        add(textArea,BorderLayout.CENTER);
    }
    public void stateChanged(ChangeEvent e) {
        String str = "";
        for(String i : data.getData()){
            str = str+i+"\n";
        }
        textArea.setText(str);
    }
}
