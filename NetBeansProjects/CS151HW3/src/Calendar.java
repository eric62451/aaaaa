/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 3
 * Calendar
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Calendar {

    private static ArrayList<String> months = new ArrayList<String>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
    private static ArrayList<String> weekdays = new ArrayList<String>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));

    public static void main(String[] args) throws BadLocationException {
        final JFrame frame = new JFrame("Calendar");
        final JFrame frame2 = new JFrame("Create Event");
        final JFrame frame3 = new JFrame("Day View");
        final JFrame frame4 = new JFrame("Events View");
        final JFrame frame5 = new JFrame("Delete Events");
        final JFrame frame6 = new JFrame("Error");

        frame2.setLayout(new GridBagLayout());
        frame3.setLayout(new GridBagLayout());
        frame4.setLayout(new GridBagLayout());
        frame5.setLayout(new GridBagLayout());
        frame6.setLayout(new GridBagLayout());
        final LinkedList<Event> eventlist = new LinkedList<Event>();
        final ListIterator[] iter = new ListIterator[1];
        iter[0] = eventlist.listIterator();

        JButton previous = new JButton("Previous");
        JButton next = new JButton("Next");
        JButton create = new JButton("Create");
        JButton go = new JButton("Go to");
        JButton event = new JButton("Events");
        JButton delete = new JButton("Delete");
        JButton quit = new JButton("Quit");
        JButton save = new JButton("Save");
        JButton go2 = new JButton("Check Events");
        JButton deleteday = new JButton("Delete Date");
        JButton deleteall = new JButton("Delete All");

        final JTextField godateField = new JTextField(10);
        final JTextField dateField = new JTextField(10);
        final JTextField eventField = new JTextField(10);
        final JTextField hourField = new JTextField(10);
        final JTextField hourField2 = new JTextField(10);
        final JTextPane textField = new JTextPane();
        final JTextPane daytextField = new JTextPane();
        final JTextPane eventtextField = new JTextPane();
        final JTextField deleteField = new JTextField(10);

        JPanel createPanel = new JPanel();
        JPanel goPanel = new JPanel();
        JPanel Button = new JPanel();
        JPanel btton = new JPanel();
        JPanel tPanel = new JPanel();
        JPanel daytPanel = new JPanel();
        JPanel eventtPanel = new JPanel();
        JPanel deletePanel = new JPanel();
        
        deletePanel.setLayout(new FlowLayout());
        GregorianCalendar date = new GregorianCalendar();
        Font font = new Font("Courier New", Font.PLAIN, 15);
        final int[] current = new int[2];
        current[0] = date.get(GregorianCalendar.MONTH) + 1;
        current[1] = date.get(GregorianCalendar.YEAR);
        final String[] cal = new String[1];
        //final int currentMonth = date.get(Calendar.MONTH)+1;
        //final int currentYear = date.get(Calendar.YEAR);
        daytextField.setFont(font);
        eventtextField.setFont(font);
        textField.setFont(font);
        //textField.setText("Click a button!");

        previous.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                current[0]--;
                if (current[0] == 0) {
                    current[1]--;
                    current[0] = 12;
                }
                cal[0] = buildCalendar(current[0], current[1]);
                textField.setText(cal[0]);
            }
        });
        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                current[0]++;
                if (current[0] == 13) {
                    current[1]++;
                    current[0] = 1;
                }
                cal[0] = buildCalendar(current[0], current[1]);
                textField.setText(cal[0]);

            }
        });
        event.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                String eventText = "";
                int year = 0;
                while (iter[0].hasNext()) {
                    Event a = (Event) iter[0].next();
                    if (year != a.year) {
                        eventText = eventText + a.year + "\n";
                        year = a.year;
                    }
                    if (a.endhour.isEmpty()) {
                        if (a.min < 10) {
                            eventText = eventText + "  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":0" + a.min + " " + a.description + "\n";
                        } else {
                            eventText = eventText + "  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":" + a.min + " " + a.description + "\n";
                        }
                    } else {
                        if (a.min < 10) {
                            eventText = eventText + "  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":0" + a.min + " " + "-" + " " + a.endhour + " " + a.description + "\n";
                        } else {
                            eventText = eventText + "  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":" + a.min + " " + "-" + " " + a.endhour + " " + a.description + "\n";
                        }
                    }
                }
                eventtextField.setText(eventText);
                frame4.setVisible(true);
                iter[0] = eventlist.listIterator();

            }
        });
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                frame2.setVisible(true);

            }
        });
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                frame5.setVisible(true);

            }
        });
        deleteday.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                String str = deleteField.getText();
                int month = Integer.parseInt(str.substring(0, 2));
                int day = Integer.parseInt(str.substring(3, 5));
                int year = Integer.parseInt(str.substring(6));
                while (iter[0].hasNext()) {
                    Event a = (Event) iter[0].next();
                    if (a.day == day && a.month == month && a.year == year) {
                        iter[0].remove();
                    }
                }
                iter[0] = eventlist.listIterator();
                frame5.setVisible(false);
                deleteField.setText("");

            }
        });
        deleteall.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                eventlist.removeAll(eventlist);
                frame5.setVisible(false);
                deleteField.setText("");

            }
        });
        quit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                File file = new File("reservation.txt");
                try {
                    file.createNewFile();
                    PrintWriter out = new PrintWriter(file);
                    int year = 0;
                    while (iter[0].hasNext()) {
                        Event a = (Event) iter[0].next();
                        if (year != a.year) {
                            out.println(a.year);
                            year = a.year;
                        }
                        if (a.endhour.isEmpty()) {
                            if (a.min < 10) {
                                out.println("  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":0" + a.min + " " + a.description);
                            } else {
                                out.println("  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":" + a.min + " " + a.description);
                            }
                        } else {
                            if (a.min < 10) {
                                out.println("  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":0" + a.min + " " + "-" + " " + a.endhour + " " + a.description);
                            } else {
                                out.println("  " + months.get(a.month - 1) + " " + a.day + " " + a.hour + ":" + a.min + " " + "-" + " " + a.endhour + " " + a.description);
                            }
                        }
                    }
                    out.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                frame.dispose();
                System.exit(0);
            }
        });
        go2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                String str = godateField.getText();
                String showEvents = "";
                int month = Integer.parseInt(str.substring(0, 2));
                int day = Integer.parseInt(str.substring(3, 5));
                int year = Integer.parseInt(str.substring(6));
                showEvents = weekdays.get((weekday(month, year) + day - 1) % 7) + " " + month + "/" + day + "\n\n";
                while (iter[0].hasNext()) {
                    Event a = (Event) iter[0].next();
                    if (a.day == day && a.month == month && a.year == year) {
                        if (a.hour > 12) {
                            showEvents = showEvents + (a.hour - 12) + " pm  ";
                        } else {
                            showEvents = showEvents + a.hour + " am  ";
                        }
                        showEvents = showEvents + a.description + "\n";
                    }
                }
                iter[0] = eventlist.listIterator();
                daytextField.setText(showEvents);
            }
        });
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                Event a = new Event();
                String str = dateField.getText();
                a.month = Integer.parseInt(str.substring(0, 2));
                a.day = Integer.parseInt(str.substring(3, 5));
                a.year = Integer.parseInt(str.substring(6));
                str = hourField.getText();
                a.hour = Integer.parseInt(str.substring(0, str.indexOf(":")));
                a.min = Integer.parseInt(str.substring(str.indexOf(":") + 1));
                a.endhour = hourField2.getText();
                a.description = eventField.getText();
                boolean stop = false;
                Event b = null;
                while (iter[0].hasNext() && stop == false) {
                    b = (Event) iter[0].next();
                    if (a.compare(b) == 0) {
                        frame6.setVisible(true);
                        stop = true;
                        break;
                    }
                    if (a.compare(b) == -1) {
                        if (iter[0].hasPrevious()) {
                            if (!a.endhour.isEmpty()) {
                                if ((a.year==b.year&&a.month==b.month&&a.day==b.day)&&(Integer.parseInt(a.endhour.substring(0, a.endhour.indexOf(":"))) > b.hour || (Integer.parseInt(a.endhour.substring(0, a.endhour.indexOf(":"))) == b.hour && Integer.parseInt(a.endhour.substring(b.endhour.indexOf(":")+1)) > b.min))) {
                                    frame6.setVisible(true);
                                    stop = true;
                                    break;
                                }

                            }
                            iter[0].previous();
                            if (iter[0].hasPrevious()) {
                                Event c = (Event) iter[0].previous();
                                iter[0].next();
                                if (!c.endhour.isEmpty()) {
                                    if ((c.year==a.year&&c.month==a.month&&c.day==a.day)&&(Integer.parseInt(c.endhour.substring(0, c.endhour.indexOf(":"))) > a.hour || (Integer.parseInt(c.endhour.substring(0, c.endhour.indexOf(":"))) == a.hour && Integer.parseInt(c.endhour.substring(c.endhour.indexOf(":")+1)) > a.min))) {
                                        frame6.setVisible(true);
                                        stop = true;
                                        break;
                                    }
                                }
                            }
                            iter[0].add(a);
                            stop = true;
                        } else {
                            eventlist.addFirst(a);
                            stop = true;
                        }
                    }
                }
                if (stop == false && eventlist.isEmpty()) {
                    eventlist.addFirst(a);
                } else if (stop == false) {
                    if (!b.endhour.isEmpty()) {
                        if ((a.year==b.year&&a.month==b.month&&a.day==b.day)&&(Integer.parseInt(b.endhour.substring(0, b.endhour.indexOf(":"))) > a.hour || (Integer.parseInt(b.endhour.substring(0, b.endhour.indexOf(":"))) == a.hour && Integer.parseInt(b.endhour.substring(b.endhour.indexOf(":")+1)) > a.min))) {
                            frame6.setVisible(true);
                        }else eventlist.addLast(a);
                    }else eventlist.addLast(a);
                }
                iter[0] = eventlist.listIterator();
                frame2.setVisible(false);
                dateField.setText("");
                hourField.setText("");
                hourField2.setText("");
                eventField.setText("");
            }
        });
        go.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                frame3.setVisible(true);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        frame.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        BorderLayout bor = new BorderLayout();
        bor.setHgap(43);
        Button.setLayout(bor);
        //Button.setBounds(0, 0, 10000, 500);
        //Button.setBounds(0, 0, 10000, 50);
        //helloButton.setBounds(0, 0, 150, 20);
        Button.add(next, BorderLayout.EAST);
        //goodbyeButton.setBounds(50, 0, 150, 20);
        Button.add(previous, BorderLayout.WEST);
        frame.add(Button, gbc);
        //gbc.gridx=3;
        //frame.add(goodbyeButton,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        tPanel.setLayout(null);
        daytPanel.setLayout(null);
        eventtPanel.setLayout(null);
        textField.setBounds(0, 0, 240, 240);
        daytextField.setBounds(0, 0, 240, 240);
        eventtextField.setBounds(0, 0, 700, 500);

        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyledDocument sdoc = textField.getStyledDocument();
        //StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(aSet, 19);

        cal[0] = buildCalendar(current[0], current[1]);
        sdoc.insertString(0, cal[0], aSet);
        sdoc.setParagraphAttributes(0, cal[0].length(), aSet, false);


        tPanel.add(textField);
        tPanel.setPreferredSize(new Dimension(240, 240));
        daytPanel.add(daytextField);
        daytPanel.setPreferredSize(new Dimension(240, 240));
        eventtPanel.add(eventtextField);
        eventtPanel.setPreferredSize(new Dimension(700, 500));
        frame.add(tPanel, gbc);
        createPanel.setLayout(new GridBagLayout());
        btton.add(create);
        btton.add(go);
        btton.add(event);
        btton.add(delete);
        btton.add(quit);
        gbc.gridy = 2;
        frame.add(btton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        createPanel.add(new JLabel("Date (MM/DD/YYYY)           "), gbc);
        gbc.gridx = 1;
        createPanel.add(dateField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        createPanel.add(new JLabel("Starting time (Ex. 3:00)"), gbc);
        gbc.gridx = 1;
        createPanel.add(hourField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        createPanel.add(new JLabel("Ending time"), gbc);
        gbc.gridx = 1;
        createPanel.add(hourField2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        createPanel.add(new JLabel("Description"), gbc);
        gbc.gridx = 1;
        createPanel.add(eventField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame2.add(save, gbc);
        gbc.gridy = 0;
        frame2.add(createPanel);
        goPanel.add(new JLabel("Date (MM/DD/YYYY)    "), gbc);
        gbc.gridx = 1;
        goPanel.add(godateField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame3.add(goPanel, gbc);
        gbc.gridy = 1;
        frame3.add(daytPanel, gbc);
        gbc.gridy = 2;
        frame3.add(go2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame4.add(eventtPanel);
        gbc.gridy = 1;
        frame5.add(deleteday, gbc);
        gbc.gridx = 1;
        frame5.add(deleteall, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame5.add(new JLabel("Date (MM/DD/YYYY)    "), gbc);
        gbc.gridx = 1;
        frame5.add(deleteField, gbc);
        frame6.add(new JLabel("Error: Time Conflict"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame2.pack();
        frame2.setVisible(false);
        frame3.pack();
        frame3.setVisible(false);
        frame4.pack();
        frame4.setVisible(false);
        frame5.pack();
        frame5.setVisible(false);
        frame6.pack();
        frame6.setVisible(false);
    }

    private static String buildCalendar(int month, int year) {
        String calendar = "";
        calendar = calendar + "    " + months.get(month - 1) + " " + year + "\n";
        calendar = calendar + " S  M Tu  W Th  F  S\n";
        int day = weekday(month + 1, year);
        int totaldays, linecount, i;
        totaldays = 0;
        linecount = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            totaldays = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            totaldays = 30;
        } else if (month == 2) {
            if ((year % 400) == 0) {
                totaldays = 29;
            } else if ((year % 100) == 0) {
                totaldays = 28;
            } else if ((year % 4) == 0) {
                totaldays = 29;
            } else {
                totaldays = 28;
            }
        }
        for (i = 0; i < weekday(month, year); i++) {
            calendar = calendar + "   ";
            linecount++;
        }
        for (i = 1; i <= totaldays; i++) {
            if (i < 10) {
                calendar = calendar + " " + i + " ";
            } else {
                calendar = calendar + i + " ";
            }
            linecount++;
            if (linecount == 7) {
                calendar = calendar + "\n";
                linecount = 0;
            }
        }
        return calendar;
    }

    private static int weekday(int month, int year) {
        int startWeekday = 1;
        int i;
        for (i = 1900; i < year; i++) {
            startWeekday = startWeekday + 365;
            if ((i % 400) == 0) {
                startWeekday++;
            } else if ((i % 100) == 0) {
                startWeekday = startWeekday + 0;
            } else if ((i % 4) == 0) {
                startWeekday++;
            } else {
                startWeekday = startWeekday + 0;
            }
        }
        for (i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                startWeekday = startWeekday + 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                startWeekday = startWeekday + 30;
            } else if (i == 2) {
                if ((year % 400) == 0) {
                    startWeekday = startWeekday + 29;
                } else if ((year % 100) == 0) {
                    startWeekday = startWeekday + 28;
                } else if ((year % 4) == 0) {
                    startWeekday = startWeekday + 29;
                } else {
                    startWeekday = startWeekday + 28;
                }
            }
        }
        return startWeekday % 7;
    }

    /*static class Event {
    
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
    }*/
}
