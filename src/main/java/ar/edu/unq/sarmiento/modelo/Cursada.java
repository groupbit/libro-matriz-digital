package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cursada extends Persistible {
	
	@OneToOne
	public Materia materia;
	public EstadoCursada estado;
	@Column(nullable=true)
	public int notaFinal;
	public int anio;
	public int getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anioEnQueSeCursoLaMateria) {
		this.anio = anioEnQueSeCursoLaMateria;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public EstadoCursada getEstado() {
		return estado;
	}

	public void setEstado(EstadoCursada estado) {
		this.estado = estado;
	}
}
	