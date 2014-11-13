package ar.edu.itba.it.paw.domain.university;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import ar.edu.itba.it.paw.domain.common.PersistentEntity;

@Entity
public class Student extends PersistentEntity {
	
	private int studentNumber;
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy="students")
	@JoinTable(name="courseEntry", joinColumns=@JoinColumn(name="course_id"), inverseJoinColumns=@JoinColumn(name="student_id"))
	private Set<Course> courses;
	
	public int getStudentNumber() {
		return studentNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

}
