package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

@Entity
public class Materia extends Persistible {

	private String nombre;
	@ManyToOne
	@JoinColumn(name="carrera")
	private Carrera carrera;
	@ManyToMany
	private List<Materia> correlativas = new ArrayList<>();
	@Type(type="yes_no")
	private boolean esPromocionable;
	private int anioEnCarrera;
	@ManyToOne
	@JoinColumn(name="docente")
	private Docente docente;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(List<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public boolean isEsPromocionable() {
		return esPromocionable;
	}

	public void setEsPromocionable(boolean esPromocionable) {
		this.esPromocionable = esPromocionable;
	}

	public int getAnioEnCarrera() {
		return anioEnCarrera;
	}

	public void setAnioEnCarrera(int anioEnCarrera) {
		this.anioEnCarrera = anioEnCarrera;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}
