
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Event implements Comparable {

    int day;
    int year;
    int month;
    int hour;
    int min;
    String endTime;
    String descript;

    public Event(String descript, int day, int month, int year, int hour, int min, String endTime) {
        this.day = day;
        this.month = month;
        this.descript = descript;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.endTime = endTime;
    }

    public int compareTo(Object b) {
        if (getClass() == b.getClass()) {
            Event a = (Event) b;
            if (year > a.year) {
                return 1;
            }
            if (year < a.year) {
                return -1;
            }
            if (month > a.month) {
                return 1;
            }
            if (month < a.month) {
                return -1;
            }
            if (day > a.day) {
                return 1;
            }
            if (day < a.day) {
                return -1;
            }
            if (hour > a.hour) {
                return 1;
            }
            if (hour < a.hour) {
                return -1;
            }
            if (min > a.min) {
                return 1;
            }
            if (min < a.min) {
                return -1;
            }
            return 0;
        } return 0;
    }

    public static Comparator<Event> createComparatorByName() {
            return new Comparator<Event>() {

                public int compare(Event one, Event two) {
                    return one.compareTo(two);
                }
            };
        };

}
