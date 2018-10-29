package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Alumno extends Persistible{
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
