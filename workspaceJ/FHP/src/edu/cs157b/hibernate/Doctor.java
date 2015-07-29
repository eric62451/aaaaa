package edu.cs157b.hibernate;

import javax.persistence.*;

@Entity
@Table(name="STUDENT_INFO")
@NamedQueries(
		{
@NamedQuery(name = "Doctor.findByName", query = "from Doctor where name = :name"),
@NamedQuery(name = "Doctor.findByNameAndSpecialty", query = "from Doctor where name = :name AND specialty = :specialty")
		}
)
public class Doctor extends Person{
	
	private int studentId;
	private String major; 
	private double gpa; 
	private String eMail;
	private String specialty;

	
	@Id
	@GeneratedValue
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Id
	@Column(name="Student_Name")
	public String getName() {
		return super.getName();
	}
	public void setName(String name) {
		super.setName(name);;
	}
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	/*
	public String toString()
	{   return studentId+ " "+ super.getName() + " " + major + " " + gpa + " " + address + " " + eMail; }
   */
}
