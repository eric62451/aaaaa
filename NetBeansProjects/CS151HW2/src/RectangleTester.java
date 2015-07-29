
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class RectangleTester {

    public static ArrayList sort(ArrayList<Rectangle2D.Double> o){
        ArrayList<Rectangle2D.Double> answer = new ArrayList<Rectangle2D.Double>();
        Rectangle2D.Double max;
        int maxN;
        int j;
        while(o.size() != 0){
            max = o.get(0);
            maxN = 0;
            for(j = 0; j<o.size();j++){
                if(new RectangleComparator().compare(max, o.get(j)) == -1){
                    max = o.get(j);
                    maxN = j;
                }
            }
            answer.add(max);
            o.remove(maxN);
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Rectangle2D.Double> o = new ArrayList<Rectangle2D.Double>();
        o.add(new Rectangle2D.Double(1,2,3,4));
        o.add(new Rectangle2D.Double(1,2,3,5));
        o.add(new Rectangle2D.Double(6,6,6,6));
        o.add(new Rectangle2D.Double(6,6,6,6));
        o.add(new Rectangle2D.Double(5,7,5,8));
        o.add(new Rectangle2D.Double(2,2,3,4));
        o.add(new Rectangle2D.Double(9,2,3,4));
        ArrayList<Rectangle2D.Double> a = sort(o);
        for(Rectangle2D.Double i : a){
            System.out.println(i.toString());
        }


    }

}
