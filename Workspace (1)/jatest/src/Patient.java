import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Patient")
public class Patient extends Person {
	private int pId;
	private String patientName;
	private Calendar birthDate;
	private List<Appointment> appointments;
	private List<Prescription> prescriptions;
	private List<Doctor> doctors;
	
	public Patient(String pName, Calendar dob) {
		super(pName);
		birthDate = dob;
	}
	
/*	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	
	@Column(name="Name")
	public String getName() {
		return patientName;
	}
	public void setName(String name) {
		patientName = name;
	}
*/

	@Column(name="birthday")
	@Temporal (TemporalType.DATE)
	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	@OneToMany(mappedBy="aID", targetEntity = Appointment.class, 
			fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	@OneToMany(mappedBy="prID", targetEntity = Prescription.class, 
			fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Doctor_Patient", joinColumns={@JoinColumn(name="patient_id")}, inverseJoinColumns={@JoinColumn(name="doctor_id")})
	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
}