package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Materia extends Persistible {

	public String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
