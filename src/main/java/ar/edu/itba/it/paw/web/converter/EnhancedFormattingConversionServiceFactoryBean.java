package ar.edu.itba.it.paw.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import ar.edu.itba.it.paw.domain.university.Course;
import ar.edu.itba.it.paw.domain.university.Student;

public class EnhancedFormattingConversionServiceFactoryBean 
				extends FormattingConversionServiceFactoryBean {

	private StudentFormatter studentFormatter;
	private CourseFormatter courseFormatter;
	
	@Autowired
	public EnhancedFormattingConversionServiceFactoryBean(StudentFormatter studentFormatter, CourseFormatter courseFormatter) {
		this.studentFormatter = studentFormatter;
		this.courseFormatter = courseFormatter;
	}
	
	@Override
	protected void installFormatters(FormatterRegistry registry){
		registry.addFormatterForFieldType(Student.class, studentFormatter);
		registry.addFormatterForFieldType(Course.class, courseFormatter);
		super.installFormatters(registry);
	}
}


