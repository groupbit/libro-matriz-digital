package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Materia extends Persistible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	@ManyToMany
	private List<Materia> correlativas = new ArrayList<>();
	@Column
	private boolean promocionable;
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

	public boolean isPromocionable() {
		return promocionable;
	}

	public void setPromocionable(boolean promocionable) {
		this.promocionable = promocionable;
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
