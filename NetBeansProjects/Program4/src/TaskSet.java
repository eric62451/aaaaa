
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class TaskSet {

    ArrayList<Node> arrayNode = new ArrayList<Node>();
    //Set checked = new TreeSet<Node>();
    Stack<Node> checked = new Stack<Node>();
    int over = 0;
    ArrayList<Node> tempo = new ArrayList<Node>();
    Node from = new Node(0);

    public void addTask(int n) {
        arrayNode.add(new Node(n));
    }

    public void addConstraint(int i, int j) {
        arrayNode.get(i).precede.add(arrayNode.get(j));
        tempo.clear();
        /*
        int temp = arrayNode.get(j).start + arrayNode.get(j).run;
        if(temp > arrayNode.get(i).start) arrayNode.get(i).start = temp;
        LoopHelper(new ArrayList<Node>(Arrays.asList(arrayNode.get(i))));
        checked.clear();
        Queue<Node> a = new LinkedList<Node>();
        a.add(arrayNode.get(i));
        while(!a.isEmpty()){
        for(Node b : arrayNode){
        if(b.precede.contains(a.peek()) && b.start != -1){
        if(a.peek().start == -1){
        b.run = -1;
        b.start = -1;
        a.add(b);
        } else{
        temp = a.peek().start + a.peek().run;
        if(temp > b.start && b.start != -1){
        b.start = temp;
        a.add(b);
        }
        }
        }
        }
        a.remove();
        }
         */
    }

    public int minCompletionTime() {
        //tempo = new ArrayList<Node>();
        int time = 0;
        int temp;
        for (Node i : arrayNode) {
            if(!tempo.contains(i)){
            LoopHelper(new ArrayList<Node>(Arrays.asList(i)));
            over = 0;
            checked.clear();
            }
            temp = i.run + i.start;
            if (temp < 0) {
                //tempo = null;
                return -1;
            }
            if (time < temp) {
                time = temp;
            }
        }
        //tempo = null;
        return time;
    }

    public int getStartTime(int n) {
        LoopHelper(new ArrayList<Node>(Arrays.asList(arrayNode.get(n))));
        over = 0;
        checked.clear();
        return arrayNode.get(n).start;
    }

    public ArrayList<Node> loopChecker(Node i) {
        /*
        if(checked.contains(i)) return;
        Node temp = arrayNode.get(i);
        for(Node n : temp.precede){
        if(n == temp)
         */
        if(!tempo.contains(i)) tempo.add(i);
        if (checked.contains(i) != false) {
            Object[] temp = checked.toArray();
            for (Object n : checked) {
                ((Node) n).run = -1;
                ((Node) n).start = -1;
            }
            checked.push(new Node(0));
            return new ArrayList<Node>();
        }
        checked.push(i);
        return i.precede;
    }

    public void LoopHelper(ArrayList<Node> i) {
        if (i.isEmpty()) {
            Node a = (Node) checked.pop();
            int temp = a.run + a.start;
            if(temp>over - from.run) {
                over = temp;
                from = a;
            }
            return;
        }
        for (Node n : i) {
            if(tempo.contains(n) && !checked.contains(n)){
                //over = (n.run<0)? -1 : (n.run + n.start);
                int temp = n.run + n.start;
                if(over-from.run<=temp) over = temp;
                if(n.run<0) over = -1;
            }else {
            if (over != -1) {
                LoopHelper(loopChecker(n));
                if (!n.precede.isEmpty() && (over > n.start || over == -1) && n.start != -1) {
                    n.start = over;
                    if(over == -1) n.run = -1;
                    if(over != -1) {
                        over = n.start + n.run;
                        from = n;
                    }
                    checked.pop();
                } if(n.start + n.run > over && over != -1) {
                    over = n.start + n.run;
                    from = n;
                }
            } /*else if(!checked.contains(n)){

            } else {
                n.run = -1;
                n.start = -1;
            }*/
        }
        }
    }
}

class Node {

    ArrayList<Node> precede;
    int start;
    int run;

    public Node(int n) {
        precede = new ArrayList<Node>();
        run = n;
        start = 0;
    }
}
