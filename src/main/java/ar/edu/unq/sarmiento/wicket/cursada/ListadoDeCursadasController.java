package ar.edu.unq.sarmiento.wicket.cursada;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.CursadaHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.EstadoCursada;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ListadoDeCursadasController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Alumno alumno;
	@Autowired
	private CursadaHome cursadaHome;

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
		return estado.toString();
	}
	public List<Cursada> getCursadas(){
		return cursadaHome.listaDeCursadasOrdenadas(this.getAlumno().getId());
	}
}
