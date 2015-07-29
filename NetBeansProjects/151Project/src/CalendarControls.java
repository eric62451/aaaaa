import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalendarControls {
	private CalendarModel cm;
	private CalendarView cv;
	private ScheduleModel sm;
	private AgendaView av;
	public CalendarControls(CalendarModel cm, CalendarView cv, AgendaView av, ScheduleModel sm) {
		this.cm = cm;
		this.cv = cv;
		this.sm = sm;
		this.av = av;
	}
	
	public ActionListener changeMonth(final int changeMonth) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cm.getGC().set(2, cm.getGC().get(2) + changeMonth);
				cv.update();
			}
		};
	}
	
	public ActionListener getDay(final String day) {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!day.equals("")) {
					int dayNum = Integer.parseInt(day);
					cm.setDay(dayNum);
					av.setText(sm.getDayEvents(cm.getYear(), cm.getMonth(), cm.getDay()));
				}
			}
		};
	}
	
	public ActionListener create() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                JFrame frame = new JFrame();
                final JTextField eventName;
                final JTextField descript;
                final JTextField eventDate;
                final JTextField startTime;
                final JTextField endTime;

                frame.setTitle("Create an Event");
                final JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(7, 2));

                panel.add(new JLabel("Event Name: "));
                eventName = new JTextField(15);
                panel.add(eventName);

                panel.add(new JLabel("Event Description: "));
                descript = new JTextField(30);
                panel.add(descript);

                panel.add(new JLabel("Event Date (MM/DD/YYYY):  "));
                eventDate = new JTextField(10);
                panel.add(eventDate);

                panel.add(new JLabel("Start Time (0-23 hours): "));
                startTime = new JTextField(5);
                panel.add(startTime);

                panel.add(new JLabel("End Time: "));
                endTime = new JTextField(5);
                panel.add(endTime);

                panel.add(new JLabel());
                JButton doneBtn = new JButton("Create Event");
                doneBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String[] date = eventDate.getText().split("/");
						EventModel newEvent = new EventModel(descript.getText(), Integer.parseInt(date[1]), Integer.parseInt(date[0]), Integer.parseInt(date[2]), Integer.parseInt(startTime.getText()), endTime.getText());
						boolean success = sm.add(newEvent);
						//check for time conflicts
						if(success) {
							//rewrite old frame with success message
							System.out.println("new event added\n\tupdate line98 in CalendarControls.java later");
						} else {
							//If there is any time conflict, ask the user to enter the event again with a correct time.
							System.out.println("these is a time conflict\n\tupdate line101 in CalendarControls.java later");
						}
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
}
