
import java.util.Random;

/*

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

*/
public class Tes
{ 
	public static void main(String args[])
	{
            Random a = new Random(1);
            double count = 0;
            for(int i = 1; i<=66; i++){
                double temp = (100+(a.nextDouble()*1000));
                String tem = String.format("%.2f", temp);
                count = count + Double.parseDouble(tem);
                System.out.printf("('E-Store',%d,%.2f),\n",i, temp);
            }
            System.out.println(count);
	}

        public static int tester(int i){
            if(i==1000000) return i;
            return tester(i+1);
        }

}