import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Ager class for implementing aging functionality that increases priority.
 * @author David Hsu, Eric Tam, Gary Seto
 */
class Ager
{
	//age to reach to advance to next higher priority
	static int AGE_TO_ADVANCE = 5;
	//map that contains process -> age
	static Map<Process, Integer> ageMap = new HashMap<Process, Integer>();

	/**
	 * Ager function that ages the inactive processes on arrivedqueue,
	 * increasing their priority if their age reaches a certain time.
	 * @param arrivedqueue the process queue to manipulate
	 * @param lastprocess the process that was last run (previous quantum)
	 */
	static void age(LinkedList<Process> arrivedqueue, Process lastprocess)
	{
		//1. Add and increase age of each process in the Age Map
		for (Process process : arrivedqueue)
                        if (process.priority > 1 && ageMap.containsKey(process) && process != lastprocess){
                            ageMap.put(process, ageMap.get(process) + 1);
                            if (ageMap.get(process) >= AGE_TO_ADVANCE)
				{
					if (process.priority > 1)
						process.priority--;
					ageMap.put(process, 0);
				}
                        } else if (!ageMap.containsKey(process) && process.priority > 1)
				ageMap.put(process, 1);

		//2. Remove map's processes no longer on queue.
		if (lastprocess.arriveleft <= 1)
			ageMap.remove(lastprocess);
	}
}
