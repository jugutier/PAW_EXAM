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
import ar.edu.itba.it.paw.domain.university.CourseRepo;
import ar.edu.itba.it.paw.domain.university.Student;
import ar.edu.itba.it.paw.domain.university.StudentRepo;
import ar.edu.itba.it.paw.web.forms.EnrollForm;

@Controller
public class StudentsController {
	
	private StudentRepo students;
	private CourseRepo courses;
	
	@Autowired
	public StudentsController(StudentRepo studentRepo, CourseRepo courseRepo) {
		this.students = studentRepo;
		this.courses = courseRepo;
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
		if(errors.hasErrors()) {
			return profile(form.getStudent());
		}
		Student student = form.getStudent();
		Course course = form.getCourse();
		if (course.getStudents().add(student)) {
			course.setEnrolledStudents(course.getEnrolledStudents() + 1);
		}
		RedirectView view = new RedirectView("/bin/students/profile", true);
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", form.getStudent().getId());
		mav.setView(view);
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView unenroll(@RequestParam Student student, @RequestParam Course course) {
		if (course.getStudents().remove(student)) {
			course.setEnrolledStudents(course.getEnrolledStudents() - 1);
		}
		RedirectView view = new RedirectView("/bin/students/profile", true);
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", student.getId());
		mav.setView(view);
		return mav;
	}

}
