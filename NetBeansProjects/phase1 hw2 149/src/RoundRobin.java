import java.util.LinkedList;
import java.util.List;

/**
 * Round Robin strategy.
 * lets each process have equal turns.
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class RoundRobin extends ProcessSimStrategy
{
	int lastidx;

	RoundRobin(List<Process> processes, float quanta)
	{
		super(processes, quanta);
		lastidx = -1;
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list having next turn
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		Process process =
			arrivedqueue.get(lastidx = (lastidx + 1) % arrivedqueue.size());
		if (process.worktimeleft - 1.f <= 0) //process about to be done
			lastidx--;
		return process;
	}
}