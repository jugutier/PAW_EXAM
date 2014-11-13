package ar.edu.itba.it.paw.domain.users;

import ar.edu.itba.it.paw.domain.common.BaseRepo;

public interface UserRepo extends BaseRepo<User> {
	
	public User get(String email);

	//public boolean checkLogin(LoginForm form); form behaviour MUST NOT be in the repository. we do not mix view with the repository.
	
}
