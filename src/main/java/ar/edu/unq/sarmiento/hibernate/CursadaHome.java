package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Cursada;

@Component
public class CursadaHome extends AbstractHome<Cursada>{

	private static final long serialVersionUID = 1L;

	@Override
	public Cursada find(Integer id) {
		return this.getSession().createQuery("FROM Cursada WHERE id = :id",
				 Cursada.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public Cursada findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
