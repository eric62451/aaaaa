import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.util.*;


@Entity
@Table(name="patient_info")
@NamedQuery(name = "Patient.findByNameAndSpecialty", query = "from Patient where name = :name AND dob = :dob")
public class Patient extends Person{
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Doctor_Patient", joinColumns={@JoinColumn(name="patient_id")}, inverseJoinColumns={@JoinColumn(name="doctor_id")})
	private List<Doctor> doctors;
	private String dob;
	//private List<Prescription> prescriptions = new ArrayList<Prescription>();
	
	public Patient() {
		doctors = new ArrayList<Doctor>();
	}
	
	public String getDob(){
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/*
	public List<Prescription> getPrescriptions(){
		return prescriptions;
	}
	public void setPrescription(Prescription a){
		prescriptions.add(a);
	}*/
	
	
//	public List<Doctor> getDoctors(){
//		return doctors;
//	}
	public void setDoctor(Doctor a){
		doctors.add(a);
	}
	
}
