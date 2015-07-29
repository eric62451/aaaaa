import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Member extends fcks{
	
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "join_table",
    joinColumns = {@JoinColumn(name="member_id")},
    inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
	private List<Project> projects;
	
	public Member()
	{
		projects = new ArrayList<Project>();
	}

	
	
	public List<Project> getProjects()
	{ return projects;}
	
	public void setProject(Project project) {
		projects.add(project);
	}

}

