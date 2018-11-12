package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity 
public class Carrera extends Persistible {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	@Transient
	private List<Alumno> alumnosInscriptos = new ArrayList<>();
	@Transient
	private List<Materia> listadoMaterias = new ArrayList<>();
	private Boolean archivada= false;
	private String resolucion;
	private float duracion;

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

	public Boolean getArchivada() {
		return archivada;
	}

	public void setArchivada(Boolean archivada) {
		this.archivada = archivada;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	
}
