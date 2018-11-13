package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.EstudioCursado;

@Component
public class EstudioCursadoHome extends AbstractHome<EstudioCursado>{

	private static final long serialVersionUID = 1L;

	@Override
	public EstudioCursado findByName(String name) {
		return this.getSession().createQuery("FROM Carrera WHERE nombre = :name",
				  EstudioCursado.class).setParameter("name", name).getSingleResult();
	}

}
