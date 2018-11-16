package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

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

	public List<Carrera> ListadoDeCarreras(){
		return this.getSession().createQuery("FROM Carrera" , Carrera.class).list();
	}
	public List<Carrera>listadoDeCarrerasVigentes(){
		return this.getSession().createQuery("FROM Carrera WHERE archivada = : archiv", Carrera.class)
				.setParameter("archiv", false)
				.getResultList();
	}
}
