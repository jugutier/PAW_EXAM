package ar.edu.itba.it.paw.domain.users;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ar.edu.itba.it.paw.domain.common.PersistentEntity;
import ar.edu.itba.it.paw.domain.university.Student;

@Entity
@Table(name="systemuser")
public class User extends PersistentEntity {
	
	private String email;
	private String password;
	
	@OneToOne
	private Student student;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Student getStudent() {
		return student;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
}
