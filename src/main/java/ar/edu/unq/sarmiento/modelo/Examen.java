package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;
import org.hibernate.annotations.Type;

@Entity
public class Examen extends Persistible{

	private TipoDeExamen tipoDeExamen;
	private float calificacion;
	@Type(type= "yes_no")
	private boolean estuvoausente;
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
	public boolean isEstuvoausente() {
		return estuvoausente;
	}
	public void setEstuvoausente(boolean estuvoausente) {
		this.estuvoausente = estuvoausente;
	}
}
