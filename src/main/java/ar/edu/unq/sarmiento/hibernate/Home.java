package ar.edu.unq.sarmiento.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Repository
public interface Home<T> extends Serializable {

	public Session getSession();
	public T findByName(String name, Class<T> clas);
	public T find(Integer id);
	public void saveOrUpdate(T object);
	public void delete(T object);
	public void attach(T result);
}
