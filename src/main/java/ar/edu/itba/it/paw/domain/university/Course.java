package ar.edu.itba.it.paw.domain.university;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import ar.edu.itba.it.paw.domain.common.PersistentEntity;

@Entity
public class Course extends PersistentEntity {
	
	@ManyToMany
	@JoinTable(name="courseEntry", joinColumns=@JoinColumn(name="course_id"), inverseJoinColumns=@JoinColumn(name="student_id"))
	private Set<Student> students;
	
	private String code;
	private String name;
	
	private int enrolledStudents;
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEnrolledStudents() {
		return enrolledStudents;
	}
	
	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
}
