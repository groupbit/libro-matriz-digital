package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Cursada extends Persistible {
	
	public Materia materia;
	public EstadoCursada estado;
	@Transient
	private List<Alumno> quienesCursaron = new ArrayList<>();
	@Transient
	private List<Examen> examenes = new ArrayList<>();
	
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

	public List<Alumno> getQuienesCursaron() {
		return quienesCursaron;
	}

	public void setQuienesCursaron(List<Alumno> quienesCursaron) {
		this.quienesCursaron = quienesCursaron;
	}

	public List<Examen> getExamenes() {
		return examenes;
	}

	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	
}
