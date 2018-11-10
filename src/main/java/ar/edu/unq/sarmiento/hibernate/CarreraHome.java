package ar.edu.unq.sarmiento.hibernate;


import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Carrera;

@Component
public class CarreraHome extends AbstractHome<Carrera> {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Carrera findByName(String name) {
		return this.getSession().createQuery("FROM Carrera WHERE nombre = :name",
				  Carrera.class).setParameter("name", name).getSingleResult();
	}

}
