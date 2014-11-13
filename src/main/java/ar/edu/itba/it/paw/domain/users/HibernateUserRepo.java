package ar.edu.itba.it.paw.domain.users;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.itba.it.paw.domain.common.AbstractHibernateRepo;
import ar.edu.itba.it.paw.web.forms.LoginForm;

@Repository
public class HibernateUserRepo extends AbstractHibernateRepo implements UserRepo {

	@Autowired
	public HibernateUserRepo(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public void add(User entity) {
		this.save(entity);
	}
	
	public User get(int id) {
		return this.get(User.class, id);
	}
	
	public List<User> list() {
		return this.find("from User");
	}
	
	public User get(String email) {
		List<User> users = this.find("from User where email = ?", email);
		if(users.isEmpty()) {
			return null;
		}
		
		return users.get(0);
	}
	
	@Override
	public boolean checkLogin(LoginForm form) {
		User user = get(form.getEmail());
		if (user == null) { 
			return false;
		}
		return user.matchPassword(form.getPassword());
	}
}
