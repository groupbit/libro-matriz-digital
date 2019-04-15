package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Range;

@Entity
public class Cursada extends Persistible {
	
	@OneToOne
	public Materia materia;
	public EstadoCursada estado;
	@Column(nullable = true)
	@Range(min = 0, max = 10, message= "Debe ingresar una nota entre 0 y 10")
	public int notaFinal;
	@Range(min =1900, max=2019, message= "Debe ingresar un año entre 1900 y el actual" )
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
	
	public boolean estadoRegularizadoOAprobado(){
		return (this.getEstado().equals(EstadoCursada.REGULARIZADA) || 
				this.getEstado().equals(EstadoCursada.APROBADA_FINAL) ||
				this.getEstado().equals(EstadoCursada.APROBADA_PROMOCION));
	}
}
	
