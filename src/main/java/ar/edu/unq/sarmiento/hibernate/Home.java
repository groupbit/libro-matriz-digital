package ar.edu.unq.sarmiento.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public interface Home<T> extends Serializable {

	public Session getSession();
	public T findByName(String name);
	public T find(Integer id);
	public void saveOrUpdate(T object);
	public void delete(T object);
	public void attach(T result);
	public List<T> all();
}
