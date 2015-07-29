
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Process Simulator Strategy
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
abstract class ProcessSimStrategy {
    //constants

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //for naming processes
    //Mutables
    List<Process> processes;
    float quanta;
    //Changed by program
    float averagewait, averageturnaround, averageresponse, throughput;
    LinkedList<Process> arrivedqueue;
    List<Process> doneprocesses;
    int totalnumofruns;
    String timeline;

    /**
     * Create new strategy
     * @param processes processes to run
     * @param quanta total time slices to run
     */
    ProcessSimStrategy(List<Process> processes, float quanta) {
        this.processes = processes;
        this.quanta = quanta;
        arrivedqueue = new LinkedList<Process>();
        doneprocesses = new ArrayList<Process>();
        totalnumofruns = 0;
        timeline = "";
    }

    /**
     * Algorithm that that chooses a process (already arrived)
     * to run, for every time slice
     * @param arrivedqueue
     * @return the Process to run based on the user's algorithm
     */
    abstract Process chooseProcess(LinkedList<Process> arrivedqueue);

    /**
     * Run processes
     * @param processes
     */
    void run() {
        float time;//Run til given quanta.
        for (time = 1; time <= quanta; time += 1.f) {
            //Decrement times left to arrive.
            handleNotYetArrived();
            //Then handle processes already on queue.
            handleArrived(time);
        }
        for (;!arrivedqueue.isEmpty(); time += 1.f) {
            handleArrived(time);
        }
        //Done, print results.
        printResults(doneprocesses);
    }

    /**
     * handle processes that have not yet arrived to queue
     */
    private void handleNotYetArrived() {
        for (int i = 0; i < processes.size(); i++) {
            Process process = processes.get(i);

            //Add to queue if arrive time left is 0.
            if (process.arriveleft <= 0) {
                arrivedqueue.offer(process);
                processes.remove(i);
                i--;
            } else //Decrement time left to arrive for non-arrived processes.
            {
                process.arriveleft -= 1.f;
            }
        }
    }

    /**
     * handle processes that have arrived to queue
     * @param time the current time slice/period
     */
    private void handleArrived(float time) {
        //If there are processes in arrived queue,
        if (!arrivedqueue.isEmpty()) {
            //choose a process to run and run it (based on given strategy).
            Process chosenprocess = chooseProcess(arrivedqueue);
            totalnumofruns++;
            timeline += chosenprocess.processid;
            chosenprocess.worktimeleft -= 1.f; //subtract from work left.

            //If process's work is done,
            if (chosenprocess.worktimeleft <= 0) {
                //we have determined its turnaround time.
                chosenprocess.turnedaroundtime = time - chosenprocess.arrivaltime;
                arrivedqueue.remove(chosenprocess);
                doneprocesses.add(chosenprocess);
            }

            //If just started working,
            if (chosenprocess.worktimeleft == chosenprocess.bursttime - 1.f) //we have determined its wait time.
            {
                chosenprocess.waitedtime = time - 1.f - chosenprocess.arrivaltime;
            }
        }
    }

    /**
     * Calculate statistics of completed run.
     */
    private void calculateStats() {
        //Wait time is time between arrival and right before working.
        float totalwait = 0;
        //Turnaround time is time between arrival and completion.
        float totalturnaround = 0;
        //Response time is time that a process arrives to queue.
        float totalresponse = 0;
        for (Process process : doneprocesses) {
            totalwait += process.waitedtime;
            totalturnaround += process.turnedaroundtime;
            totalresponse += process.arrivaltime;
        }
        averagewait = totalwait / doneprocesses.size();
        averageturnaround = totalturnaround / doneprocesses.size();
        averageresponse = totalresponse / doneprocesses.size();
        //Throughput is total number of runs divided by total simulation time.
        throughput = totalnumofruns / quanta;
    }

    /**
     * print results of everything once we're done
     * @param processes
     */
    void printResults(List<Process> processes) {
        calculateStats();

        //Sort by process ID first.
        Collections.sort(processes, new Comparator<Process>() {

            public int compare(Process a, Process b) {
                return a.processid - b.processid;
            }
        });

        //Print stats to console.
        System.out.println("============================================ ");
        System.out.println("Process ID | Turnaround time | Wait time ");
        for (Process process : processes) {
            System.out.printf(process.processid + "\t\t"
                    + "%.2f" + "\t\t" + "%.2f" + "\n", process.turnedaroundtime, process.waitedtime);
        }
        System.out.println("============================================ ");
        System.out.println("Average wait: " + averagewait
                + " quanta | Average turnaround: " + averageturnaround
                + " quanta | Throughput: " + throughput
                + " runs/quantum | Average response:" + averageresponse);

        printTimeline();
    }

    void printTimeline() {
        System.out.println("Timeline: " + timeline);
    }
}
