import java.util.Calendar;
import java.util.List;

public interface MedicalDAO {

	public Doctor findDoctorByName(String name);
	public List<Doctor> findDoctorsBySpecialty(String specialty);
	public Patient findPatient(String name, Calendar dob);
	public void removeDoctor(int id);
	public void removePatient(int id);
	public void createDoctor(Doctor doc);
	public void createPatient(Patient pat);
	public void createAppointment(Appointment app);
	public void createPrescription(Prescription pre);
	public void removeAppointment(int id);
	
}
