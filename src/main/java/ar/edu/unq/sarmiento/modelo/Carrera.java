package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.engine.internal.Cascade;

@Entity 
public class Carrera extends Persistible {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrera_id")
	private List<Alumno> alumnosInscriptos = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "carrera_id")
	private List<Materia> listadoMaterias = new ArrayList<>();
	private Boolean archivada= false;
	private String resolucion;
	private float duracion;
	
	public Carrera (){
		
	}
	
	public Carrera(String string,float duracion,String resolucion) {
		this.nombre = string;
		this.duracion = duracion;
		this.resolucion = resolucion;
	}

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
	
	public void agregarMateria(Materia materia){
		this.listadoMaterias.add(materia);
	}
}
