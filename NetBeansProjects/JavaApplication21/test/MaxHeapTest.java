import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class MaxHeapTest
{
   private MaxHeap heap;
   private MaxHeap heap2;
   ArrayList<Student> students;


   @Before
   public void setUp() throws Exception
   {
      heap = new MaxHeap(10);
      Student s1 = new Student("Worst", 3, 1.0);
      Student s2 = new Student("best", 0, 4.0);
      Student s3 = new Student("bad", 2, 2.0);
      Student s4 = new Student("good", 1, 3.0);
      heap.insert(s1);
      heap.insert(s2);
      heap.insert(s3);
      heap.insert(s4);
      students= new ArrayList<Student>();
      students.add(s1);
      students.add(s2);
      students.add(s3);
      students.add(s4);
      heap2 = new MaxHeap(students);
   }

   @Test
   public void extraMaxTest()
   {
      assertEquals(4.0, heap.extractMax().gpa(), .000001);
      assertEquals(3.0, heap.extractMax().gpa(), .000001);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void getMaxTest()
   {
      assertEquals(4.0, heap.getMax().gpa(), .000001);
      MaxHeap tempHeap=new MaxHeap(10);
      assertEquals(3.0, tempHeap.extractMax());
   }

   @Test
   public void changeKeyTest()
   {
      heap.changeKey(students.get(2), 4.4);
      assertEquals(4.4, heap.getMax().gpa(), .000001);
      assertEquals("bad", heap.getMax().getName());
      heap.changeKey(heap.getMax(), 2.0);
      assertEquals(4.0, heap.getMax().gpa(), .000001);
      assertEquals("best", heap.getMax().getName());
   }

   @Test
   public void indexTest()
   {
     assertEquals(heap.getMax().getHeapIndex(),0);
     assertEquals(students.get(0).getHeapIndex(),3);
     assertEquals(students.get(1).getHeapIndex(),0);
     assertEquals(students.get(2).getHeapIndex(),2);
     assertEquals(students.get(3).getHeapIndex(),1);
   }

   @Test
   public void compareTest()
   {
     assertEquals(students.get(0).compareTo(heap.getMax()),-1);
     assertEquals(heap.getMax().compareTo(heap.getMax()),0);
     assertEquals(heap.getMax().compareTo(students.get(0)),1);
   }

   public void insertTest()
   {
      heap.insert(new Student("five",123,5.0));
      heap.insert(new Student("nitynine",123,99.9));
      assertEquals(99.9, heap.extractMax().gpa(), .000001);
      assertEquals(5.0, heap.extractMax().gpa(), .000001);
      assertEquals(4.0, heap.extractMax().gpa(), .000001);
   }

}
