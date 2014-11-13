package ar.edu.itba.it.paw.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.edu.itba.it.paw.web.forms.LoginForm;

@Component
public class LoginFormValidator implements Validator {

	//private UserRepo users;
	
	/*@Autowired EX 3
	public LoginFormValidator(UserRepo users) {
		this.users = users;
	}*/

	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		//we only check basic structure here. The rest goes into the controller
		LoginForm form = (LoginForm) target;
		if(form.getEmail() == null || form.getPassword() == null){
			errors.reject("user.invalid");
		}
		
		/*if (!users.checkLogin(form)) {
			errors.reject("user.invalid");
		}*/ //EX #:there shouldn be a method receiving a form in the repo. 
	}
}
