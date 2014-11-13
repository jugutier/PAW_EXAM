package ar.edu.itba.it.paw.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.edu.itba.it.paw.domain.users.UserRepo;
import ar.edu.itba.it.paw.web.forms.LoginForm;

@Component
public class LoginFormValidator implements Validator {

	private UserRepo users;
	
	@Autowired
	public LoginFormValidator(UserRepo users) {
		this.users = users;
	}

	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		LoginForm form = (LoginForm) target;
		if (!users.checkLogin(form)) {
			errors.reject("user.invalid");
		}
	}
}
