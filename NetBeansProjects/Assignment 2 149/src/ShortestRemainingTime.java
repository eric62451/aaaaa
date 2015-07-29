import java.util.LinkedList;
import java.util.List;

/**
 * Shortest Remaining Time Strategy
 * Runs the process with currently fewest work time left for every time slice.
 * @author David Hsu, Eric Tam, Gary Seto
 */
class ShortestRemainingTime extends ProcessSimStrategy
{
	ShortestRemainingTime(List<Process> processes, float quanta)
	{
		super(processes, quanta);
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list with lowest work time left value
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		Process shortest = arrivedqueue.getFirst();
		for (Process process : arrivedqueue)
			if (process.worktimeleft < shortest.worktimeleft)
				shortest = process;
		return shortest;
	}
}