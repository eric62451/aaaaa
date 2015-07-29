/**
 * Process
 * holds Average values of a run
 * @author David Hsu, Eric Tam, Gary Seto
 *
 */
public class Average {
        float totalAverageThroughput = 0;
        float totalAveragewait = 0;
        float totalAverageturnaround = 0;
        float totalAverageresponse = 0;

        Average(float throughput, float averagewait, float averageTurnaround, float averageresponse)
	{
		totalAverageThroughput = throughput;
                totalAveragewait = averagewait;
                totalAverageturnaround = averageTurnaround;
                totalAverageresponse = averageresponse;
	}
}
