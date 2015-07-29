import javax.persistence.*;

@Entity
@Table(name="PERSON_INFO")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Person {
	
	private int id;
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
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
}
