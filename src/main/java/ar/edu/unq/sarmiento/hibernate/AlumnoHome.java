package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Alumno;

@Component
public class AlumnoHome extends Home<Alumno>{
	private static final long serialVersionUID = 1L;
	
	
	public Alumno getAlumno(Alumno alumno){
		return getSession().createQuery("FROM Alumno",Alumno.class).getSingleResult();
	}
	
}
