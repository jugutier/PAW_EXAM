package ar.edu.itba.it.paw.web.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ar.edu.itba.it.paw.domain.university.Student;
import ar.edu.itba.it.paw.domain.university.StudentRepo;

@Component
public class StudentFormatter implements Formatter<Student>{
	
	private StudentRepo students;
	
	@Autowired
	public StudentFormatter(StudentRepo students) {
		this.students = students;
	}

	public String print(Student object, Locale locale) {
		return object.getId() + "";
	}

	public Student parse(String text, Locale locale) throws ParseException {
		return students.get(Integer.valueOf(text));
	}
}
