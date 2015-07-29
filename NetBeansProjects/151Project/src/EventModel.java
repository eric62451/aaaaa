
import java.util.Comparator;

public class EventModel implements Comparable {

    int day;
    int year;
    int month;
    int hour;
    String endTime;
    String descript;

    public EventModel(String descript, int day, int month, int year, int hour, String endTime) {
        this.day = day;
        this.month = month;
        this.descript = descript;
        this.year = year;
        this.hour = hour;
        this.endTime = endTime;
    }

    public int compareTo(Object b) {
        if (getClass() == b.getClass()) {
            EventModel a = (EventModel) b;
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
            return 0;
        } return 0;
    }

    public static Comparator<EventModel> createComparatorByName() {
            return new Comparator<EventModel>() {

                public int compare(EventModel one, EventModel two) {
                    return one.compareTo(two);
                }
            };
        };

}
