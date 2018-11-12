package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Docente;

@Component
public class DocenteHome extends AbstractHome<Docente> {

	private static final long serialVersionUID = 1L;

	@Override
	public Docente findByName(String name) {
		return this.getSession().createQuery("FROM Docente WHERE nombre = :name",
				  Docente.class).setParameter("name", name).getSingleResult();
	}

}