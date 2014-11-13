package ar.edu.itba.it.paw.web.forms;

import ar.edu.itba.it.paw.domain.university.Course;
import ar.edu.itba.it.paw.domain.university.Student;

public class EnrollForm {

	private Student student;
	private Course course;
	
	EnrollForm() {
	}
	
	public EnrollForm(Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
