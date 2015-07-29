/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Job implements Comparable{
    private String phrase;
    private int number;
    public int compareTo(Object o) {
        Job a = (Job) o;
        if(number > a.getValue()) return 1;
        if(number < a.getValue()) return -1;
        else return 0;
    }

    public int getValue(){
        return number;
    }

    public Job(String a, int b){
        number = b;
        phrase = a;
    }

    @Override
    public String toString() {
        return "\"" + phrase +" "+ number + "\"";
    }

     public static void main(String args[]){
         Heap a = new Heap();
         Heap b = new Heap();
         a.insert(new Job("first", 7));
     }
}
