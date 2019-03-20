package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class JugandoAMigrar extends Persistible {
	private String fedeAloi;

	public String getFedeAloi() {
		return fedeAloi;
	}

	public void setFedeAloi(String fedeAloi) {
		this.fedeAloi = fedeAloi;
	}
}
