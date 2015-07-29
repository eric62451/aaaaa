import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@NamedQueries(
		{
@NamedQuery(name = "Doctor.findByName", query = "from Doctor where name = :name"),
@NamedQuery(name = "Doctor.findByNameAndSpecialty", query = "from Doctor where name = :name AND specialty = :specialty")
		}
)
public class Doctor extends Person{
	
	private String specialty;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Doctor_Patient", joinColumns={@JoinColumn(name="doctor_id")}, inverseJoinColumns={@JoinColumn(name="patient_id")})
	private List<Patient> patients;
	
	public Doctor() {
		patients = new ArrayList<Patient>();
	}
	
	public String getSpecialty(){
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
//	public List<Patient> getPatients(){
//		return patients;
//	}
	public void setPatients(Patient a){
		patients.add(a);
	}
	
	public String toString()
	{   return ""; }
   
}
