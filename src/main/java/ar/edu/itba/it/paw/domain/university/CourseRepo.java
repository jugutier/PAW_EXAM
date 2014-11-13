package ar.edu.itba.it.paw.domain.university;

import java.util.List;

import ar.edu.itba.it.paw.domain.common.BaseRepo;

public interface CourseRepo extends BaseRepo<Course> {

	public List<Course> enrollableCourses(Student student);
	
}
