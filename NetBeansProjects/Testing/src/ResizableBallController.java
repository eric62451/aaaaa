

import javax.sound.sampled.Line;
import javax.tools.JavaFileManager.Location;
import objectdraw.*;

public class ResizableBallController extends WindowController
{
  private Line xLine;
  private Line yLine;
  private double widthProportion;
  private double heightProportion;
  private Location lastPoint;
  private double size;
  private ResizableBall ball;
  private boolean xc, yc;

  public void begin()
  {
    xLine = new Line (canvas.getWidth()/2, 0, canvas.getWidth()/2, canvas.getHeight(), canvas);
    yLine = new Line (0, canvas.getHeight()/2, canvas.getWidth(), canvas.getHeight()/2, canvas);

    widthProportion = xLine.getStart().getX()/canvas.getWidth();
    heightProportion = yLine.getStart().getY() /canvas.getHeight();

  }

  public void onMouseClick(Location point)
  {
    ball = new ResizableBall(point.getX(), point.getY(), size, canvas, xLine, yLine);
  }

  public void onMousePress(Location point)
  {
    double margin = 5;

    if (xLine.contains(point))
    {
      xc = true;
    }
    else
    {
      xc = false;
    }

   if (yLine.contains(point))
   {
      yc = true;
   }
   else
   {
     yc = false;
   }

  if (xLine.contains(point) && yLine.contains(point))
   {
     xc = true;
     yc = true;
   }
  }

  public void onMouseDrag(Location point)
  {
    lastPoint = point;

    if(xc == true)
    {
      xLine.setEndPoints(lastPoint.getX(), 0, lastPoint.getX(), canvas.getHeight());

    }

    if (yc == true)
    {
      yLine.setEndPoints(0, lastPoint.getY(), canvas.getWidth(), lastPoint.getY()); 
    }
    
  }

  public void onMouseRelease(Location point)
  {

    widthProportion = xLine.getStart().getX()/canvas.getWidth();

    heightProportion = yLine.getStart().getY() /canvas.getHeight();

  }


  public void paint (java.awt.Graphics g) 
  {
    super.paint( g );

    xLine.setEndPoints(widthProportion * canvas.getWidth(), 0, 
                       widthProportion * canvas.getWidth(), canvas.getHeight());

    yLine.setEndPoints(0, heightProportion * canvas.getHeight(), 
                       canvas.getWidth(), heightProportion * canvas.getHeight());

  }


}







