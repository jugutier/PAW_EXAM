package ar.edu.itba.it.paw.domain.university;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ar.edu.itba.it.paw.domain.common.PersistentEntity;
import ar.edu.itba.it.paw.domain.users.User;

@Entity
@Table(name="activity")
public class Activity extends PersistentEntity {
	@Column(length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private ActivityType activityType;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date date;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	@ManyToOne
	private Course course;
	
	Activity() {}
	
	public Activity(ActivityType activityType,User user,Student student,Course course){
		this.activityType = activityType;
		this.user = user;
		this.date = new Date();
		this.student = student;
		this.course= course;
	}
	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
// Modificar la pantalla de detalle de un curso para mostrar esta información
// (ordenada por fecha descendentemente).
// (3 puntos)
