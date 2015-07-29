/*
 * Eric Tam
 * 007989423
 * CS157B
 * Hw1
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;


@Entity
@NamedQueries(
		{
@NamedQuery(name = "Doctor.findByName", query = "from Doctor where name = :name"),
@NamedQuery(name = "Doctor.findBySpecialty", query = "from Doctor where specialty = :specialty")
		}
)
public class Doctor extends Person{
	
	private String specialty;
	private List<Prescription> prescriptions;
	private List<Patient> patients;
	private List<Appointment> appointments;
	
	public Doctor(String name, String specialty){
		super.setName(name);
		this.specialty = specialty;
		patients = new ArrayList<Patient>();
		prescriptions = new ArrayList<Prescription>();
		appointments = new ArrayList<Appointment>();
	}
	
	public Doctor() {
		patients = new ArrayList<Patient>();
		prescriptions = new ArrayList<Prescription>();
		appointments = new ArrayList<Appointment>();
	}
	
	public String getSpecialty(){
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	@ManyToMany//(cascade=CascadeType.ALL)
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
	@JoinTable(name="Doctor_Patient", joinColumns={@JoinColumn(name="doctor_id")}, inverseJoinColumns={@JoinColumn(name="patient_id")})
	public List<Patient> getPatients(){
		return patients;
	}
	public void setPatients(List<Patient> a){
		patients = a;
	}
	
	public void addPatient(Patient a){
		patients.add(a);
	}
	
	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL)
	//@JoinTable(name="doctor_prescription",joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "prescription_id"))
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	public void addPrescription(Prescription a){
		prescriptions.add(a);
	}
	
	@OneToMany(mappedBy="doctor", cascade = CascadeType.ALL)
	//@JoinTable(name="doctor_appointment",joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "appointment_id"))
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public void addAppointment(Appointment a){
		appointments.add(a);
	}
	
	@Override
	public String toString() {
		String temp = "ID: "+getId()+", Doctor Name: "+getName()+", Specialty: "+specialty;
		if(!patients.isEmpty()){
			temp = temp + ", Patients: "+ patients.get(0).getName();
			for(int i = 1; i<patients.size();i++){
				temp = temp + ", "+patients.get(i).getName();
			}
		}
		if(!appointments.isEmpty()){
			temp = temp + ", Appointment dates: "+ (appointments.get(0).getAppDate().get(2)+1)+"/"+appointments.get(0).getAppDate().get(5)+"/"+appointments.get(0).getAppDate().get(1);
			for(int i = 1; i<appointments.size();i++){
				temp = temp + ", "+(appointments.get(i).getAppDate().get(2)+1)+"/"+appointments.get(i).getAppDate().get(5)+"/"+appointments.get(i).getAppDate().get(1);
			}
		}
		return temp;
	}
   
}
