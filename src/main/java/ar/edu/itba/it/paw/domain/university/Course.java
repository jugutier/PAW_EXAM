package ar.edu.itba.it.paw.domain.university;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import ar.edu.itba.it.paw.domain.common.PersistentEntity;
import ar.edu.itba.it.paw.domain.users.User;

@Entity
public class Course extends PersistentEntity {
	
	@ManyToMany
	@JoinTable(name="courseEntry", joinColumns=@JoinColumn(name="course_id"), inverseJoinColumns=@JoinColumn(name="student_id"))
	private Set<Student> students;
	
	private String code;
	private String name;
	
	private int enrolledStudents;

	private  int MAX_STUDENTS;
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Activity> activities;
	
	Course(){}//needed for hibernate
	
	public Course(String code, String name, int max_students) {//EX 5
		if(max_students<=0){
			throw new IllegalArgumentException("A course must have at least one student.");
		}
		this.code=code;
		this.name=name;
		this.MAX_STUDENTS=max_students;
		this.activities = new LinkedList<Activity>();
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

	public void enroll(Student student,User enroller) throws CourseFullException {//EX 4
		if(enrolledStudents == MAX_STUDENTS){//EX 5
			throw new CourseFullException();
		}
		students.add(student);
		enrolledStudents++;
		student.enroll(this);
		activities.add(new Activity(ActivityType.ENROLL,enroller,student,this));
	}

	public void unenroll(Student student,User unenroller) {
		students.remove(student);
		enrolledStudents--;
		student.unenroll(this);
		activities.add(new Activity(ActivityType.UNENROLL,unenroller,student,this));
	}
}
