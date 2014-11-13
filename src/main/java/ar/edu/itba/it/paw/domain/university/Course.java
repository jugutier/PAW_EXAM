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

	private  int MAX_STUDENTS;
	Course(){}//needed for hibernate
	
	public Course(String code, String name, int max_students) {//EX 5
		if(max_students<=0){
			throw new IllegalArgumentException("A course must have at least one student.");
		}
		this.code=code;
		this.name=name;
		this.MAX_STUDENTS=max_students;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public int getEnrolledStudents() {// EX 2
		return enrolledStudents;
	}
	
	/*public*/ void setEnrolledStudents(int enrolledStudents) {//requed for hibernate to set the private variable
		this.enrolledStudents = enrolledStudents;
	}

	public void enroll(Student student) throws CourseFullException {//EX 4
		if(enrolledStudents == MAX_STUDENTS){//EX 5
			throw new CourseFullException();
		}
		students.add(student);
		enrolledStudents++;
		student.enroll(this);
	}

	public void unenroll(Student student) {
		students.remove(student);
		enrolledStudents--;
		student.unenroll(this);
	}
}
