package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Examen extends Persistible{

	private String examenFinal;

	public String getExamenFinal() {
		return examenFinal;
	}

	public void setExamenFinal(String examenFinal) {
		this.examenFinal = examenFinal;
	}
	
	
}
