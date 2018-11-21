package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Persistible;
import javassist.bytecode.stackmap.TypeData.ClassName;


@Repository
public abstract class AbstractHome<T extends Persistible> implements Home<T> {

	private static final long serialVersionUID = -6234259370522061025L;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public T findByName(String name, Class<T> clas) {
		return (T) this.getSession().createQuery("FROM :className WHERE nombre = :name", clas)
				.setParameter("name", name)
				.setParameter("className", clas.getName())
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T find(Integer id) {
		Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractHome.class);
		return getSession().get(genericType, id);
	}
	
	@Override
	public List<T> all(Class<T> clas) {
		return this.getSession().createQuery("FROM :className", clas)
				.setParameter("className", clas.getName())
				.getResultList();
	}
	
	@Override
	public void saveOrUpdate(T object) {
		this.getSession().saveOrUpdate(object);
	}

	@Override
	public void delete(T object) {
		this.getSession().delete(object);
	}
	@Override
	public void attach(T result) {
		this.getSession().lock(result, LockMode.NONE);
	}

	
}
