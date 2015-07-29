import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Tester {
    private static SessionFactory sessionFactory; 
    
	public static void main(String[] args) {
		
      // sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
       sessionFactory = HibernateUtil.getSessionFactory();
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       
       Doctor d1 = new Doctor("JD", "Sergon");
       Doctor d2 = new Doctor("Jay", "Neurologist");
       
       Patient p1 = new Patient("abc", new GregorianCalendar(2014, 12, 21));       
       Patient p2 = new Patient("Someone", new GregorianCalendar(2014, 6, 11));
       ArrayList<Doctor> d = new ArrayList<>();
       d.add(d1);
       d.add(d2);
       
       p1.setDoctors(d);
       p2.setDoctors(d);
       Appointment ap1 = new Appointment();
       ap1.setDate(new GregorianCalendar(2015, 02, 18));    
       //ap1.setPatient(p1);
       ap1.setDoctor(d1);
       
       session.save(d1);
       session.save(d2);
       session.save(p1);
       session.save(p2);
       session.save(ap1);
       session.getTransaction().commit();
       sessionFactory.close();
	}
}