import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CalendarView {
	private CalendarModel cm;
	private CalendarControls cc;
	private ScheduleModel sm;
	private JPanel panel;
	private JPanel calendarHeader;
	private JPanel calendarPanel;
	private JButton month;
	private JButton[] days;
	private final int NUM_ROWS = 6;
	private final int NUM_COLS = 7;
	
	public CalendarView(ScheduleModel sm, CalendarModel cm, AgendaView av) {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		this.sm = sm;
		this.cm = cm;
		cc = new CalendarControls(cm, this, av, sm);
		
		days = new JButton[NUM_COLS * NUM_ROWS];
		for(int i = 0; i < days.length; i++) {
			days[i] = button("");
		}
	}
	
	public CalendarModel getCalendarModel() {
		return cm;
	}
	
	public JPanel getHeader() {
		calendarHeader = new JPanel();
		calendarHeader.setLayout(new BorderLayout());
        month = new JButton(cm.getMonthName() + " " + cm.getYear());
        month.setEnabled(false);
        JButton prevBtn = new JButton("<<");
		JButton nextBtn = new JButton(">>");
		JButton create = new JButton("Create");

        prevBtn.addActionListener(cc.changeMonth(-1));
        nextBtn.addActionListener(cc.changeMonth(1));
        create.addActionListener(cc.create());
        
        final JPanel dates = new JPanel();
        dates.setLayout(new GridLayout(1, 7));
        JButton[] dayNames = new JButton[7];
        String[] days = new String[]{"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
        for(int i = 0; i < dayNames.length; i++) {
        	dayNames[i] = new JButton(days[i]);
        	dayNames[i].setEnabled(false);
        	dates.add(dayNames[i]);
        }
        
        calendarHeader.add(month, BorderLayout.NORTH);
        calendarHeader.add(prevBtn, BorderLayout.LINE_START);
        calendarHeader.add(create, BorderLayout.CENTER);
        calendarHeader.add(nextBtn, BorderLayout.LINE_END);
        calendarHeader.add(dates, BorderLayout.SOUTH);
		return calendarHeader;
	}
	
	public JPanel getDays() {
		calendarPanel = new JPanel();
		calendarPanel.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
		int dayNumber = 1;
		for(int i = cm.getStartDay()-1; i < cm.getStartDay() + cm.getNumDays()-1; i++) {
			days[i] = this.button(dayNumber + "");
			days[i].addActionListener(cc.getDay(days[i].getText()));
			if(dayNumber <= cm.getNumDays())
			dayNumber++;
		}
		
		for(JButton d: days) { 
			calendarPanel.add(d);
		}
		
		return calendarPanel;
	}
	
	public JPanel getCalendarPanel() {
		panel.add(getHeader(), BorderLayout.NORTH);
		panel.add(getDays(), BorderLayout.CENTER);
		return panel;
	}
	
	public void update() {
		month.setText(cm.getMonthName() + " " + cm.getYear());
		int dayNumber = 1;
		for(int i = 0; i < cm.getStartDay(); i++) {
			days[i].setText("");
		    for( ActionListener al : days[i].getActionListeners() ) {
		    	days[i].removeActionListener( al );
		    }
			days[i].addActionListener(cc.getDay(days[i].getText()));
		}
		for(int i = cm.getStartDay()-1; i < cm.getStartDay() + cm.getNumDays()-1; i++) {
			days[i].setText(dayNumber + "");
		    for( ActionListener al : days[i].getActionListeners() ) {
		    	days[i].removeActionListener( al );
		    }
			days[i].addActionListener(cc.getDay(days[i].getText()));
			dayNumber++;
		}
		for(int i = cm.getStartDay() + cm.getNumDays()-1; i < days.length; i++) {
			days[i].setText("");
		    for( ActionListener al : days[i].getActionListeners() ) {
		    	days[i].removeActionListener( al );
		    }
			days[i].addActionListener(cc.getDay(days[i].getText()));
		}
	}
	
    public JButton button(String num)
    {
        final JButton bigBooty = new JButton(num);

        bigBooty.setFocusPainted(false);
        bigBooty.setBackground(Color.white);
        bigBooty.setBorder(null);
        bigBooty.setFocusable(false);
        bigBooty.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                bigBooty.setBackground(Color.pink);
                bigBooty.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        //go to day view       
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                bigBooty.setBackground(Color.lightGray);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                bigBooty.setBackground(Color.white);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                bigBooty.setBackground(Color.lightGray);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                bigBooty.setBackground(Color.white);
            }
        });
        
        return bigBooty;
    }
}
