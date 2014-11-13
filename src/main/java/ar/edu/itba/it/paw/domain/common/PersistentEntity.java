package ar.edu.itba.it.paw.domain.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersistentEntity {
	
	public PersistentEntity() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public boolean isNew() {
		return (getId() == null);
	}
	
}
