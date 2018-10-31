package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Cursada extends Persistible {
	
	public Materia materia;

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}
