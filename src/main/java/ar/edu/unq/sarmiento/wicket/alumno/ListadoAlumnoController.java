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
	private Alumno alumno;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public List<Alumno> getUsuariosEnInstituto(){
		return alumnoHome.getAlumnos();
	}
	
}
