/**
 * Process
 * holds process states, characteristics, and machine instructions
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class Process implements Comparable<Process>
{
	//things that user specifies
	char processid;
	int priority;
	float arrivaltime, bursttime;

	//things that are changed by program during run
	float worktimeleft, arriveleft;

	//things determined by program at end of run
	float turnedaroundtime, waitedtime;

	/**
	 * Makes a process
	 * @param processid id of process
	 * @param arrivaltime time that it arrives to queue
	 * @param bursttime time that it takes to finish
	 * @param priority between 1 and 4
	 */
	Process(char processid, float arrivaltime, float bursttime, int priority)
	{
		this.priority = priority;
		this.processid = processid;
		this.arrivaltime = arrivaltime;
		this.bursttime = bursttime;

		worktimeleft = bursttime;
		arriveleft = arrivaltime;

		turnedaroundtime = -1;
		waitedtime = -1;
	}

	/**
	 * Compare to function that tests whether two processes are equal.
	 */
	public int compareTo(Process p)
	{
		return p.processid == processid ? 0 : -1;
	}
}
