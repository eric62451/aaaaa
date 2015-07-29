import java.util.LinkedList;
import java.util.List;

/**
 * Highest Priority First Non-preemptive strategy
 * algorithm chooses the highest priority process to run for every time slice.
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class HighestPriorityFirstNP extends ProcessSimStrategy
{

	Process lastprocess; //remember last process ran til it's over

	HighestPriorityFirstNP(List<Process> processes, float quanta)
	{
		super(processes, quanta);
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list with lowest priority value
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		//if it's the first time quanta or if process last run was complete
		if (lastprocess == null || !arrivedqueue.contains(lastprocess))
		{
			//iterate through queue to get process with highest priority.
			Process highestpriority = arrivedqueue.getFirst();
			for (Process process : arrivedqueue)
				if (process.priority < highestpriority.priority)
					highestpriority = process;
			lastprocess = highestpriority;

			//age the queue.
			Ager.age(arrivedqueue, lastprocess);

			//choose the highest priority process
			return highestpriority;
		}

		//age the queue.
		Ager.age(arrivedqueue, lastprocess);

		//keep running last process ran.
		return lastprocess;
	}
}
