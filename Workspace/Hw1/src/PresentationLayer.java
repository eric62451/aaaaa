import java.util.Scanner;

public class PresentationLayer {

	private static ServiceLayer serlay;
	private static Scanner in;

	public static void main(String[] args) {
		serlay = new ServiceLayer();
		in = new Scanner(System.in);
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("\nPlease Choose user type (type Q to quit):");
			System.out.println("[A]dministrator");
			System.out.println("[S]taff");
			System.out.println("[D]octor");
			System.out.println("[P]atient");
			input = in.nextLine();
			if (input.equalsIgnoreCase("a")) Admin();
			else if(input.equalsIgnoreCase("s")) Staff();
			else if(input.equalsIgnoreCase("d")) Doctor();
			else if(input.equalsIgnoreCase("p")) Patient();
		}
		serlay.close();
	}

	public static void Admin() {
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("\nAdministrator - (Type Q to exit administrator):");
			System.out.println("[C]reate Doctor account");
			System.out.println("[V]iew Doctor account");
			System.out.println("[D]elete Doctor account");
			System.out.println("[X] Create Patient account");
			System.out.println("[Y] View Patient account");
			System.out.println("[Z] Delete Patient account");
			input = in.nextLine();
			if(input.equalsIgnoreCase("c")){
				System.out.print("\nPlease enter doctor name:");
				String name = in.nextLine();
				System.out.print("Please enter doctor specialty:");
				String specialty = in.nextLine();
				serlay.createDoc(name, specialty);
				System.out.println("Doctor account created");
			} else if(input.equalsIgnoreCase("v")){
				System.out.println("\nPlease choose options:");
				System.out.println("[N] View doctor account by name");
				System.out.println("[S] View doctors account by specialty");
				input = in.nextLine();
				if(input.equalsIgnoreCase("n")) {
					System.out.print("\nPlease enter doctor name:");
					String name = in.nextLine();
					System.out.println(serlay.viewDoctorByName(name));
				}else if(input.equalsIgnoreCase("s")){
					System.out.print("\nPlease enter doctor specialty:");
					String name = in.nextLine();
					System.out.println(serlay.viewDoctorBySpecialty(name));
				}	
			} else if(input.equalsIgnoreCase("D")){
				System.out.print("\nPlease enter doctor name:");
				String name = in.nextLine();
				serlay.deleteDoctor(name);
				System.out.print("\nDeleted!");
			} else if(input.equalsIgnoreCase("x")){
				System.out.print("\nPlease enter patient name:");
				String name = in.nextLine();
				System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
				String dob = in.nextLine();
				while(!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
					System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
					dob = in.nextLine();
				}
				serlay.createPat(name, dob);
				System.out.println("Patient account created");
			} else if(input.equalsIgnoreCase("y")){
				System.out.print("\nPlease enter patient name:");
				String name = in.nextLine();
				System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
				String dob = in.nextLine();
				while(!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
					System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
					dob = in.nextLine();
				}
				System.out.println("\n"+serlay.viewPatientByNameAndDob(name, dob));
			} else if(input.equalsIgnoreCase("Z")){
				System.out.print("\nPlease enter patient name:");
				String name = in.nextLine();
				System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
				String dob = in.nextLine();
				while(!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
					System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
					dob = in.nextLine();
				}
				serlay.deletePatient(name, dob);
				System.out.println("\nDeleted!");
			}
		}
	}
	
	public static void Staff(){
		String input = "";
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("\nStaff - (Type Q to exit staff):");
			System.out.println("[C]reate appointment for a patient");
			System.out.println("[D]elete appointment for a patient");
			input = in.nextLine();
			if(input.equalsIgnoreCase("c")){
				System.out.print("\nPlease enter Appointment date (MM/DD/YYYY format):");
				String appDate = in.nextLine();
				while(!appDate.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
					System.out.print("Wrong date format, please enter again (MM/DD/YYYY format):");
					appDate = in.nextLine();
				}
				System.out.print("Please enter Patient name:");
				String pname = in.nextLine();
				System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
				String dob = in.nextLine();
				while(!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
					System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
					dob = in.nextLine();
				}
				System.out.print("Please enter Doctor name:");
				String dname = in.nextLine();
				System.out.println("\n"+serlay.createAppointment(appDate, pname, dob, dname));				
			} else if(input.equalsIgnoreCase("d")){
				System.out.print("\nPlease enter patient name:");
				String name = in.nextLine();
				System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
				String dob = in.nextLine();
				while(!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
					System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
					dob = in.nextLine();
				}
				String available = serlay.viewPatientAppointments(name, dob);
				System.out.println("\n"+available);
				if(!available.equals("No Appointment Available")){
					System.out.print("\nPlease enter Appointment date to delete (MM/DD/YYYY format):");
					String appDate = in.nextLine();
					while(!appDate.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")){
						System.out.print("Wrong date format, please enter again (MM/DD/YYYY format):");
						appDate = in.nextLine();
					}
					serlay.deleteAppointment(name, dob, appDate);
					System.out.println("\nAppointment Deleted");
				}
			}
		}
		
	}
	
	public static void Doctor() {
		String input = "";
		System.out.print("\nPlease enter doctor name:");
		String name = in.nextLine();
		String verify = serlay.viewDoctorByName(name);
		if (verify.equals("Doctor Account not found")) {
			System.out.println("\n" + verify);
		} else {
			while (!input.equalsIgnoreCase("q")) {
				System.out.println("\nWelcome Doctor " + name);
				System.out.println("Doctor - (Type Q to exit staff):");
				System.out.println("[V]iew Patient information");
				System.out.println("[C]reate Prescription for patient");
				input = in.nextLine();
				if (input.equalsIgnoreCase("v")) {

				} else if (input.equalsIgnoreCase("c")) {
					System.out.print("\nPlease enter Medication name:");
					String medicationName = in.nextLine();
					System.out.print("Please enter Patient name:");
					String pname = in.nextLine();
					System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
					String dob = in.nextLine();
					while (!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")) {
						System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
						dob = in.nextLine();
					}
					System.out.println("\n" + serlay.createPrescription(medicationName, pname,dob, name));
				}
			}
		}
	}
	
	public static void Patient(){
		String input = "";
		System.out.print("\nPlease enter patient name:");
		String name = in.nextLine();
		System.out.print("Please enter patient date of birth (MM/DD/YYYY format):");
		String dob = in.nextLine();
		while (!dob.matches("[0-1][0-9]/[0-3][0-9]/[0-9][0-9][0-9][0-9]")) {
			System.out.print("Wrong date of birth format, please enter again (MM/DD/YYYY format):");
			dob = in.nextLine();
		}
		String verify = serlay.viewPatientByNameAndDob(name, dob);
		if (verify.equals("Patient not Found")) {
			System.out.println("\n" + verify);
		} else {
			while (!input.equalsIgnoreCase("q")) {
				System.out.println("\nWelcome Patient " + name);
				System.out.println("Patient - (Type Q to exit staff):");
				System.out.println("[V]iew Appointment list");
				System.out.println("[P] View Prescription from doctor");
				System.out.println("[D] View Doctor's Information");
				input = in.nextLine();
				if (input.equalsIgnoreCase("v")) {
					System.out.println("\n"+serlay.viewPatientAppointments(name, dob));
				} else if(input.equalsIgnoreCase("p")) {
					System.out.println("\n"+serlay.viewPatientPrescriptions(name, dob));
				}
			}
		}
	}

}
