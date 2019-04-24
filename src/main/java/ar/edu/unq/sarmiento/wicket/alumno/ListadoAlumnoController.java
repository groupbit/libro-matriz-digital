package ar.edu.unq.sarmiento.wicket.alumno;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.modelo.Alumno;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ListadoAlumnoController implements Serializable{

	@Autowired
	private AlumnoHome alumnoHome;
	
	private String nombreBuscado;
	
	public List<Alumno> getAlumnos(){
		return nombreBuscado == null
				? alumnoHome.all()
				: alumnoHome.filterByName(nombreBuscado);
	}
	
	public Alumno attach(Alumno alumno) {
		alumnoHome.attach(alumno);
		return alumno;
	}

	public String getNombreBuscado() {
		return nombreBuscado;
	}

	public void setNombreBuscado(String nombreBuscado) {
		this.nombreBuscado = nombreBuscado;
	}
	
}
