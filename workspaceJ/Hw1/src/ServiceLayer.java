/*
 * Eric Tam
 * 007989423
 * CS157B
 * Hw1
 */
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.*;


public class ServiceLayer {
	SessionFactory sessionFactory;
	Session session;
	MedicalDAO dao;
	
	public ServiceLayer() {
		Doctor done = new Doctor("Lee", "neurology");
		Doctor dtwo = new Doctor("Ron", "Cardio");
		Doctor dthree = new Doctor("Harry", "pathology");
		Doctor ddum = new Doctor("dummy", "nothing");
		
		Patient pone = new Patient("John", new GregorianCalendar(1990,01,28));
		Patient ptwo = new Patient("erica", new GregorianCalendar(1990,04,15));
		Patient pthree = new Patient("vanessa", new GregorianCalendar(1970,03,10));
		Patient pfour = new Patient("Jessica", new GregorianCalendar(1987,07,05));
		Patient pdum = new Patient("dumdum", new GregorianCalendar(2015,01,01));
		
		Prescription preone = new Prescription();
		preone.setMedicationName("shot");
		preone.setDoctor(done);
		preone.setPatient(pone);
		done.addPrescription(preone);
		pone.addPrescription(preone);
		Prescription pretwo = new Prescription();
		pretwo.setMedicationName("pill");
		pretwo.setDoctor(dtwo);
		pretwo.setPatient(ptwo);
		dtwo.addPrescription(pretwo);
		ptwo.addPrescription(pretwo);
		Prescription prethree = new Prescription();
		prethree.setMedicationName("Chocolate");
		prethree.setDoctor(done);
		prethree.setPatient(pthree);
		done.addPrescription(prethree);
		pthree.addPrescription(prethree);
		Prescription prefour = new Prescription();
		prefour.setMedicationName("vacine");
		prefour.setDoctor(dthree);
		prefour.setPatient(pthree);
		dthree.addPrescription(prefour);
		pthree.addPrescription(prefour);
		Prescription prefive = new Prescription();
		prefive.setMedicationName("band aid");
		prefive.setDoctor(dtwo);
		prefive.setPatient(pfour);
		dtwo.addPrescription(prefive);
		pfour.addPrescription(prefive);
		Prescription presix = new Prescription();
		presix.setMedicationName("cream");
		presix.setDoctor(dthree);
		presix.setPatient(pfour);
		dthree.addPrescription(presix);
		pfour.addPrescription(presix);
		
		Appointment appone = new Appointment();
		appone.setAppDate(new GregorianCalendar(2015,01,20));
		appone.setDoctor(done);
		appone.setPatient(pone);
		done.addAppointment(appone);
		pone.addAppointment(appone);
		Appointment apptwo = new Appointment();
		apptwo.setAppDate(new GregorianCalendar(2015,01,21));
		apptwo.setDoctor(dtwo);
		apptwo.setPatient(ptwo);
		dtwo.addAppointment(apptwo);
		ptwo.addAppointment(apptwo);
		Appointment appthree = new Appointment();
		appthree.setAppDate(new GregorianCalendar(2015,11,21));
		appthree.setDoctor(done);
		appthree.setPatient(pthree);
		done.addAppointment(appthree);
		pthree.addAppointment(appthree);
		Appointment appfour = new Appointment();
		appfour.setAppDate(new GregorianCalendar(2015,02,15));
		appfour.setDoctor(dthree);
		appfour.setPatient(pthree);
		dthree.addAppointment(appfour);
		pthree.addAppointment(appfour);
		Appointment appfive = new Appointment();
		appfive.setAppDate(new GregorianCalendar(2016,02,15));
		appfive.setDoctor(dtwo);
		appfive.setPatient(pfour);
		dtwo.addAppointment(appfive);
		pfour.addAppointment(appfive);
		Appointment appsix = new Appointment();
		appsix.setAppDate(new GregorianCalendar(2015,11,15));
		appsix.setDoctor(dthree);
		appsix.setPatient(pfour);
		dthree.addAppointment(appsix);
		pfour.addAppointment(appsix);
		
		done.addPatient(pone);
		done.addPatient(pthree);
		dtwo.addPatient(ptwo);
		dtwo.addPatient(pfour);
		dthree.addPatient(pthree);
		dthree.addPatient(pfour);
		
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		dao = new ConcreteMedicalDAO(session);
		
		session.save(done);
		session.save(dtwo);
		session.save(dthree);
		session.save(ddum);
		session.save(pdum);


		transaction.commit();
		session.clear();
		
	}
	
	public void close(){
		session.close();
		sessionFactory.close();
	}
	
	public void createDoc(String name, String specialty){
		Doctor temp = new Doctor(name, specialty);
		dao.createDoctor(temp);
		session.clear();
	}
	
	public String viewDoctorByName(String name){
		Doctor temp = dao.findDoctorByName(name);
		if(temp == null) return "Doctor Account not found";
		return temp.toString();
	}
	
	public String viewDoctorBySpecialty(String specialty){
		List<Doctor> temp = dao.findDoctorsBySpecialty(specialty);
		if(!temp.isEmpty()){
			String ret = "";
			for(Doctor a:temp){
				ret = ret+a.toString()+"\n";
			}
			return ret;
		}
		return "No doctor found";
	}
	
	public void deleteDoctor(String name){
		Doctor temp = dao.findDoctorByName(name);
		if(temp != null) dao.removeDoctor(temp.getId());
	}
	
	public void createPat(String name, String dob){
		String[] day = dob.split("/");
		Patient temp = new Patient(name, new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1])));
		dao.createPatient(temp);
		session.clear();
	}
	
	public String viewPatientByNameAndDob(String name, String dob){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		Patient temp = dao.findPatient(name, dateofb);
		if(temp == null) return "Patient not Found";
		return temp.toString();
	}
	
	public void deletePatient(String name, String dob){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		Patient temp = dao.findPatient(name, dateofb);
		if(temp != null) dao.removePatient(temp.getId());
	}
	
	public String createAppointment(String appDate, String pname, String dob, String dname){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		String[] appday = appDate.split("/");
		GregorianCalendar appD = new GregorianCalendar(Integer.parseInt(appday[2]),Integer.parseInt(appday[0])-1,Integer.parseInt(appday[1]));
		Patient pat = dao.findPatient(pname, dateofb);
		if(pat == null){
			session.clear();
			return "Patient does not exist";
		}
		Doctor doc = dao.findDoctorByName(dname);
		if(doc == null){
			session.clear();
			return "Doctor does not exist";
		}
		Appointment temp = new Appointment(appD, doc, pat);
		dao.createAppointment(temp);
		session.clear();
		return "Appointment Created";
	}
	
	public String createPrescription(String medicationName, String pname, String dob, String dname){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		Patient pat = dao.findPatient(pname, dateofb);
		if(pat == null){
			session.clear();
			return "Patient does not exist";
		}
		Doctor doc = dao.findDoctorByName(dname);
		Prescription temp = new Prescription(medicationName,doc,pat);
		dao.createPrescription(temp);
		return "Prescription Created";
	}
	
	public String viewPatientAppointments(String name, String dob){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		Patient temp = dao.findPatient(name, dateofb);
		List<Appointment> applist = temp.getAppointments();
		if(applist.isEmpty()){
			session.clear();
			return "No Appointment Available";
		} else {
			String ret = "Appointments:";
			for(Appointment a:applist){
				ret = ret +"\n"+ String.format("%02d",a.getAppDate().get(2)+1)+"/"+String.format("%02d",a.getAppDate().get(5))+"/"+String.format("%04d",a.getAppDate().get(1)) + " with Doctor "+a.getDoctor().getName();
			}
			session.clear();
			return ret;
		}
		
	}
	
	public String viewPatientInformationByNameAndDob(String name, String dob){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		Patient temp = dao.findPatient(name, dateofb);
		if(temp == null) return "Patient not Found";
		return temp.toString().substring(temp.toString().indexOf("Patient"), temp.toString().length());
	}
	
	public String viewPatientPrescriptions(String name, String dob){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		Patient temp = dao.findPatient(name, dateofb);
		List<Prescription> prelist = temp.getPrescriptions();
		if(prelist.isEmpty()){
			session.clear();
			return "No Prescriptions Available";
		} else {
			String ret = "Prescriptions:";
			for(Prescription a: prelist){
				ret = ret + "\n" + a.getMedicationName() + " Assigned by Doctor "+ a.getDoctor().getName();
			}
			session.clear();
			return ret;
		}
		
	}
	
	public void deleteAppointment(String name, String dob, String appDate){
		String[] day = dob.split("/");
		GregorianCalendar dateofb = new GregorianCalendar(Integer.parseInt(day[2]),Integer.parseInt(day[0])-1,Integer.parseInt(day[1]));
		String[] appday = appDate.split("/");
		GregorianCalendar appD = new GregorianCalendar(Integer.parseInt(appday[2]),Integer.parseInt(appday[0])-1,Integer.parseInt(appday[1]));
		Patient temp = dao.findPatient(name, dateofb);
		List<Appointment> applist = temp.getAppointments();
		int del = -1;
		for(Appointment a: applist){
			if(a.getAppDate().equals(appD)) del = a.getId();
		}
		if(del != -1) dao.removeAppointment(del);
	}
	
	public String viewDoctorInformationByName(String name){
		Doctor temp = dao.findDoctorByName(name);
		if(temp == null) return "Doctor Account not found";
		return "Doctor name: "+ temp.getName()+", Specialty: "+temp.getSpecialty();
	}
}
