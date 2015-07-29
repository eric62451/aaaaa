import java.util.ArrayList;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.2
 */
public class ObserverTester
{
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Double> data = new ArrayList<Double>();

      data.add(new Double(33.0));
      data.add(new Double(44.0));
      data.add(new Double(22.0));
      data.add(new Double(22.0));

      DataModel model = new DataModel(data);

      TextFrame frame = new TextFrame(model);

      BarFrame barFrame = new BarFrame(model);

      model.attach(barFrame);
      model.attach(frame);
   }
}