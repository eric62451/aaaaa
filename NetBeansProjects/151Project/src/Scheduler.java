
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Scheduler {

    private SortedSet<Event> sched;
    private static ArrayList<String> months = new ArrayList<String>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
    Calendar c = Calendar.getInstance();
    ArrayList<ChangeListener> listeners;

    public Scheduler() {
        sched = new TreeSet<Event>(Event.createComparatorByName());
        listeners = new ArrayList<ChangeListener>();
    }

    public boolean add(Event a) {
        for (ChangeListener l : listeners) {
            l.stateChanged(new ChangeEvent(this));
        }
        return sched.add(a);
    }

    public String getWeek(int year, int month, int day){
        c.set(year, month - 1, day);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-1;
        return getString(year, month, day-dayOfWeek, year, month, day+(7-dayOfWeek));
    }

    public String getString(int year) {
        Iterator iter = sched.iterator();
        boolean noEvent = true;
        boolean monthChange = false;
        String retrn = "" + year + "\n";
        int month = 0;
        int day = 0;
        while (iter.hasNext()) {
            Event temp = (Event) iter.next();
            if (temp.year == year) {
                noEvent = false;
                if (temp.month != month) {
                    month = temp.month;
                    retrn += "  " + months.get(month - 1) + "\n";
                    monthChange = true;
                }
                if (temp.day != day && monthChange) {
                    day = temp.day;
                    retrn += "    " + day + "\n";
                }
                monthChange = false;
                retrn += "      " + temp.hour + ((temp.endTime.isEmpty()) ? "" : " - " + temp.endTime) + " " + temp.descript + "\n";
            } else if (!noEvent) {
                break;
            }

        }
        return (noEvent) ? "No Events Scheduled" : retrn;
    }

    public String getString(int year, int month, int day) {
        Iterator iter = sched.iterator();
        boolean noEvent = true;
        String retrn = "" + year + " " + month + " " + day + "\n";
        while (iter.hasNext()) {
            Event temp = (Event) iter.next();
            if (temp.day == day && temp.month == month && temp.year == year) {
                noEvent = false;
                retrn += temp.hour + ((temp.endTime.isEmpty()) ? "" : " - " + temp.endTime) + " " + temp.descript + "\n";
            } else if (!noEvent) {
                break;
            }
        }
        return (noEvent) ? "No Events Scheduled" : retrn;
    }

    public String getString(int year, int month) {
        Iterator iter = sched.iterator();
        boolean noEvent = true;
        int day = 0;
        String retrn = "" + year + " " + month + "\n";
        while (iter.hasNext()) {
            Event temp = (Event) iter.next();
            if (temp.month == month && temp.year == year) {
                if (temp.day != day) {
                    day = temp.day;
                    retrn += "  " + day + "\n";
                }
                retrn += "    " + temp.hour + ((temp.endTime.isEmpty()) ? "" : " - " + temp.endTime) + " " + temp.descript + "\n";
            } else if (!noEvent) {
                break;
            }
        }
        return (noEvent) ? "No Events Scheduled" : retrn;
    }

    public String getString(int year, int month, int day, int eyear, int emonth, int eday) {
        Iterator iter = sched.iterator();
        boolean noEvent = true;
        boolean monthChange = false;
        boolean yearChange = false;
        String retrn = "";
        int tempYear = 0;
        int tempmonth = 0;
        int tempday = 0;
        while (iter.hasNext()) {
            Event temp = (Event) iter.next();
            if (temp.year >= year && temp.year <= eyear) {
                if ((!(temp.month < month && temp.year == year)) && (!(temp.month > emonth && temp.year == eyear))) {
                    if ((!(temp.day < day && temp.month == month)) && (!(temp.day > eday && temp.month == emonth))) {

                        noEvent = false;
                        if (temp.year != tempYear) {
                            tempYear = temp.year;
                            retrn += temp.year+"\n";
                            yearChange = true;
                        }
                        if (temp.month != tempmonth && yearChange) {
                            month = temp.month;
                            retrn += "  " + months.get(month - 1) + "\n";
                            monthChange = true;
                        }
                        if (temp.day != tempday && monthChange) {
                            day = temp.day;
                            retrn += "    " + day + "\n";
                        }
                        yearChange = false;
                        monthChange = false;
                        retrn += "      " + temp.hour + ((temp.endTime.isEmpty()) ? "" : " - " + temp.endTime) + " " + temp.descript + "\n";
                    }
                }
            } else if (!noEvent) {
                break;
            }

        }
        return (noEvent) ? "No Events Scheduled" : retrn;
    }

    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    public void set(String s) {
        String desc = s.substring(0, s.indexOf(";"));
        s = s.substring(s.indexOf(";") + 1);
        int y = Integer.parseInt(s.substring(0, s.indexOf(";")));
        s = s.substring(s.indexOf(";") + 1);
        int sm = Integer.parseInt(s.substring(0, s.indexOf(";")));
        s = s.substring(s.indexOf(";") + 1);
        int em = Integer.parseInt(s.substring(0, s.indexOf(";")));
        s = s.substring(s.indexOf(";") + 1);
        String days = s.substring(0, s.indexOf(";"));
        s = s.substring(s.indexOf(";") + 1);
        int sh = Integer.parseInt(s.substring(0, s.indexOf(";")));
        s = s.substring(s.indexOf(";") + 1);
        int eh = Integer.parseInt(s.substring(0, s.indexOf(";")));



        for (int i = sm; i < em; i++) {
            c.set(y, i, 1);
            int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int j = 1; j <= daysInMonth; j++) {
                if (days.contains(getWeekday(y, sm, j))) {
                    add(new Event(desc, j, i, y, sh, 0, eh + ":00"));
                }
            }
        }
    }

    private String getWeekday(int year, int month, int day) {
        c.set(year, month - 1, day);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                return "S";
            case 2:
                return "M";
            case 3:
                return "T";
            case 4:
                return "W";
            case 5:
                return "H";
            case 6:
                return "F";
            case 7:
                return "A";
            default:
                return null;
        }
    }
}
