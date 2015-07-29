import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tester for running processes with a specified running strategy
 *
 * @author David Hsu, Eric, Gary Seto
 *
 */
class ProcessTester
{
	/*
	 * number of time slices to run for
	 */
	static float QUANTA = 100;
	/* processes file for debugging purposes; each line has the following:
	 *
	 * -process ID
	 * -arrival time
	 * -burst time
	 *
	 * separated by commas.
	 */
	static String PROCESSES_FILE = "processes.txt";

	//Static final constants for process generation
	public static final int NUMBEROFPROCESSES = 25;
	public static final String PROCESSNAMESTRING = "ABCDEFGHIJKLMONPQRSTUVWXYZ";
	public static final float ARRIVALTIMEMIN = 0;
	public static final float ARRIVALTIMEMAX = 99;
	public static final float BURSTTIMEMIN = 1;
	public static final float BURSTTIMEMAX = 10;
	public static final int PRIORITYMIN = 1;
	public static final int PRIORITYMAX = 4;
	public static final String[] STRATEGIES =
	{ "FCFS", "SRT", "HPF-NP", "HPF-P", "SJF", "RR" };
        public static final Average[] avgData = new Average[STRATEGIES.length];
        public static ProcessSimStrategy strategy;

	//runtime variables
	List<Process> processes;

	public static void main(String[] args)
	{
		/*
		 * Running strategy can be either:
		 *
		 * FCFS - first come first served
		 * SRT - Shortest remaining time
		 * HPF - highest priority first, preemptive
		 * HPF-NP - highest priority first, non-preemptive
		 * SJF - Shortest Job First
		 * RR - round robin
		 */
		new ProcessTester().test(30); //test 30 runs
	}

	/**
	 * constructor for tester
	 */
	ProcessTester()
	{
		//make list of processes to pass to strategy
		processes = new ArrayList<Process>();
	}

	/**
	 * Debug version test. Reads in file and strategy and runs once.
	 */
	void test(String strategy)
	{
		readFile();
		printProcessesInfo();
		runStrategy(strategy);
	}

	/**
	 * Actual test. Tests each strategy. If have tested each strategy, test 
	 * from first again.
	 * @param times times to run
	 */
	void test(int times)
	{
		int strategyidx = -1;
                for(int i = 0; i<avgData.length;i++){
                    avgData[i] = new Average(0,0,0,0);
                }
		for (int i = 0; i < times; i++)
		{
			generateProcesses();
			printProcessesInfo();
			runStrategy(STRATEGIES[strategyidx =
				(strategyidx + 1) % STRATEGIES.length]);
                        Average temp = strategy.getAverage();
                        avgData[(strategyidx) % STRATEGIES.length].totalAverageThroughput += temp.totalAverageThroughput;
                        avgData[(strategyidx) % STRATEGIES.length].totalAverageresponse += temp.totalAverageresponse;
                        avgData[(strategyidx) % STRATEGIES.length].totalAverageturnaround += temp.totalAverageturnaround;
                        avgData[(strategyidx) % STRATEGIES.length].totalAveragewait += temp.totalAveragewait;
		}
                for (int i = 0; i<STRATEGIES.length;i++){
                    System.out.println("Strategy: "+STRATEGIES[i]);
                    System.out.println("Average wait: " + avgData[i].totalAveragewait/(times/STRATEGIES.length)
			+ " quanta | Average turnaround: " + avgData[i].totalAverageturnaround/(times/STRATEGIES.length)
			+ " quanta | Throughput: " + avgData[i].totalAverageThroughput/(times/STRATEGIES.length)
			+ " runs/quantum | Average response:" + avgData[i].totalAverageresponse/(times/STRATEGIES.length));
                }
	}

	/**
	 * print initial processes info
	 */
	void printProcessesInfo()
	{
		System.out.println("Running with processes:");
		System.out.println("================================================= ");
		System.out.println("Process ID | Arrival Time | Burst time | Priority ");
		for (Process process : processes)
			System.out.printf(process.processid + "\t\t" + "%.2f" + "\t\t"
				+ "%.2f" + "\t\t" + "%d" + "\n", process.arrivaltime,
				process.bursttime, process.priority);
		System.out.println("================================================= ");
	}

	/**
	 * read in processes info to create processes
	 */
	void readFile()
	{
		try
		{
			BufferedReader reader =
				new BufferedReader(new FileReader(PROCESSES_FILE));
			String currentline;
			while ((currentline = reader.readLine()) != null)
			{
				String lineparts[] = currentline.split(",");
				char processid = lineparts[0].charAt(0);
				float arrivaltime = new Float(lineparts[1]);
				float bursttime = new Float(lineparts[2]);
				int priority = new Integer(lineparts[3]);
				Process process =
					new Process(processid, arrivaltime, bursttime, priority);
				processes.add(process);
			}
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * randomly generate processes
	 */
	void generateProcesses()
	{
		for (int processidx = 0; processidx < NUMBEROFPROCESSES; processidx++)
		{
			char processid = PROCESSNAMESTRING.charAt(processidx % 26);
			float arrivaltime =
				(float) (ARRIVALTIMEMIN + Math.random()
					* (ARRIVALTIMEMAX - ARRIVALTIMEMIN));
			float bursttime =
				(float) (BURSTTIMEMIN + Math.random()
					* (BURSTTIMEMAX - BURSTTIMEMIN));
			int priority =
				PRIORITYMIN
					+ Math
						.round((float) Math.random() * (PRIORITYMAX - PRIORITYMIN));
			Process process =
				new Process(processid, arrivaltime, bursttime, priority);
			processes.add(process);
		}
	}

	/**
	 * run strategy using given strategy
	 * @param mode
	 */
	void runStrategy(String mode)
	{
		//print the strategy we're using to console
		System.out.println("Results of " + mode + " run:");

		//get strategy we asked for
		strategy = null;
		switch (mode)
		{
		case "FCFS":
			strategy = new FirstComeFirstServed(processes, QUANTA);
			break;
		case "SRT":
			strategy = new ShortestRemainingTime(processes, QUANTA);
			break;
		case "RR":
			strategy = new RoundRobin(processes, QUANTA);
			break;
		case "HPF":
			strategy = new HighestPriorityFirstP(processes, QUANTA);
			break;
		case "HPF-NP":
			strategy = new HighestPriorityFirstNP(processes, QUANTA);
			break;
		case "HPF-P":
			strategy = new HighestPriorityFirstP(processes, QUANTA);
			break;
		case "SJF":
			strategy = new ShortestJobFirst(processes, QUANTA);
			break;
		}
		strategy.run(); //run the processes
	}
}
