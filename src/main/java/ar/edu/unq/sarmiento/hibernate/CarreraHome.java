package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Carrera;

@Component
public class CarreraHome extends Home<Carrera> {

	private static final long serialVersionUID = 1L;

	public List<Carrera> listadoDeCarrerasVigentes() {
		return this.createQuery("WHERE archivada = :archiv").setParameter("archiv", false).getResultList();
	}

}