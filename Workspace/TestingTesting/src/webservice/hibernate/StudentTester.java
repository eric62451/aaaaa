package webservice.hibernate;

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

		Product pone = new Product("a",1);
		Product ptwo = new Product("b", 5.4);
		Cart oone = new Cart();
		Customer cone = new Customer("aa");
		Customer ctwo = new Customer("bb");
		oone.setCustomer(cone);
		oone.addProduct(pone);

		Session session = null;
		Transaction transaction = null;

		// sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			session.save(cone);
//			session.save(ctwo);
			session.save(oone);
			//session.save(otwo);

			//session.save(anotherStudent);
			//session.save(a);
			//session.save(c);
			// session.save(notherStudent);
			// session.evict(anotherStudent); // detached during the transaction
			
			transaction.commit();
			transaction = session.beginTransaction();
			Cart otwo = new Cart();
			otwo.addProduct(pone);
			otwo.addProduct(ptwo);
			otwo.setCustomer(ctwo);
			session.save(otwo);
			transaction.commit();
			session.close();
			sessionFactory.close();
//			session.close();
//			sessionFactory.close();
			/*
			 * } catch (HibernateException he) { transaction.rollback();
			 * System.out.println("Transaction is rolled back.");
			 */
			} finally {
			
		}

		/*try {
			//sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Patient newlyCreated = (Patient) session.get(Patient.class, 2);
			//session.delete(newlyCreated);
			Prescription pre = (Prescription) session.get(Prescription.class, 1);
//			transaction.commit();
//			transaction = session.beginTransaction();
			//System.out.println(pre.getDoctor().getName());
			Doctor newly = (Doctor) session.get(Doctor.class,1);
			List<Prescription> b = newly.getPrescriptions();
			List<Appointment> d = newly.getAppointments();
			System.out.println(newly.getAppointments().isEmpty());
			for(Prescription i:b){
				System.out.println(i.getDoctor().getName());
			}
			for(Appointment i:d){
				System.out.println(i.getDoctor().getName());
			}
			//session.save(newlyCreated);

			transaction.commit(); // if you comment this out, no tuple is
				// created in db.

		}
		 //Didn't catch the exception on purpose to see it.
		finally {
			session.close();
			sessionFactory.close();
		}*/

	}

}
