package ar.edu.itba.it.paw.domain.users;

import ar.edu.itba.it.paw.domain.common.BaseRepo;
import ar.edu.itba.it.paw.web.forms.LoginForm;

public interface UserRepo extends BaseRepo<User> {
	
	public User get(String email);

	public boolean checkLogin(LoginForm form);
	
}
