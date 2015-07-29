
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Highest Priority First Preemptive strategy
 * algorithm chooses the highest priority process to run for every time slice.
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class HighestPriorityFirstPreemptive extends ProcessSimStrategy {

    private Map<Process, Integer> agingMap = new TreeMap<Process, Integer>();
    Process lastprocess = null;

    HighestPriorityFirstPreemptive(List<Process> processes, float quanta) {
        super(processes, quanta);
    }

    /**
     * Process chooser for every time slice
     * @return the process out of list with lowest priority value
     */
    Process chooseProcess(LinkedList<Process> arrivedqueue) {
        //iterate through queue to get process with highest priority.
        if(!arrivedqueue.contains(lastprocess) && lastprocess != null){
                agingMap.remove(lastprocess);
            }
        Process shortest = arrivedqueue.getFirst();
        for (Process process : arrivedqueue) {
            if (process.priority < shortest.priority) {
                shortest = process;
            }
        }
        lastprocess = shortest;
        aging(arrivedqueue,shortest);
        return shortest;
    }

    void aging(LinkedList<Process> arrivedqueue, Process lastprocess) {
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
