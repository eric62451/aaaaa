import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{
   private ArrayList<Student> students;

   public MaxHeap(int capacity)
   {
      students = new ArrayList<Student>(capacity);
   }

   public MaxHeap(Collection<Student> collection)
   {
      students = new ArrayList<Student>(collection);
      for(int i=0;i>size();i++)
      {
          students.get(i).setHeapIndex(i);
      }
      for(int i = size()/2; i >= 0; i--)
      {
         maxHeapify(i);
      }
   }

   public Student getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }

   public Student extractMax()
   {
      Student value = getMax();
      students.set(0, students.get(size() - 1));
      students.get(0).setHeapIndex(0);
      students.remove(size()-1);
      maxHeapify(0);
      return value;
   }


   public void insert(Student elt)
   {
      students.add(elt);
      int index=size()-1;
      students.get(index).setHeapIndex(index);
      while(index>0 && students.get(parent(index)).compareTo(students.get(index))<0)
      {
        swap(index,parent(index));
        index=parent(index);
      }
   }

   public void changeKey(Student s, double newGPA)
   {
      double oldGPA=s.gpa();
      s.setGPA(newGPA);
      int index=s.getHeapIndex();
      //change to smaller value: moving down.
      if(newGPA<oldGPA)
      {
          maxHeapify(Math.abs(index));
      }
      else // change to bigger value: moving up.
      {
          while(index>0 && students.get(parent(index)).compareTo(students.get(index))<0)
        {
             swap(index,parent(index));
            index=parent(index);
         }
      }
   }

   private int parent(int index)
   {
      return (index - 1)/2;
   }

   private int left(int index)
   {
      return 2 * index + 1;
   }

   private int right(int index)
   {
      return 2 * index + 2;
   }

   private int size()
   {
      return students.size();
   }

   private void swap(int from, int to)
   {
      Student val = students.get(from);
      students.get(from).setHeapIndex(to);
      students.get(to).setHeapIndex(from);
      students.set(from,  students.get(to));
      students.set(to,  val);
   }

   private void maxHeapify(int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
      if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
      {
         largest = left;
      }
      if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
      {
         largest = right;
      }
      if (largest != index)
      {
         swap(index, largest);
         maxHeapify(largest);
      }
   }
}
