package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class JugandoAMigrar extends Persistible {
	private String fedeAloi;
	private String nahuelM;
	
	public String getNahuelM() {
		return nahuelM;
	}

	public void setNahuelM(String nahuelM) {
		this.nahuelM = nahuelM;
	}

	public String getFedeAloi() {
		return fedeAloi;
	}

	public void setFedeAloi(String fedeAloi) {
		this.fedeAloi = fedeAloi;
	}
}
