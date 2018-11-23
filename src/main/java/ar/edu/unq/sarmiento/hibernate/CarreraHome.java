package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;

@Component
public class CarreraHome extends Home<Carrera> {

	private static final long serialVersionUID = 1L;

	public List<Carrera> listadoDeCarrerasVigentes() {
		return this.getSession().createQuery("FROM Carrera WHERE archivada = :archiv", Carrera.class)
				.setParameter("archiv", false).getResultList();
	}

	public List<Materia> findMaterias(Carrera carrera) {
		return this.getSession().createQuery("FROM Materia WHERE carrera = :carreraId", Materia.class)
				.setParameter("carreraId", carrera).getResultList();
	}
}
