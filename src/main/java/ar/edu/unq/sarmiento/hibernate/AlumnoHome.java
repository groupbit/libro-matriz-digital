package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Direccion;

@Component
public class AlumnoHome extends Home<Alumno>{
	private static final long serialVersionUID = 1L;
	
	
	public Alumno getAlumno(Alumno alumno){
		return getSession().createQuery("FROM Alumno alum",Alumno.class)
				.setParameter("alum",alumno).getSingleResult();
	}
	public Alumno getAlumnoConDireccion(Alumno alumno,Direccion direccion){
		return getSession().createQuery("FROM Alumno alum WHERE direccion =:dir",Alumno.class)
				.setParameter("alum",alumno)
				.setParameter("dir",direccion)
				.getSingleResult();
	}
	
	
}
