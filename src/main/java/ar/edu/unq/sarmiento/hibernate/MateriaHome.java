package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;
@Component
public class MateriaHome extends Home<Materia>{

	private static final long serialVersionUID = 1L;

	public List<Materia> findByCarrera(Carrera carrera) {
		return createQuery("WHERE carrera_id = :carrera")
			.setParameter("carrera", carrera)
			.getResultList();
	}
	
	
	
}
