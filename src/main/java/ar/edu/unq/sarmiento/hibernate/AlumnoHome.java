package ar.edu.unq.sarmiento.hibernate;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Alumno;

@Component
public class AlumnoHome extends AbstractHome<Alumno>{
	private static final long serialVersionUID = 1L;

	@Override
	public Alumno findByName(String name) {
		return this.getSession().createQuery("FROM Alumno WHERE nombre = :name",
				  Alumno.class).setParameter("name", name).getSingleResult();

	}
	
	public List<Alumno> getAlumnos(){
		return this.getSession().createQuery("FROM Alumno", Alumno.class).getResultList();
	}
	
}
