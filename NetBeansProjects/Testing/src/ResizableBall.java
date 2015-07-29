import objectdraw.*;
import java.awt.Color.*;
import javax.sound.sampled.Line;


public class ResizableBall extends ActiveObject
{
  private FilledOval ball;
  private DrawingCanvas canvas;
  private double xLoc;
  private double yLoc;
  private double size;
  private Line hLine;
  private Line vLine;
 
  
  public ResizableBall(double xLoc, double yLoc, double size, 
                       DrawingCanvas canvas,
                       Line hLine,
                       Line vLine)

  {
    ball = new FilledOval(xLoc - size/2, yLoc - size/2, size, size, canvas);
  }



  public void run()
  {
    //Infinite loop, so this always runs
    while(true)
    { 
      //Need to update things that might change
      //i.e., size and color
      
      //Determine if color should change, based
      //on lines. Use o.setColor(___);
      
      //Update the size, to smaller or larger
      //Make sure to edit the location, as wellpause(50);
    }
  }


}
