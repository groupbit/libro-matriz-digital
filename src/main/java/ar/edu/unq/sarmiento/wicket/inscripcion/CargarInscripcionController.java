package ar.edu.unq.sarmiento.wicket.inscripcion;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.modelo.Alumno;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CargarInscripcionController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private AlumnoHome alumnoHome;
	
	private String nombre;
	
	public void inscribir(){
		Alumno alumno=new Alumno();
		alumno.setNombre(this.getNombre());
		alumnoHome.saveOrUpdate(alumno);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
