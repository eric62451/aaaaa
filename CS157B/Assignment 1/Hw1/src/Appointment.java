/*
 * Eric Tam
 * 007989423
 * CS157B
 * Hw1
 */
import java.util.Calendar;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name="APPOINTMENT_INFO")
public class Appointment {
	private Calendar appDate;
	private Patient patient;
	private Doctor doctor;
	private int id;
	
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	
	public Appointment(Calendar date, Doctor doc, Patient pat) {
		appDate = date;
		doctor = doc;
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
	
	@Column(name="Date")
	@Type(type="calendar_date")
	public Calendar getAppDate() {
		return appDate;
	}
	public void setAppDate(Calendar a) {
		appDate = a;
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
