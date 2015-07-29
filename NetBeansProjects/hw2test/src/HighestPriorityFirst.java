import java.util.LinkedList;
import java.util.List;

/**
 * Highest Priority First strategy
 * algorithm chooses the highest priority process to run for every time slice.
 * @author David Hsu, Eric, Gary Seto
 *
 */
class HighestPriorityFirst extends ProcessSimStrategy
{
	HighestPriorityFirst(List<Process> processes, float quanta)
	{
		super(processes, quanta);
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list with lowest priority value
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		Process shortest = arrivedqueue.getFirst();
		for (Process process : arrivedqueue)
			if (process.priority < shortest.priority)
				shortest = process;
		return shortest;
	}
}
