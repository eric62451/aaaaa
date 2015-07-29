import java.util.ArrayList;

public class TaskSet {
	boolean updated;
	ArrayList<Node> node;
	int mincomtime;

	public TaskSet() {
		updated = true;
		int mincomtime = 0;
		node = new ArrayList<Node>();
	}

	public void addTask(int x) {
		Node temp = new Node(x);
		node.add(temp);
		if(x > mincomtime)
		{
			mincomtime = x;
		}
	}

	public void addConstraint(int x, int y) {
		updated = false;
		node.get(x).addPre(node.get(y));
	}

	public int getStartTime(int x) {
		return node.get(x).findStart(node.get(x));
	}

	public int minCompletionTime() {

		if(updated == true)
		{
			return mincomtime;
		}
		for (Node list : node) {
			if(list.getThrough() == false)
			{
				list.findStart(list);
			}
			if (list.getComplete() == -1) {
				return -1;
			}
			if (list.getComplete() > mincomtime) {
				mincomtime = list.getComplete();
			}
		}

		return mincomtime;
	}
}

class Node {
	ArrayList<Node> pre;
	int starttime;
	int runtime;
	int completetime;
	int tempcompletetime;
	int tempstarttime;
	boolean getthrough;

	public Node(int x) {
		pre = new ArrayList<Node>();
		runtime = x;
		starttime = 0;
		completetime = x;
		tempcompletetime = x;
		getthrough = false;
	}

	public boolean getThrough()
	{
		return getthrough;
	}

	public void setThrough()
	{
		getthrough = true;
	}
	public void addPre(Node temp) {
		pre.add(temp);
	}

	public void setTempStart(int x) {
		tempstarttime = x;
	}

	public int getTempComplete() {
		return tempcompletetime;
	}

	public void setTempComplete(int x) {
		tempcompletetime = x;
	}

	public int getComplete() {
		return completetime;
	}

	public void setComplete(int x) {
		completetime = x;
	}

	public int getTempStart() {
		return tempstarttime;
	}

	public int getStart() {
		return starttime;
	}

	public int getRun() {
		return runtime;
	}

	public void setStart(int x) {
		starttime = x;
	}

	public ArrayList<Node> getPre() {
		return pre;
	}

	public int findStart(Node finding) {
		if (finding.getStart() == -1) {
			finding.setTempStart(-1);
			return -1;
		}
		if (pre.isEmpty() != true) {

			for (Node list : pre) {


				if (list == finding || list.getStart() == -1
						|| list.getComplete() == -1) {
					finding.setStart(-1);
					finding.setTempStart(-1);
					finding.setComplete(-1);
					finding.setTempComplete(-1);
					list.setTempStart(-1);
					list.setStart(-1);
					list.setComplete(-1);
					list.setTempComplete(-1);
					return -1;
				}

				else {
					finding.setTempComplete(finding.getTempComplete()
							+ list.getRun());
					finding.setTempStart(finding.getTempStart() + list.getRun());
					list.findStart(finding);
					// System.out.println(finding.getTempComplete());


					if (finding.getTempStart() > finding.getStart() && finding.getTempStart() != 0) {
						//System.out.println("before" + finding.getStart());
						finding.setStart(finding.getTempStart());
						//System.out.println("after" + finding.getStart());
					}
					if (finding.getTempComplete() > finding.getComplete() && finding.getTempComplete() != finding.getRun())  {
						// System.out.println("before set " +
						// finding.getComplete());
						finding.setComplete(finding.getTempComplete());
						// System.out.println("after > "
						// +finding.getComplete());
					}
					finding.setTempStart(0);
					finding.setTempComplete(finding.getRun());
				}
			}
		}
		finding.setThrough();
		return finding.getStart();
	}

}