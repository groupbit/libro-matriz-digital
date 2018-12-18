package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cursada extends Persistible {
	
	@OneToOne
	public Materia materia;
	public EstadoCursada estado;
	public int notaFinal;
	public int anioEnQueSeCursoLaMateria;
	
	public int getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}

	public int getAnioEnQueSeCursoLaMateria() {
		return anioEnQueSeCursoLaMateria;
	}

	public void setAnioEnQueSeCursoLaMateria(int anioEnQueSeCursoLaMateria) {
		this.anioEnQueSeCursoLaMateria = anioEnQueSeCursoLaMateria;
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
	