package ar.edu.itba.it.paw.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.itba.it.paw.domain.users.UserRepo;
import ar.edu.itba.it.paw.web.forms.LoginForm;
import ar.edu.itba.it.paw.web.validator.LoginFormValidator;

@Controller
public class UserController {

	private UserRepo users;
	private LoginFormValidator validator;

	@Autowired
	public UserController(UserRepo users, LoginFormValidator validator) {
		this.users = users;
		this.validator = validator;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("user/login");
		mav.addObject(new LoginForm());
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(LoginForm form, Errors errors, HttpSession session) {
		validator.validate(form, errors);
		if (errors.hasErrors()) {
			return null;
		}
		
		session.setAttribute("userId", users.get(form.getEmail()).getId());
		return "redirect:../home/home";
	}
}
