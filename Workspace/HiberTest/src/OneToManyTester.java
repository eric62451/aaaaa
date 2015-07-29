import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyTester {
	private static SessionFactory sessionFactory; 
	 public static void main(String[] args) {  
		  
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
	        Session session = sessionFactory.openSession();  
	        session.beginTransaction();  
	          
	        Team team = new Team("Barcelona");  
	        Set<Player> players = new HashSet<Player>();  
	          
	        Player p1 = new Player("Messi");  
	        Player p2 = new Player("Xavi");  
	          
	        p1.setTeam(team);  
	        p2.setTeam(team);  
	          
	        players.add(p1);  
	        players.add(p2);  
	          
	        team.setPlayers(players);  
	          
	        session.save(team);  
	          
	        session.getTransaction().commit();  
	          
	        session.close();  
	        sessionFactory.close();
	  
	    }  

}

