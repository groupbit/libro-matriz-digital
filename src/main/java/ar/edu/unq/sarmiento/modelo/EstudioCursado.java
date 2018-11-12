package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class EstudioCursado extends Persistible{

	private static final long serialVersionUID = 1L;
	
	private int anioEgreso;
	private String institucion;
	private String distrito;
	@OneToOne
	private Alumno alumno;
	
	public EstudioCursado(){
		
	}
	
	public int getAnioEgreso() {
		return anioEgreso;
	}
	public void setAnioEgreso(int anioEgreso) {
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
