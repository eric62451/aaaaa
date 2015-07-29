
import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.*;

public class StudentTester {
    private static SessionFactory sessionFactory; 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

       Doctor student= new Doctor();
       student.setName("Lee");
       
       Patient anotherStudent = new Patient();
       anotherStudent.setName("dead");
       anotherStudent.setDob("02/13/2015");
//       Prescription a = new Prescription();
//       a.setDoctorName("yo");
//       a.setMedicationName("shot");
       //anotherStudent.setPrescription(a);
       //a.setPatient(anotherStudent);
       
       student.setPatients(anotherStudent);
       anotherStudent.setDoctors(student);
       
       //Person notherStudent = new Doctor();
       //notherStudent.setName("mith");
       //student.setPatient(anotherStudent);
       
       Session session = null;
       Transaction transaction= null;
       
      // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
       try
       {
       sessionFactory = HibernateUtil.getSessionFactory();
       session = sessionFactory.openSession();
       transaction = session.beginTransaction();
       
       session.save(student);
       student.setSpecialty("abc");
    
       session.save(anotherStudent);
       //session.save(a);
       //session.save(notherStudent);
       //session.evict(anotherStudent); // detached during the transaction
       
      
       transaction.commit();

      /* }
       catch (HibernateException he)
       {
    	   transaction.rollback();
           System.out.println("Transaction is rolled back.");
       */}
       finally
       {
         session.close();
         sessionFactory.close();
       }
	}

}
