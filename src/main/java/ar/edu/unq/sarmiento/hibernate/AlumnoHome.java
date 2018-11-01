package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Alumno;

@Component
public class AlumnoHome extends AbstractHome<Alumno>{
	
	@Override
	public Alumno findByName(String name) {
		return this.getSession().createQuery("FROM Alumno WHERE nombre = :name",
				  Alumno.class).setParameter("name", name).getSingleResult();

	}
	
	
	
}
