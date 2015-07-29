import javax.persistence.*;

@Entity
@Table(name="Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "field", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Person")
public class Person {
	private String name;
	private int id;
	
	public Person() {
		
	}
	
	public Person(String n) {
		name = n;
	}
	
	@Column(name="Name")
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int i) {
		id = i;
	}
}