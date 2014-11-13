package ar.edu.itba.it.paw.domain.university;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.itba.it.paw.domain.common.AbstractHibernateRepo;

@Repository
public class HibernateCourseRepo extends AbstractHibernateRepo implements CourseRepo {

	@Autowired
	public HibernateCourseRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public void add(Course entity) {
		this.save(entity);
	}
	
	public Course get(int id) {
		return this.get(Course.class, id);
	}
	
	public List<Course> list() {
		return this.find("from Course");
	}
	
	public List<Course> enrollableCourses(Student student) {
		return this.find("select distinct c from Course c inner join c.students where ? not member of c.students", student);
	}
	
	public List<Activity> activityLog(Course course) {
		return this.find("from Activity a where a.course = ? order by desc",course);
	}
	
}
