package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Direccion;

@Component
public class DireccionHome extends AbstractHome<Direccion>{

	private static final long serialVersionUID = 1L;

	@Override
	public Direccion findByName(String name) {
		return this.getSession().createQuery("FROM Direccion WHERE calle = :name",
				  Direccion.class).setParameter("calle", name).getSingleResult();
	}
	
}
