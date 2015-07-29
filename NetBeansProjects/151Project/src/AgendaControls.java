import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AgendaControls {
	private AgendaView av;
	private CalendarModel cm;
	private ScheduleModel sm;
	public AgendaControls(AgendaView av, CalendarModel cm, ScheduleModel sm) {
		this.av = av;
		this.cm = cm;
		this.sm = sm;
	}
	
	public ActionListener day() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				av.setText(sm.getDayEvents(cm.getYear(), cm.getMonth(), cm.getDay()));
			}
		};
	}
	
	public ActionListener week() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				av.setText("week");
			}
		};
	}

	public ActionListener month() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				av.setText("month");
			}
		};
	}
	
	public ActionListener agenda() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                JFrame frame = new JFrame();
                final JTextField startDate;
                final JTextField endDate;
                frame.setTitle("Search Agenda");
                final JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 5));
                panel.add(new JLabel("Date Range (MM/DD/YYYY):  "));
                startDate = new JTextField(10);
                panel.add(startDate);
                panel.add(new JLabel(" - "));
                endDate = new JTextField(10);
                panel.add(endDate);
                panel.add(new JLabel());
                JButton doneBtn = new JButton("Search");
                doneBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String[] startdate = startDate.getText().split("/");
                        String[] enddate = endDate.getText().split("/");                                              
						av.setText(sm.getString(Integer.parseInt(startdate[2]),Integer.parseInt(startdate[0]),Integer.parseInt(startdate[1]),
												Integer.parseInt(enddate[2]),Integer.parseInt(enddate[0]),Integer.parseInt(enddate[1])));
						//check for time conflicts
						
					}
				});
                panel.add(doneBtn);
                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        };
	}

	public ActionListener file() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				av.setText("from file");
			}
		};
	}
}
