import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Member {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Project> getProjects()
	{ return projects;}
	
	public void setProject(Project project) {
		projects.add(project);
	}

}

