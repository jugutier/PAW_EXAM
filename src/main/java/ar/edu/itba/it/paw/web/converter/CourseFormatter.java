package ar.edu.itba.it.paw.web.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ar.edu.itba.it.paw.domain.university.Course;
import ar.edu.itba.it.paw.domain.university.CourseRepo;

@Component
public class CourseFormatter implements Formatter<Course>{
	
	private CourseRepo courses;
	
	@Autowired
	public CourseFormatter(CourseRepo courses) {
		this.courses = courses;
	}

	public String print(Course object, Locale locale) {
		return object.getId() + "";
	}

	public Course parse(String text, Locale locale) throws ParseException {
		return courses.get(Integer.valueOf(text));
	}
}
