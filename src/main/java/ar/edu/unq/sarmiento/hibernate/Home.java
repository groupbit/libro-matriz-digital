package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import ar.edu.unq.sarmiento.modelo.Persistible;

@Repository
public abstract class Home<T extends Persistible> {

	private static final long serialVersionUID = -6234259370522061025L;

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> clazz;

	public Home() {
		// @faloi dice: esto lo estoy guardando para que no se calcule a cada
		// rato,
		// porque sospecho que es lento. Habría que medir a ver si realmente es
		// así.
		this.clazz = getEntityClass();
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public T find(Integer id) {
		return getSession().get(getEntityClass(), id);
	}

	public List<T> all() {
		return this.getSession().createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
	}

	public void saveOrUpdate(T object) {
		this.getSession().saveOrUpdate(object);
	}

	public void delete(T object) {
		this.getSession().delete(object);
	}

	public void attach(T result) {
		this.getSession().lock(result, LockMode.NONE);
	}

	public T findByName(String name) {
		return queryByName(name).getSingleResult();
	}

	public List<T> filterByName(String name) {
		return queryByName(name).getResultList();
	}

	private Query<T> queryByName(String name) {
		return this.getSession()
				.createQuery("FROM " + clazz.getSimpleName() + " WHERE nombre LIKE :name", clazz)
				.setParameter("name", "%" + name + "%");
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass() {
		return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), Home.class);
	}
}
