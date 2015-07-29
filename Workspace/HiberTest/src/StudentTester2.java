


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class StudentTester2 {
    private static SessionFactory sessionFactory; 
    private static Transaction transaction;
    private static Session session; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   sessionFactory = HibernateUtil.getSessionFactory();
    
	   Student student = new Student(); // transient object
       student.setName("Lee"); // only mutates the java object in Heap
       student.setGpa(3.0);
     
      try{
       
       session = sessionFactory.openSession();
       transaction = session.beginTransaction();
       
       session.save(student); // student is now persistent object
       
       student.setGpa(4.5);   // updates on the object will be persisted
       student.setGpa(2.0);
       // session.update(student); // no need
      
       System.out.println("1:" + student);
       System.out.println("2:" + session.get(Student.class, new Integer(1)));
       
      
       session.evict(student); // detached during the transaction
       //session.save(student); // it will create another tuple in db
       session.update(student); //way to go
       student.setGpa(4.5);  
       
       
       transaction.commit(); // if you comment this out, no tuple is created in db. 
      }
       catch (HibernateException he)
       {
           transaction.rollback();
           System.out.println("Transaction is rolled back.");
       }
      finally
      { session.close(); }
      
       // To compare update vs. merge
      
      student.setGpa(3.0);
      
      try{
       session = sessionFactory.openSession();
       transaction = session.beginTransaction();
       Student newlyCreated = (Student) session.get(Student.class,1);
       System.out.println(student);
       System.out.println(newlyCreated);
       student.setName ("Park");
       //session.update(student); //NonUniqueObjectException
       session.merge(student); //modifications done on the detached object student is merged into newlyCreaed. 
       newlyCreated.setGpa(0.0); // will be persisted.
       student.setGpa(8.0); // not persisted since student is detached. 
      
       transaction.commit(); // if you comment this out, no tuple is created in db. 
    
      }
      // Didn't catch the exception on purpose to see it. 
      finally
      { session.close(); 
        sessionFactory.close();
      }
       
      
	}
	
	

}
