import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

public class Tester {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		

		Session session = null;
		Transaction transaction = null;
		
		Doctor done = new Doctor("yat", "neurology");
		Doctor dtwo = new Doctor("Yu", "Cardio");
		Doctor dthree = new Doctor("lok", "pathology");
		Doctor ddum = new Doctor("dummy", "doc");
		
		Patient pone = new Patient("candy", new GregorianCalendar(1990,01,28));
		Patient ptwo = new Patient("erica", new GregorianCalendar(1990,04,15));
		Patient pthree = new Patient("vanessa", new GregorianCalendar(1970,03,10));
		Patient pfour = new Patient("Jessica", new GregorianCalendar(1987,07,05));
		Patient pdum = new Patient("dumdum", new GregorianCalendar(2015,01,01));
		
		Prescription preone = new Prescription();
		preone.setMedicationName("shot");
		preone.setDoctor(done);
		preone.setPatient(pone);
		done.addPrescription(preone);
		pone.addPrescription(preone);
		Prescription pretwo = new Prescription();
		pretwo.setMedicationName("pill");
		pretwo.setDoctor(dtwo);
		pretwo.setPatient(ptwo);
		dtwo.addPrescription(pretwo);
		ptwo.addPrescription(pretwo);
		Prescription prethree = new Prescription();
		prethree.setMedicationName("2 in 1");
		prethree.setDoctor(done);
		prethree.setPatient(pthree);
		done.addPrescription(prethree);
		pthree.addPrescription(prethree);
		Prescription prefour = new Prescription();
		prefour.setMedicationName("vacine");
		prefour.setDoctor(dthree);
		prefour.setPatient(pthree);
		dthree.addPrescription(prefour);
		pthree.addPrescription(prefour);
		Prescription prefive = new Prescription();
		prefive.setMedicationName("bandaid");
		prefive.setDoctor(dtwo);
		prefive.setPatient(pfour);
		dtwo.addPrescription(prefive);
		pfour.addPrescription(prefive);
		Prescription presix = new Prescription();
		presix.setMedicationName("cream");
		presix.setDoctor(dthree);
		presix.setPatient(pfour);
		dthree.addPrescription(presix);
		pfour.addPrescription(presix);
		
		Appointment appone = new Appointment();
		appone.setAppDate(new GregorianCalendar(2015,01,20));
		appone.setDoctor(done);
		appone.setPatient(pone);
		done.addAppointment(appone);
		pone.addAppointment(appone);
		Appointment apptwo = new Appointment();
		apptwo.setAppDate(new GregorianCalendar(2015,01,21));
		apptwo.setDoctor(dtwo);
		apptwo.setPatient(ptwo);
		dtwo.addAppointment(apptwo);
		ptwo.addAppointment(apptwo);
		Appointment appthree = new Appointment();
		appthree.setAppDate(new GregorianCalendar(2015,11,21));
		appthree.setDoctor(done);
		appthree.setPatient(pthree);
		done.addAppointment(appthree);
		pthree.addAppointment(appthree);
		Appointment appfour = new Appointment();
		appfour.setAppDate(new GregorianCalendar(2015,02,15));
		appfour.setDoctor(dthree);
		appfour.setPatient(pthree);
		dthree.addAppointment(appfour);
		pthree.addAppointment(appfour);
		Appointment appfive = new Appointment();
		appfive.setAppDate(new GregorianCalendar(2016,02,15));
		appfive.setDoctor(dtwo);
		appfive.setPatient(pfour);
		dtwo.addAppointment(appfive);
		pfour.addAppointment(appfive);
		Appointment appsix = new Appointment();
		appsix.setAppDate(new GregorianCalendar(2015,11,15));
		appsix.setDoctor(dthree);
		appsix.setPatient(pfour);
		dthree.addAppointment(appsix);
		pfour.addAppointment(appsix);
		
		done.addPatient(pone);
		done.addPatient(pthree);
		dtwo.addPatient(ptwo);
		dtwo.addPatient(pfour);
		dthree.addPatient(pthree);
		dthree.addPatient(pfour);
		
		

		// sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			session.save(done);
			session.save(dtwo);
			session.save(dthree);
			session.save(ddum);
			session.save(pdum);


			transaction.commit();

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
			Patient del = (Patient) session.get(Patient.class, 2);
			session.delete(del);
			transaction.commit();
			transaction = session.beginTransaction();
			Prescription pre = (Prescription) session.get(Prescription.class, 2);
			session.delete(pre);
			Doctor doc = (Doctor) session.get(Doctor.class, 1);
			List<Appointment> apps = doc.getAppointments();
			System.out.println(Calendar.DAY_OF_MONTH);
			doc.setName("new");
			transaction.commit();
			MedicalDAO dao = new ConcreteMedicalDAO(session);
			Doctor test = dao.findDoctorByName("new");
			System.out.println(test.getName());
			Patient testtwo = dao.findPatient("vanessa", new GregorianCalendar(1970,3,10));
			System.out.println(testtwo.getName());
			transaction = session.beginTransaction();
			Appointment testing = new Appointment();
			testing.setAppDate(new GregorianCalendar(2000,1,1));
			testing.setDoctor(test);
			testing.setPatient(testtwo);
			session.save(testing);
			transaction.commit();
			transaction = session.beginTransaction();
			org.hibernate.Query q = session.getNamedQuery("Doctor.findByName").setString("name", "yu");
			Doctor yu = (Doctor) session.get(Doctor.class, ((Doctor)q.list().get(0)).getId());
			session.delete(yu);
			transaction.commit();
			Patient eric = dao.findPatient("erica", new GregorianCalendar(1990,4,15));
			System.out.println(eric.getName());
			Calendar aaa = new GregorianCalendar(1000,10,10);
			System.out.println(eric.getDob().equals(new GregorianCalendar(1990,4,15)));
			//session.save(newlyCreated);

			 // if you comment this out, no tuple is
				// created in db.

		}
		 //Didn't catch the exception on purpose to see it.
		finally {
			session.close();
			sessionFactory.close();
		}

	}

}
