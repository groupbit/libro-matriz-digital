package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Materia;
@Component
public class MateriaHome extends AbstractHome<Materia>{

	private static final long serialVersionUID = 1L;

	@Override
	public Materia findByName(String name) {
		return this.getSession().createQuery("FROM Materia WHERE nombre = :name",
				  Materia.class).setParameter("name", name).getSingleResult();
	}

}
