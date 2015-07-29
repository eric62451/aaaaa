
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Highest Priority First Non-preemptive strategy
 * algorithm chooses the highest priority process to run for every time slice.
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class HighestPriorityFirstNonpreemptive extends ProcessSimStrategy {

    Process lastprocess; //remember last process ran til it's over
    private Map<Process, Integer> agingMap = new TreeMap<Process, Integer>();

    HighestPriorityFirstNonpreemptive(List<Process> processes, float quanta) {
        super(processes, quanta);
    }

    /**
     * Process chooser for every time slice
     * @return the process out of list with lowest priority value
     */
    Process chooseProcess(LinkedList<Process> arrivedqueue) {
        //if it's the first time quanta or if process last run was complete
        if (lastprocess == null || !arrivedqueue.contains(lastprocess)) {
            if(!arrivedqueue.contains(lastprocess) && lastprocess != null){
                agingMap.remove(lastprocess);
            }
            //iterate through queue to get process with highest priority.
            Process shortest = arrivedqueue.getFirst();
            for (Process process : arrivedqueue) {
                if (process.priority < shortest.priority) {
                    shortest = process;
                }
            }
            lastprocess = shortest;
            aging(arrivedqueue);
            return shortest;
        }
        //else keep running last process ran
        aging(arrivedqueue);
        return lastprocess;
    }

    void aging(LinkedList<Process> arrivedqueue) {
        for (Process i : arrivedqueue) {
            if (i.priority > 1 && agingMap.containsKey(i) && i != lastprocess) {
                Integer a = agingMap.get(i);
                a = a + 1;
                if (a == 5) {
                    i.priority--;
                    a = 0;
                }
            } else if (i != lastprocess) {
                agingMap.put(i, 1);
            }
        }
    }
}
