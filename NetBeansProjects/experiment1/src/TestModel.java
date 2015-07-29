import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TestModel {
	
	private ArrayList<String> text;
	private ArrayList<ChangeListener> listener;
	
	public TestModel()
	{
		text = new ArrayList<String>();
		listener = new ArrayList<ChangeListener>();
	}
	
	public ArrayList<String> getTest()
	{
		return (ArrayList<String>)(text.clone());
		
	}

	public void attach(ChangeListener c)
	{
		listener.add(c);
	}
	
	public void addText(String ntext)
	{
		text.add(ntext);
		ChangeEvent event = new ChangeEvent(this);
	      for(ChangeListener a : listener)
	        a.stateChanged(event);
	}
}
