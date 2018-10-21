package ar.edu.unq.sarmiento.inicio;

import org.hibernate.Session;

import ar.edu.unq.sarmiento.hibernate.SessionFactoryContainer;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Direccion;
import ar.edu.unq.sarmiento.modelo.Home;

public class DireccionHome implements Home<Direccion> {
	private static final long serialVersionUID = 4775910097257163038L;

	static private DireccionHome instance = new DireccionHome();

	public static DireccionHome getInstance() {
		return instance;
	}

	private Session getSession() {
		return SessionFactoryContainer.getSessionFactory().getCurrentSession();
	}

	@Override
	public void insert(Direccion object) {
		this.getSession().save(object);
	}

	@Override
	public void update(Direccion object) {

	}

	@Override
	public void delete(Direccion object) {
	}

}
