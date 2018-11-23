package ar.edu.unq.sarmiento.wicket.carrera;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.modelo.Carrera;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CarreraController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CarreraHome carreraHome;

	private Carrera carrera;

	private String nombre;

	private float duracion;

	private String resolucion;

	public CarreraController(Carrera carrera2) {
		carrera = carrera2;
		this.nombre = carrera.getNombre();
		this.duracion = carrera.getDuracion();
		this.resolucion = carrera.getResolucion();

	}

	public CarreraController() {

	}

	public List<Carrera> getCarreras() {
		return carreraHome.all();
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera2) {
		this.carrera = carrera2;
		carreraHome.attach(carrera2);
		this.nombre = carrera.getNombre();
		this.duracion = carrera.getDuracion();
		this.resolucion = carrera.getResolucion();

	}

	public void modificarCarrera() {
		carreraHome.attach(carrera);
		carrera.setNombre(this.getNombre());
		carrera.setDuracion(this.getDuracion());
		carrera.setResolucion(this.getResolucion());

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getDuracion() {
		return duracion;
	}

	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public List<Carrera> getListadoDeCarrerasVigentes() {
		return carreraHome.listadoDeCarrerasVigentes();
	}

	public Carrera attach(Carrera carrera) {
		carreraHome.attach(carrera);
		return carrera;
	}
}
