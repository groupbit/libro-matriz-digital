package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
	@ManyToMany
	private List<Materia> correlativas = new ArrayList<>();
	@Column
	private boolean esPromocionable;
	private int anioEnCarrera;
	private String docente;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(List<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public boolean getEsPromocionable() {
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

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}
	
}
