package ar.edu.unq.sarmiento.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class EstudioCursado extends Persistible{

	private static final long serialVersionUID = 1L;
	
	private String secundario;
	private String escuela;
	private LocalDate anioEgreso;
	private String institucion;
	private String distrito;
	
	public String getSecundario() {
		return secundario;
	}
	public void setSecundario(String secundario) {
		this.secundario = secundario;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public LocalDate getAnioEgreso() {
		return anioEgreso;
	}
	public void setAnioEgreso(LocalDate anioEgreso) {
		this.anioEgreso = anioEgreso;
	}
	public String getInstitucion() {
		return institucion;
	}
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
	
	public String getDistrito(){
		return distrito;
	}
	
	public void setDistrito(String distrito){
		this.distrito=distrito;
	}
	
	

}
