/**
 * Process
 * holds process states, characteristics, and machine instructions
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
class Process implements Comparable
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
	 * makes a process
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

    @Override
    public int compareTo(Object o) {
        Process temp = (Process) o;
        if(temp.processid == processid) return 0;
        else return 1;
    }
}
