import java.util.LinkedList;
import java.util.List;

/**
 * Shortest Job First strategy
 * algorithm runs the process with lowest burst time for every time slice
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class ShortestJobFirst extends ProcessSimStrategy
{
	Process lastprocess; //remember last process ran til it's over

	ShortestJobFirst(List<Process> processes, float quanta)
	{
		super(processes, quanta);
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list with lowest burst time value
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		//if it's the first time quanta or if process last run was complete
		if (lastprocess == null || !arrivedqueue.contains(lastprocess))
		{
			//find process with shortest burst time in queue.
			Process shortest = arrivedqueue.getFirst();
			for (Process process : arrivedqueue)
				if (process.bursttime < shortest.bursttime)
					shortest = process;
			lastprocess = shortest;
			return shortest;
		}
		//else keep running last process ran
		return lastprocess;
	}
}
