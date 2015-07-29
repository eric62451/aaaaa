import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;


public class AgendaView {
	private JPanel panel;
	private JTextArea text;
	private AgendaControls ac;
	private ScheduleModel sm;
	private CalendarModel cm;
	
	public AgendaView(ScheduleModel sm, CalendarModel cm) {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		ac = new AgendaControls(this, cm, sm);
		this.sm = sm;
		this.cm = cm;
	}
	
	public ScheduleModel getScheduleModel() {
		return sm;
	}
	
	public JPanel getButtons() {
		JPanel buttons = new JPanel();
		JButton day = new JButton("Day");
		JButton week = new JButton("Week");
		JButton month = new JButton("Month");
		JButton agenda = new JButton("Agenda");
		JButton file = new JButton("From File");
		
		day.addActionListener(ac.day());
		week.addActionListener(ac.week());
		month.addActionListener(ac.month());
		agenda.addActionListener(ac.agenda());
		file.addActionListener(ac.file());
		
		buttons.add(day);
		buttons.add(week);
		buttons.add(month);
		buttons.add(agenda);
		buttons.add(file);
		return buttons;
	}
	
	public JPanel getAgenda() {
		JPanel textarea = new JPanel();
		final int NUM_ROWS = 30;
		final int NUM_COLS = 40;
		text = new JTextArea(NUM_ROWS,NUM_COLS);
		text.setBorder(new LineBorder(null));
		text.setEditable(false);
		
		textarea.add(text);
		return textarea;
	}
	
	public JPanel getAgendaPanel() {
		panel.add(getButtons(), BorderLayout.NORTH);
		panel.add(getAgenda(), BorderLayout.CENTER);
		return panel;
	}
	
	public void setText(String newText) {
		text.setText(newText);
	}
}
