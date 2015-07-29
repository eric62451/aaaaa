import java.util.LinkedList;
import java.util.List;

/**
 * Highest Priority First Preemptive strategy
 * algorithm chooses the highest priority process to run for every time slice.
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class HighestPriorityFirstP extends ProcessSimStrategy
{
	Process lastprocess = null;

	HighestPriorityFirstP(List<Process> processes, float quanta)
	{
		super(processes, quanta);
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list with lowest priority value
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		//iterate through queue to get process with highest priority.
		Process highestpriority = arrivedqueue.getFirst();
		for (Process process : arrivedqueue)
			if (process.priority < highestpriority.priority)
				highestpriority = process;
		lastprocess = highestpriority;

		//do aging on all inactive processes on queue.
		Ager.age(arrivedqueue, lastprocess);

		//return highest priority process.
		return highestpriority;
	}
}
