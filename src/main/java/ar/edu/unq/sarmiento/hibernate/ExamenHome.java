package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Examen;
@Component
public class ExamenHome extends AbstractHome<Examen>{

	private static final long serialVersionUID = 1L;

	@Override
	public Examen findByName(String name) {
		return this.getSession().createQuery("FROM examenFinal WHERE examenFinal = :name",
				  Examen.class).setParameter("name", name).getSingleResult();
	}

}
