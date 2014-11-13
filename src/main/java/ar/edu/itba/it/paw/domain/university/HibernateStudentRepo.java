package ar.edu.itba.it.paw.domain.university;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.itba.it.paw.domain.common.AbstractHibernateRepo;

@Repository
public class HibernateStudentRepo extends AbstractHibernateRepo implements StudentRepo {

	@Autowired
	public HibernateStudentRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public void add(Student entity) {
		this.save(entity);
	}
	
	public Student get(int id) {
		return this.get(Student.class, id);
	}
	
	public List<Student> list() {
		return this.find("from Student");
	}
	
}
