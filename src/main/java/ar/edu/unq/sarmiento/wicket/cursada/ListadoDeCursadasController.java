package ar.edu.unq.sarmiento.wicket.cursada;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.hibernate.CursadaHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.wicket.utils.EnumUtils;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ListadoDeCursadasController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CursadaHome cursadaHome;
	@Autowired
	private AlumnoHome alumnoHome;
	private Alumno alumno;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public String getNombreAlumno(){
		return this.getAlumno().getNombre();
	}
	
	public String convertirString(EstadoCursada estado) {
		return EnumUtils.convertirString(estado);
	}
	public List<Cursada> getCursadas(){
		return alumno.getCursadas();
		
	}

	public void eliminarCursada(Cursada cursada) {
		cursadaHome.delete(cursada);
	}

	public Alumno getAlumnoDetached() {
		return alumnoHome.find(this.getAlumno().getId());
	}

	public String mensajeDeEliminacion(Cursada cursada) {
		return "¿Confirma que desea eliminar la cursada de " 
				+ cursada.getMateria().getNombre() + 
				" del año "
				+ cursada.getAnio() + 
				"?";
	}
}
