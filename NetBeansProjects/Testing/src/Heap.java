import java.util.ArrayList;
import java.util.Collection;


public class Heap<E extends Comparable>
{
    private ArrayList<E> values;
    public Heap(){values = new ArrayList<E>();}
    public Heap(Collection<E> c)
    {
        values = new ArrayList<E>(c);
        for(int i = values.size()/2; i >= 0; i--)
            max_heapify(i);
    }

    public E heapMaximum()
    {
        return values.get(0);
    }

    public E heapExtractMax()
    {
        E max = heapMaximum();
        values.set(0, values.get(values.size()-1));
        values.remove(values.size()-1);
        max_heapify(0);
        return max;
    }

    public int size() {return values.size();}

    public void insert(E val)
    {
        int index = values.size();
        values.add(val);
        while(index > 0 && values.get(index).compareTo(values.get(parent(index))) > 0)
        {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int left(int i)
    {
        return 2*i + 1;
    }
    private int right(int i)
    {
        return 2*i + 2;
    }
    private int parent(int i)
    {
        return (i-1)/2;
    }
    private void max_heapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int largest;
        if(l < values.size() && values.get(l).compareTo(values.get(i))>0)
            largest = l;
        else
            largest = i;
        if(r < values.size() && values.get(r).compareTo(values.get(largest))>0)
            largest = r;
        if(largest != i)
        {
            swap(i, largest);
            max_heapify(largest);
        }
    }
    private void swap(int i, int j)
    {
        E tmp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, tmp);
    }

}