import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Calendar {
	public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        CalendarModel cm = new CalendarModel();
        ScheduleModel sm = new ScheduleModel();
        final AgendaView av = new AgendaView(sm, cm);
        final CalendarView cv = new CalendarView(sm, cm, av); 
        
        frame.add(cv.getCalendarPanel());
        frame.add(av.getAgendaPanel());
        
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
