
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Calendar;
import javax.swing.Icon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class ClockIcon implements Icon{
    int size = 100;

    Calendar a;

    public ClockIcon(){
        
    }


    public void paintIcon(Component c, Graphics g, int x, int y) {
        a = Calendar.getInstance();
        double xt = 0;
        double yt = 0;
        if(a.get(Calendar.SECOND)<15) xt = x+50+(a.get(Calendar.SECOND)/15*47);
        else if(a.get(Calendar.SECOND) > 15 && a.get(Calendar.SECOND) < 30) xt = x + 97 - ((a.get(Calendar.SECOND)-15) / 15 * 47);
        else if(a.get(Calendar.SECOND) > 30 && a.get(Calendar.SECOND) < 45) xt = x + 50 - ((a.get(Calendar.SECOND)-30) / 15 * 47);
        else if(a.get(Calendar.SECOND) > 45 && a.get(Calendar.SECOND) < 60) xt = x + 3 + ((a.get(Calendar.SECOND)-45) / 15 * 47);
        if(a.get(Calendar.SECOND)<15) yt = y+3+(a.get(Calendar.SECOND)/15*47);
        else if(a.get(Calendar.SECOND) > 15 && a.get(Calendar.SECOND) < 30) yt = y + 50 - ((a.get(Calendar.SECOND)-15) / 15 * 47);
        else if(a.get(Calendar.SECOND) > 30 && a.get(Calendar.SECOND) < 45) yt = y + 97 - ((a.get(Calendar.SECOND)-30) / 15 * 47);
        else if(a.get(Calendar.SECOND) > 45 && a.get(Calendar.SECOND) < 60) yt = y + 50 - ((a.get(Calendar.SECOND)-45) / 15 * 47);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double icon = new Ellipse2D.Double(x, y, size, size);
        Line2D.Double second = new Line2D.Double((double)x+50,(double)y+50,xt,yt);
        if(a.get(Calendar.MINUTE)<15) xt = x+50+(a.get(Calendar.MINUTE)/15*40);
        else if(a.get(Calendar.MINUTE) > 15 && a.get(Calendar.MINUTE) < 30) xt = x + 90 - ((a.get(Calendar.MINUTE)-15) / 15 * 40);
        else if(a.get(Calendar.MINUTE) > 30 && a.get(Calendar.MINUTE) < 45) xt = x + 50 - ((a.get(Calendar.MINUTE)-30) / 15 * 40);
        else if(a.get(Calendar.MINUTE) > 45 && a.get(Calendar.MINUTE) < 60) xt = x + 10 + ((a.get(Calendar.MINUTE)-45) / 15 * 40);
        if(a.get(Calendar.MINUTE)<15) yt = y+10+(a.get(Calendar.MINUTE)/15*40);
        else if(a.get(Calendar.MINUTE) > 15 && a.get(Calendar.MINUTE) < 30) yt = y + 50 - ((a.get(Calendar.MINUTE)-15) / 15 * 40);
        else if(a.get(Calendar.MINUTE) > 30 && a.get(Calendar.MINUTE) < 45) yt = y + 90 - ((a.get(Calendar.MINUTE)-30) / 15 * 40);
        else if(a.get(Calendar.MINUTE) > 45 && a.get(Calendar.MINUTE) < 60) yt = y + 50 - ((a.get(Calendar.MINUTE)-45) / 15 * 40);
        Line2D.Double minute = new Line2D.Double((double)x+50,(double)y+50,xt,yt);
        if(a.get(Calendar.HOUR)<15) xt = x+50+(a.get(Calendar.HOUR)/15*30);
        else if(a.get(Calendar.HOUR) > 15 && a.get(Calendar.HOUR) < 30) xt = x + 80 - ((a.get(Calendar.HOUR)-15) / 15 * 30);
        else if(a.get(Calendar.HOUR) > 30 && a.get(Calendar.HOUR) < 45) xt = x + 50 - ((a.get(Calendar.HOUR)-30) / 15 * 30);
        else if(a.get(Calendar.HOUR) > 45 && a.get(Calendar.HOUR) < 60) xt = x + 20 + ((a.get(Calendar.HOUR)-45) / 15 * 30);
        if(a.get(Calendar.HOUR)<15) yt = y+20+(a.get(Calendar.HOUR)/15*30);
        else if(a.get(Calendar.HOUR) > 15 && a.get(Calendar.HOUR) < 30) yt = y + 50 - ((a.get(Calendar.HOUR)-15) / 15 * 30);
        else if(a.get(Calendar.HOUR) > 30 && a.get(Calendar.HOUR) < 45) yt = y + 80 - ((a.get(Calendar.HOUR)-30) / 15 * 30);
        else if(a.get(Calendar.HOUR) > 45 && a.get(Calendar.HOUR) < 60) yt = y + 50 - ((a.get(Calendar.HOUR)-45) / 15 * 30);
        Line2D.Double hour = new Line2D.Double((double)x+50,(double)y+50,xt,yt);
        g2.setColor(Color.WHITE);
        g2.fill(icon);
        g2.setColor(Color.BLACK);
        g2.draw(second);
        g2.draw(hour);
        g2.draw(minute);
    }

    public int getIconWidth() {
        return size;
    }

    public int getIconHeight() {
        return size;
    }

}
