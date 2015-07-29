import java.util.Calendar;
import java.util.List;

import org.hibernate.*;


public class ConcreteMedicalDAO implements MedicalDAO{
	
	private Session session;
	
	public ConcreteMedicalDAO(Session session) {
		this.session = session;
	}
	
	@Override
	public void createDoctor(Doctor doc) {
		Transaction transaction = session.beginTransaction();
		session.save(doc);
		transaction.commit();
	}
	
	@Override
	public void createPatient(Patient pat) {
		Transaction transaction = session.beginTransaction();
		session.save(pat);
		transaction.commit();
	}
	
	@Override
	public Doctor findDoctorByName(String name) {
		Query q = session.getNamedQuery("Doctor.findByName").setString("name", name);
		if(q.list().isEmpty()) return null;
		else return (Doctor) q.list().get(0);
		
	}
	
	@Override
	public List<Doctor> findDoctorsBySpecialty(String specialty) {
		Query q = session.getNamedQuery("Doctor.findBySpecialty").setString("specialty", specialty);
		return q.list();
		
	}
	
	@Override
	public Patient findPatient(String name, Calendar dob) {
		Query q = session.getNamedQuery("Patient.findByNameAndDob").setString("name", name).setCalendar("dob", dob);
		if(q.list().isEmpty()) return null;
		else return (Patient) q.list().get(0);
		
	}
	
	@Override
	public void removeDoctor(int id) {
		Transaction transaction = session.beginTransaction();
		session.clear();
		Doctor temp = (Doctor) session.get(Doctor.class, id);
		session.delete(temp);
		transaction.commit();
	}
	
	@Override
	public void removePatient(int id) {
		Transaction transaction = session.beginTransaction();
		Patient temp = (Patient) session.get(Patient.class, id);
		session.delete(temp);
		transaction.commit();
		
	}
	
	@Override
	public void createAppointment(Appointment app) {
		Transaction transaction = session.beginTransaction();
		session.save(app);
		transaction.commit();
	}
	
	@Override
	public void createPrescription(Prescription pre) {
		Transaction transaction = session.beginTransaction();
		session.save(pre);
		transaction.commit();
	}
	
	@Override
	public void removeAppointment(int id) {
		Transaction transaction = session.beginTransaction();
		session.clear();
		Appointment temp = (Appointment) session.get(Appointment.class, id);
		session.delete(temp);
		transaction.commit();
	}
	
	
}
