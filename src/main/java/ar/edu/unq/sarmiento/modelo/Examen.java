package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Examen extends Persistible{
	private TipoDeExamen tipoDeExamen;
	private float calificacion;
	private boolean ausente;
	public TipoDeExamen getTipoDeExamen() {
		return tipoDeExamen;
	}
	public void setTipoDeExamen(TipoDeExamen tipoDeExamen) {
		this.tipoDeExamen = tipoDeExamen;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	public boolean isAusente() {
		return ausente;
	}
	public void setAusente(boolean estuvoausente) {
		this.ausente = estuvoausente;
	}
}