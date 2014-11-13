package ar.edu.itba.it.paw.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.edu.itba.it.paw.web.forms.EnrollForm;
@Component
public class EnrollFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return EnrollForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EnrollForm form = (EnrollForm) target;
		if(form.getCourse()==null){
			errors.reject("course.invalid");
		}
		
	}

}
