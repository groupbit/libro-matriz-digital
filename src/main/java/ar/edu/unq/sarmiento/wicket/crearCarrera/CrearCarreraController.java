package ar.edu.unq.sarmiento.wicket.crearCarrera;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.modelo.Carrera;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CrearCarreraController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CarreraHome carreraHome;
	private Carrera carrera;
	
	private String nombre;
	private String resolucion;
	private float duracion;
	
	public void agregarCarrera() {
		Carrera _carrera = new Carrera(this.getNombre(),this.getDuracion(),this.getResolucion());
		carreraHome.saveOrUpdate(_carrera);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public String getResolucion() {
		return resolucion;
	}


	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}


	public float getDuracion() {
		return duracion;
	}


	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
}
