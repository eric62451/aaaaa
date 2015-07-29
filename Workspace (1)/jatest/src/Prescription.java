import javax.persistence.*;

@Entity
@Table(name="Prescription")
public class Prescription {
	private int prID;
	//private Patient p;
	private String message;
	private Doctor d;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getPrID() {
		return prID;
	}
	public void setPrID(int prID) {
		this.prID = prID;
	}
	
	/*@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Patient.class)
	@JoinColumn(name="birthDate")
	public Patient getPatient() {
		return p;
	}
	public void setPatient(Patient patient) {
		p = patient;
	}*/
	
	@Column(name="message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity=Doctor.class)
	@JoinColumn(name="id")
	public Doctor getDoctor() {
		return d;
	}
	public void setDoctor(Doctor doc) {
		this.d = doc;
	}	
}