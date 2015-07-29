import javax.persistence.*;

@Entity
@Table(name="PRESCRIPTION_INFO")
public class Prescription {
	private String medicationName;
	private String doctorName;
	
	private int id;
	private Patient patient;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Patient_id")
	public Patient getPatient(){
		return patient;
	}
	public void setPatient(Patient a){
		patient = a;
	}
	

}
