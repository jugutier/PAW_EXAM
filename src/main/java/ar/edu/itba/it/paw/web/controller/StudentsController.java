package ar.edu.itba.it.paw.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ar.edu.itba.it.paw.domain.university.Course;
import ar.edu.itba.it.paw.domain.university.CourseFullException;
import ar.edu.itba.it.paw.domain.university.CourseRepo;
import ar.edu.itba.it.paw.domain.university.Student;
import ar.edu.itba.it.paw.domain.university.StudentRepo;
import ar.edu.itba.it.paw.web.forms.EnrollForm;
import ar.edu.itba.it.paw.web.validator.EnrollFormValidator;

@Controller
public class StudentsController {
	
	private StudentRepo students;
	private CourseRepo courses;
	private EnrollFormValidator validator;
	
	@Autowired
	public StudentsController(StudentRepo studentRepo, CourseRepo courseRepo,EnrollFormValidator validator) {
		this.students = studentRepo;
		this.courses = courseRepo;
		this.validator=validator;
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("students/list");
		mav.addObject("students", students.list());
		return mav;
	}
	
	@RequestMapping
	public ModelAndView profile(@RequestParam Student student) {
		ModelAndView mav = new ModelAndView("students/profile");
		mav.addObject("student", student);
		mav.addObject("enrollableCourses", courses.enrollableCourses(student));
		mav.addObject("enrollForm", new EnrollForm(student));
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView enroll(EnrollForm form, Errors errors) {		
		validator.validate(form,errors);
		//EX 4:without this, theres an error when matriculating on an empty subject
		
		if(errors.hasErrors()) {
			return profile(form.getStudent());
		}
		Student student = form.getStudent();
		Course course = form.getCourse();
		try {
			course.enroll(student);
		} catch (CourseFullException e) {
			errors.reject("course.full");
			return profile(form.getStudent());//EX 5
		} 
		// EX 2: model should know how to enroll a student. We don't do business logic in the controller..
/*		if (course.getStudents().add(student)) {
			course.setEnrolledStudents(course.getEnrolledStudents() + 1);
		}*/
		RedirectView view = new RedirectView("/bin/students/profile", true);
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", form.getStudent().getId());
		mav.setView(view);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView unenroll(@RequestParam Student student, @RequestParam Course course) {
		course.unenroll(student);//EX 2: same here
		/*if (course.getStudents().remove(student)) {
			course.setEnrolledStudents(course.getEnrolledStudents() - 1);
		}*/
		RedirectView view = new RedirectView("/bin/students/profile", true);
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", student.getId());
		mav.setView(view);
		return mav;
	}

}
