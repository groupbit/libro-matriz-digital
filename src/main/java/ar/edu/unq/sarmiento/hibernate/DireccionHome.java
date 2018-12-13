package ar.edu.unq.sarmiento.hibernate;

import org.springframework.stereotype.Component;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Direccion;

@Component
public class DireccionHome extends Home<Direccion>{

	private static final long serialVersionUID = 1L;
	
	public Direccion getDireccion(Alumno alumno){
		return getSession().createQuery("FROM Alumno alum WHERE alumno.direccion = :direccion "
	,Direccion.class)
				.setParameter("alum",alumno)
				.setParameter("direccion.calle",alumno.getDireccion().getCalle())
				.getSingleResult();
	}
	
}
