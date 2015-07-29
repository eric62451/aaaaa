
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tester for running processes with a specified running strategy
 *
 * @author David Hsu, Eric, Gary Seto
 *
 */
class ProcessTester {
    /*
     * Running strategy can be either:
     *
     * FCFS - first come first served
     * SRT - Shortest remaining time
     * HPF - highest priority first, preemptive
     * HPF-NP - highest priority first, non-preemptive
     * SJF - Shortest Job First
     * RR - round robin
     */

    static String RUNNING_STRATEGY = "FCFS";
    /*
     * number of time slices to run for
     */
    static float QUANTA = 100;
    /* processes file, each line has the following:
     *
     * -process ID
     * -arrival time
     * -burst time
     *
     * separated by commas.
     */
    static String PROCESSES_FILE = "processes.txt";
    //debug flag
    public static final boolean DEBUG = false;
    //Static final constants for process generation
    public static final int NUMBEROFPROCESSES = 25;
    public static final String PROCESSNAMESTRING = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
    public static final float ARRIVALTIMEMIN = 0;
    public static final float ARRIVALTIMEMAX = 99;
    public static final float BURSTTIMEMIN = 1;
    public static final float BURSTTIMEMAX = 10;
    public static final int PRIORITYMIN = 1;
    public static final int PRIORITYMAX = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        try {
            //make list of processes to pass to strategy
            List<Process> processes = new ArrayList<Process>();

            if (DEBUG) {

                reader = new BufferedReader(new FileReader(PROCESSES_FILE));

                // read in processes info to create processes
                String currentline;
                while ((currentline = reader.readLine()) != null) {
                    String lineparts[] = currentline.split(",");
                    char processid = lineparts[0].charAt(0);
                    float arrivaltime = new Float(lineparts[1]);
                    float bursttime = new Float(lineparts[2]);
                    int priority = new Integer(lineparts[3]);
                    Process process = new Process(processid, arrivaltime,
                            bursttime, priority);
                    processes.add(process);
                }
            } else {
                //randomly generated processes
                for (int i = 0; i < NUMBEROFPROCESSES; i++) {
                    char processid = PROCESSNAMESTRING.charAt(i % 26);
                    float arrivaltime = (float) (ARRIVALTIMEMIN + (Math.random() * ((ARRIVALTIMEMAX + ARRIVALTIMEMIN) + 1)));
                    float bursttime = (float) (BURSTTIMEMIN + (Math.random() * ((BURSTTIMEMAX + BURSTTIMEMIN) + 1)));
                    int priority = PRIORITYMIN + (int) (Math.random() * ((PRIORITYMAX + PRIORITYMIN) + 1));
                    Process process = new Process(processid, arrivaltime,
                            bursttime, priority);
                    processes.add(process);
                }
            }

            //print out processes
            System.out.println("================================================= ");
            System.out.println("Process ID | Arrival Time | Burst time | Priority ");
            for (Process process : processes) {
                System.out.printf(process.processid + "\t\t"
                        + "%.2f" + "\t\t" + "%.2f" + "\t\t" + "%d" + "\n",
                        process.arrivaltime, process.bursttime, process.priority);
            }
            System.out.println("================================================= ");


            //get strategy we asked for
            ProcessSimStrategy strategy = null;
            switch (RUNNING_STRATEGY) {
                case "FCFS":
                    strategy = new FirstComeFirstServed(processes, QUANTA);
                    break;
                case "SRT":
                    strategy = new ShortestRemainingTime(processes, QUANTA);
                    break;
                case "RR":
                    strategy = new RoundRobin(processes, QUANTA);
                    break;
                case "HPF":
                    strategy = new HighestPriorityFirstPreemptive(processes, QUANTA);
                    break;
                case "HPF-NP":
                    strategy = new HighestPriorityFirstNonpreemptive(processes, QUANTA);
                    break;
                case "HPF-P":
                    strategy = new HighestPriorityFirstPreemptive(processes, QUANTA);
                    break;
                case "SJF":
                    strategy = new ShortestJobFirst(processes, QUANTA);
                    break;
            }
            //print the strategy we're using to console
            System.out.println(RUNNING_STRATEGY);
            strategy.run(); //run the processes
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (DEBUG) {
                reader.close();
            }
        }
    }
}
