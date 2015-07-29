import java.awt.Rectangle;
import java.util.Comparator;

public class RectangleComparatorByArea implements Comparator
{
      public int compare(Object obj1, Object obj2)
      {
         Rectangle recOne = (Rectangle) obj1;
         Rectangle recTwo = (Rectangle) obj2;
         if((recOne.getHeight()*recOne.getWidth())>(recTwo.getHeight()*recTwo.getWidth())) return 1;
         if((recOne.getHeight()*recOne.getWidth())<(recTwo.getHeight()*recTwo.getWidth())) return -1;
         return 0;
      }
}