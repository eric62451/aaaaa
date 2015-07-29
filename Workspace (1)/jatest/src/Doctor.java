import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Doctor")
public class Doctor extends Person{
	private int dID; 
	private String doctorName;
	private String speciality;
	private List<Patient> patients;
	
	public Doctor(String d, String spec) {
		super(d);
		speciality = spec;
	}
	
/*	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}
	
	@Column(name="Name")
	public String getName() {
		return doctorName;
	}
	
	public void setName(String name) {
		doctorName = name;
	}*/
	
	@Column(name="Speciality")
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Doctor_Patient", joinColumns={@JoinColumn(name="doctor_id")}, inverseJoinColumns={@JoinColumn(name="patient_id")})
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
}