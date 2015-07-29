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

		Doctor student = new Doctor();
		student.setName("Lee");

		Patient anotherStudent = new Patient();
		anotherStudent.setName("dead");
		anotherStudent.setDob(new GregorianCalendar(1990,0,30));
		Prescription a = new Prescription();
		a.setMedicationName("shot");
		a.setDoctor(student);
		a.setPatient(anotherStudent);
		anotherStudent.addPrescription(a);
		//anotherStudent.addDoctor(student);
		Appointment c = new Appointment();
		c.setAppDate(new GregorianCalendar(2015,02,03));
		c.setDoctor(student);
		c.setPatient(anotherStudent);
		anotherStudent.addAppointment(c);
		student.addPatient(anotherStudent);
		student.addPrescription(a);
		student.addAppointment(c);
		// anotherStudent.setDoctors(darray);

		// Person notherStudent = new Doctor();
		// notherStudent.setName("mith");
		// student.setPatient(anotherStudent);

		Session session = null;
		Transaction transaction = null;

		// sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(student);
			student.setSpecialty("abc");

			//session.save(anotherStudent);
			//session.save(a);
			//session.save(c);
			// session.save(notherStudent);
			// session.evict(anotherStudent); // detached during the transaction

			transaction.commit();
//			session.close();
//			sessionFactory.close();
			/*
			 * } catch (HibernateException he) { transaction.rollback();
			 * System.out.println("Transaction is rolled back.");
			 */
			} finally {
			session.close();
			//sessionFactory.close();
		}

		try {
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
		}

	}

}
