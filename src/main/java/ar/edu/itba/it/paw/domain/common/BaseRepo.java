package ar.edu.itba.it.paw.domain.common;

import java.util.List;


public interface BaseRepo<T extends PersistentEntity> {
	
	public T get(int id);
	
	public void add(T entity);
	
	public List<T> list();

}
