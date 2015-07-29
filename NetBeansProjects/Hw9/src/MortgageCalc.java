import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.text.BadLocationException;

public class MortgageCalc {


    public static void main(String[] args) throws BadLocationException {
        final JFrame frame = new JFrame("Calendar");
        final JFrame frame2 = new JFrame("Create Event");
        frame.setSize(365,291);
        frame2.setSize(410,100);

       
        JButton calculate = new JButton("Calculate");
        JButton clear = new JButton("Clear");
        JButton cancel = new JButton("Cancel");
        JButton ok = new JButton("Ok");
        ok.setBounds(225, 50, 50, 50);
        

        final JTextField propertyValue = new JTextField(10);
        final JTextField interest = new JTextField(10);
        final JTextField duration = new JTextField(10);
        final JTextField downPayment = new JTextField(10);
        final JTextField monthlyPayment = new JTextField(10);

        JPanel infoPanel = new JPanel();
        JPanel answerPanel = new JPanel(new FlowLayout());
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

        final JCheckBox box = new JCheckBox("Include Property Tax");

        infoPanel.setSize(350, 150);
        infoPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Mortgage Information"));
        infoPanel.add(new JLabel("Enter property value ($):                           "));
        infoPanel.add(propertyValue);
        infoPanel.add(new JLabel("Enter annual interest rate (in %):            "));
        infoPanel.add(interest);
        infoPanel.add(new JLabel("Enter loan duration (in years):                "));
        infoPanel.add(duration);
        infoPanel.add(new JLabel("Enter down payment (in %):                     "));
        infoPanel.add(downPayment);
        infoPanel.add(box);

        infoPanel.setAlignmentY(infoPanel.RIGHT_ALIGNMENT)
        frame.add(infoPanel,BorderLayout.NORTH);

        answerPanel.setSize(350,500);
        answerPanel.setBounds(0, 155 , 350, 60);
        answerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "Mortgage Calculation Results"));
        answerPanel.add(new JLabel("Monthly Mortgage Payment ($):             "));
        answerPanel.add(monthlyPayment);

        frame.add(answerPanel,BorderLayout.WEST);

        buttons.setBounds(0,213,350,60);
        buttons.add(calculate);
        buttons.add(clear);
        buttons.add(cancel);
        
        frame.add(buttons,BorderLayout.SOUTH);

        frame2.add(new JLabel("Thanks for using our Mortgage Calculator application. See you again"), BorderLayout.NORTH);
        frame2.add(ok, BorderLayout.CENTER);



        calculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
            double value = Double.parseDouble(propertyValue.getText());
            double percent = Double.parseDouble(interest.getText());
            double years = Double.parseDouble(duration.getText());
            double down = Double.parseDouble(downPayment.getText());
            boolean tax = box.isSelected();

            double loan = value - ((value/100)*down);
            double inte = (percent/12)/100;
            double n = years*12;
            double top = (inte*Math.pow(1+inte, n));
            double bot = ((Math.pow(1+inte,n)-1));
            double monthlyTax = value*(1.5/1200);

            double multiply = top/bot;
            
            if(!tax)monthlyPayment.setText(""+ String.format( "%.2f", loan * multiply));
            else monthlyPayment.setText(""+ String.format( "%.2f", ((loan * multiply)+monthlyTax)));

            }
        });
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
            propertyValue.setText("");
            interest.setText("");
            duration.setText("");
            downPayment.setText("");
            monthlyPayment.setText("");
            box.setSelected(false);

            }
        });
        
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                frame2.setVisible(true);
                frame.dispose();


            }
        });

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                frame2.dispose();
                System.exit(0);


            }
        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                frame.dispose();
                frame2.setVisible(true);
            }
        });


        frame.setLayout(new BorderLayout());
        


        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame2.setVisible(false);
        frame2.setLocationRelativeTo(null);


    }

}
