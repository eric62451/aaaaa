import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarModel {
	private GregorianCalendar gc;
	private String[] month;
	private int day;
	
	/**
	 * Creates a new Calendar
	 */
	public CalendarModel() {
		gc = new GregorianCalendar();
		month = new String[]{"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"};
		DateFormat dateFormat = new SimpleDateFormat("dd");
		day = Integer.parseInt(dateFormat.format(gc.getTime()));
	}
	
	public GregorianCalendar getGC() {
		return gc;
	}
	
	public int getMonth() {
		return gc.get(2);
	}
	
	/**
	 * Returns String version of month
	 * @return current month
	 */
    public String getMonthName() {
    	return month[gc.get(2)];
    }

    /**
     * Update current month
     * @param changeMonth value to increase or decrease month
     */
    public void updateMonth(int changeMonth) {
        gc.set(2, gc.get(2) + changeMonth);
    }
    
    public int getDay() {
    	return day;
    }
    
    public void setDay(int day) {
    	this.day = day;
    }
    
    public int getYear() {
    	return gc.get(1);
    }
    
    public int getStartDay() {
        java.util.Calendar currentMonth = new GregorianCalendar(gc.get(1), gc.get(2), 1);
        int startDay = currentMonth.get(java.util.Calendar.DAY_OF_WEEK);
        return startDay;
    }
    
    public int getNumDays() {
        java.util.Calendar currentMonth = new GregorianCalendar(gc.get(1), gc.get(2), 1);
        int numDays = currentMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
    	return numDays;
    }
}