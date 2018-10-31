package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Alumno extends Persistible {
	
	private String nombre;
	private Direccion direccion;
	private Carrera carrera;
	private Cursada cursada;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Cursada getCursada() {
		return cursada;
	}

	public void setCursada(Cursada cursada) {
		this.cursada = cursada;
	}
	
}
