package ar.edu.unq.sarmiento.wicket.cursada;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.hibernate.CursadaHome;
import ar.edu.unq.sarmiento.hibernate.MateriaHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.modelo.Materia;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class EditarCursadaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Cursada cursada;

	@Autowired
	private CursadaHome cursadaHome;

	public EditarCursadaController() {

	}

	public EditarCursadaController(Cursada cursada1) {
		cursadaHome.attach(cursada1);
		this.cursada = cursada1;
	}

	public void editarCursada() {
		cursadaHome.saveOrUpdate(cursada);
	}

	public void setCursada(Cursada cursada2) {
		this.cursada = cursada2;
	}

	public Cursada getCursada() {
		return cursada;
	}

	public List<EstadoCursada> getEstadosCursada() {
		return Arrays.asList(EstadoCursada.values());

	}

}
