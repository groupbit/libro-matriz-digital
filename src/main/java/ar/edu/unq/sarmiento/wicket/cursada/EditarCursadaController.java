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
	public Materia materia;
	public EstadoCursada estado;
	public int notaFinal;
	public int anio;
	public Cursada cursada;

	public Alumno alumno;
	@Autowired
	private CursadaHome cursadaHome;
	@Autowired
	private AlumnoHome alumnoHome;
	@Autowired
	private MateriaHome materiaHome;

	public EditarCursadaController() {

	}

	public EditarCursadaController(Alumno alumno, Cursada cursada1) {
		cursadaHome.attach(cursada1);
		materiaHome.attach(cursada1.materia);
		alumnoHome.attach(alumno);
		this.alumno = alumno;
		this.cursada = cursada1;
		// this.materia = cursada.getMateria();
		// this.estado = cursada.getEstado();
		// this.anio = cursada.getAnio();
		this.notaFinal = cursada1.getNotaFinal();
	}

	public void editarCursada() {
		cursada.setMateria(cursada.getMateria());
		cursada.setNotaFinal(cursada.getNotaFinal());
		// cursada.setEstado(cursada.getEstado());
		cursada.setAnio(cursada.getAnio());
		cursadaHome.saveOrUpdate(cursada);
		// alumnoHome.saveOrUpdate(alumno);
	}

	public void setCursada(Cursada cursada2) {
		cursadaHome.attach(cursada2);
		this.cursada = cursada2;
		cursada.anio = cursada2.getAnio();
		cursada.estado = cursada2.getEstado();
		cursada.materia = cursada2.getMateria();
		cursada.notaFinal = cursada2.getNotaFinal();

	}

	public EstadoCursada getEstado() {
		return estado;
	}

	public void setEstado(EstadoCursada estado) {
		this.estado = estado;
	}

	public int getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Cursada getCursada() {
		return cursada;
	}

	public List<EstadoCursada> getEstadosCursada() {
		return Arrays.asList(EstadoCursada.values());

	}

	public void setAlumno(Alumno alumno2) {
		alumno = alumno2;
	}

}
