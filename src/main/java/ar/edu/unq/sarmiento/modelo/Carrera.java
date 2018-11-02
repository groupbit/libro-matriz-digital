package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity 
public class Carrera extends Persistible {
	
	private String nombre;
	@Transient
	private List<Alumno> alumnosInscriptos = new ArrayList<>();
	@Transient
	private List<Materia> listadoMaterias = new ArrayList<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnosInscriptos() {
		return alumnosInscriptos;
	}

	public void setAlumnosInscriptos(List<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}

	public List<Materia> getListadoMaterias() {
		return listadoMaterias;
	}

	public void setListadoMaterias(List<Materia> listadoMaterias) {
		this.listadoMaterias = listadoMaterias;
	}
	
}
