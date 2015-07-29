/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 3
 * Event
 */

public class Event {

        String description;
        int month;
        int year;
        int day;
        int hour;
        int min;
        String endhour;

        public int compare(Event a) {
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
        }
    }