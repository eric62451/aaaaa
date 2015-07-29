import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Project extends fcks{

     
     @ManyToMany(cascade=CascadeType.ALL)
     @JoinTable(name = "join_table",
     joinColumns = {@JoinColumn(name="project_id")},
     inverseJoinColumns = {@JoinColumn(name = "member_id")}
     )
     private List<Member> members;

     public Project()
     { members = new ArrayList<Member> ();}
     
	
	public List<Member> getMembers(){
		return members;
	}
	public void setMember(Member member) {
		members.add(member);
	}
      
}

