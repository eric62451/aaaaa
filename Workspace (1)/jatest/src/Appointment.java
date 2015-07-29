import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Appointment")
public class Appointment {
	private int aID;
	//private Patient p;
	private Calendar date;
	private Doctor d;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getaID() {
		return aID;
	}
	
	public void setaID(int aID) {
		this.aID = aID;
	}
	
	/*//@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Patient.class)
	//@JoinColumn(name="id")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinTable(name="join_table",
	joinColumns={@JoinColumn(name="id")},
	inverseJoinColumns={@JoinColumn(name="id")})
	
	public Patient getPatient() {
		return p;
	}
	public void setPatient(Patient pt) {
		this.p = pt;
	}*/
	
	@Column(name="aptDate")
	@Temporal (TemporalType.DATE)
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Doctor.class)
	@JoinColumn(name="id")
	public Doctor getDoctor() {
		return d;
	}
	public void setDoctor(Doctor doc) {
		this.d = doc;
	}
}