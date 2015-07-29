import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManyToManyTester {
	private static SessionFactory sessionFactory; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sessionFactory = HibernateUtil.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
		
	    Project proj1 = new Project();
		proj1.setName("project 1");
		Project proj2 = new Project();
		proj2.setName("project 2");
		Project proj3 = new Project();
		proj3.setName("project 3");
		
		Member m1 = new Member();
		m1.setName("m1");
		Member m2 = new Member();
		m2.setName("m2");
		Member m3 = new Member();
		m3.setName("m3");
		
	
//		proj1.setMember(m1);
//		proj1.setMember(m2);
//		proj1.setMember(m3);
//		
//		proj2.setMember(m2);
//		proj2.setMember(m3);
//		
//	    proj3.setMember(m1);
//	    proj3.setMember(m3);
	    
	    
	    /*
	    m1.setProject(proj1);
	    m1.setProject(proj3);
	    
	    m2.setProject(proj1);
	    m2.setProject(proj2);
	    
	    m3.setProject(proj1);
	    m3.setProject(proj2);
	    m3.setProject(proj3);
	    */
	    
	    session.save(proj1);
	    session.save(proj2);
	    session.save(proj3);
	    
	    
	    System.out.println(m3.getProjects());
	    session.getTransaction().commit();
	    session.close();
	    sessionFactory.close();
		
	}

}

