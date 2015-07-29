import java.util.LinkedList;
import java.util.List;

/**
 * First Come First Served strategy.
 * Simply chooses the first arrived process to run for every time slice.
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class FirstComeFirstServed extends ProcessSimStrategy
{
	FirstComeFirstServed(List<Process> processes, float quanta)
	{
		super(processes, quanta);
	}

	/**
	 * Process chooser for every time slice
	 * @return the process out of list being first
	 */
	Process chooseProcess(LinkedList<Process> arrivedqueue)
	{
		return arrivedqueue.getFirst();
	}
}
