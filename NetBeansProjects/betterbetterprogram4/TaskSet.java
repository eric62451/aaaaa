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
    Stack<Node> stack = new Stack<Node>();
    int min_time = 0;
    int updated = -1;

    public void addTask(int n) {
        arrayNode.add(new Node(n));
        updated = -1;
    }

    public void addConstraint(int i, int j) {
        arrayNode.get(j).outgoings.add(arrayNode.get(i));
        arrayNode.get(i).num_incomings ++;
        updated = -1;
    }

    public void LoopChecker () {
        min_time = -1;
        stack.clear();
        for (Node i : arrayNode) {
            i.in_degree = i.num_incomings;
            if (i.in_degree == 0)
                stack.push(i);
        }
        Node temp;
        while (true) {
            if (stack.empty())
                break;
            temp = stack.pop();
            if (temp.start + temp.run > min_time)
                min_time = temp.start + temp.run;
            for (Node i : temp.outgoings) {
                i.in_degree --;
                if (temp.start + temp.run > i.start)
                    i.start = temp.start + temp.run;
                if (i.in_degree == 0)
                    stack.push(i);
            }
        }
        for (Node i : arrayNode)
            if (i.in_degree != 0) {
                i.start = -1;
                min_time = -1;
            }
        updated = 0;
    }

    public int minCompletionTime() {
        if (updated == -1)
            LoopChecker();
        return min_time;
    }

    public int getStartTime(int n) {
        if (updated == -1)
            LoopChecker();
        return arrayNode.get(n).start;
    }
}

class Node {
    ArrayList<Node> outgoings;
    int start;
    int run;
    int num_incomings;
    int in_degree;

    public Node(int n) {
        outgoings = new ArrayList<Node>();
        run = n;
        start = 0;
        num_incomings = 0;
        in_degree = 0;
    }
}