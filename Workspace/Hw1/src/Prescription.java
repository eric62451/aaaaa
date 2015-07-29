import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PRESCRIPTION_INFO")
public class Prescription {
	private String medicationName;
	//private String doctorName;
	private Patient patient;
	private Doctor doctor;
	private int id;
	
	public Prescription() {
		// TODO Auto-generated constructor stub
	}
	
	public Prescription(String medication, Doctor doc, Patient pat) {
		doctor = doc;
		medicationName = medication;
		patient = pat;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "MedicationName")
	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	@ManyToOne
	@JoinColumn(name="patient_Id")
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@ManyToOne
	@JoinColumn(name="doctor_Id")
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
