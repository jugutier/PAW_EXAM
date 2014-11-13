package ar.edu.itba.it.paw.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.it.paw.domain.university.Course;
import ar.edu.itba.it.paw.domain.university.CourseRepo;

@Controller
public class CoursesController {
	
	private CourseRepo courses;
	
	@Autowired
	public CoursesController(CourseRepo courseRepo) {
		this.courses = courseRepo;
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("courses/list");
		mav.addObject("courses", courses.list());
		return mav;
	}
	
	@RequestMapping
	public ModelAndView profile(@RequestParam Course course) {
		ModelAndView mav = new ModelAndView("courses/profile");
		mav.addObject("course", course);
		return mav;
	}

}
