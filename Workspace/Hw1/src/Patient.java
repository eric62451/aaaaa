import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import java.util.*;


@Entity
@NamedQuery(name = "Patient.findByNameAndDob", query = "from Patient where name = :name AND dob = :dob")
public class Patient extends Person{
	
	private List<Doctor> doctors;
	private Calendar dob;
	private List<Prescription> prescriptions;
	private List<Appointment> appointments;
	
	public Patient(String name, Calendar dob) {
		super.setName(name);
		this.dob = dob;
		doctors = new ArrayList<Doctor>();
		prescriptions = new ArrayList<Prescription>();
		appointments = new ArrayList<Appointment>();
	}
	
	public Patient() {
		doctors = new ArrayList<Doctor>();
		prescriptions = new ArrayList<Prescription>();
		appointments = new ArrayList<Appointment>();
	}
	
	@Type(type="calendar_date")
	public Calendar getDob(){
		return dob;
	}
	public void setDob(Calendar dob) {
		this.dob = dob;
	}
	
	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
	//@JoinTable(name="patient_prescription",joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "prescription_id"))
	public List<Prescription> getPrescriptions(){
		return prescriptions;
	}
	public void setPrescriptions(List<Prescription> a){
		prescriptions = a;
	}
	
	public void addPrescription(Prescription a){
		prescriptions.add(a);
	}
	
	@ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.REFRESH})
	@JoinTable(name="Doctor_Patient", joinColumns={@JoinColumn(name="patient_id")}, inverseJoinColumns={@JoinColumn(name="doctor_id")})
	public List<Doctor> getDoctors(){
		return doctors;
	}
	public void setDoctors(List<Doctor> a){
		doctors = a;
	}
	
	public void addDoctor(Doctor a){
		doctors.add(a);
	}
	
	@OneToMany(mappedBy="patient", cascade = CascadeType.ALL)
	//@JoinTable(name="patient_appointment",joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "appointment_id"))
	public List<Appointment> getAppointments(){
		return appointments;
	}
	public void setAppointments(List<Appointment> a){
		appointments = a;
	}
	
	public void addAppointment(Appointment a){
		appointments.add(a);
	}
	
	@Override
	public String toString() {
		String temp = "Patient Name: "+getName()+", DOB: "+(dob.get(2)+1)+"/"+dob.get(5)+"/"+dob.get(1) +", ID: "+getId();
		if(!doctors.isEmpty()){
			temp = temp + ", doctors: "+ doctors.get(0).getName();
			for(int i = 1; i<doctors.size();i++){
				temp = temp + ", "+doctors.get(i).getName();
			}
		}
		if(!appointments.isEmpty()){
			temp = temp + "\nAppointment dates:";
			for(int i = 0; i<appointments.size();i++){
				temp = temp + "\n"+String.format("%02d",appointments.get(i).getAppDate().get(2)+1)+"/"+String.format("%02d",appointments.get(i).getAppDate().get(5))+"/"+String.format("%04d",appointments.get(i).getAppDate().get(1)) + " with Doctor "+appointments.get(i).getDoctor().getName();
			}
		}
		if(!prescriptions.isEmpty()){
			temp = temp + "\nPrescriptions:";
			for(int i = 0; i<prescriptions.size();i++){
				temp = temp + "\n" + prescriptions.get(i).getMedicationName() + " Assigned by Doctor "+ prescriptions.get(i).getDoctor().getName();
			}
		}
		return temp;
	}
}
