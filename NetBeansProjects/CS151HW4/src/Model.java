import java.util.ArrayList;
import javax.swing.event.*;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * MVC
 */
public class Model
{

   public Model()
   {
      listeners = new ArrayList<ChangeListener>();
   }

   
   public ArrayList<String> getData()
   {
      return (ArrayList<String>) (data.clone());
   }

   
   public void attach(ChangeListener c)
   {
      listeners.add(c);
   }

   
   public void add(String str)
   {
      data.add(str);
      for (ChangeListener l : listeners)
      {
         l.stateChanged(new ChangeEvent(this));
      }
   }

   ArrayList<String> data = new ArrayList<String>();
   ArrayList<ChangeListener> listeners;
}