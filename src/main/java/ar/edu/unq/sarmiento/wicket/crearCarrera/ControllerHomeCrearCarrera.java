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
public class ControllerHomeCrearCarrera implements Serializable {
	
	@Autowired
	private CarreraHome carreraHome;
	private Carrera carrera;
	private String nombre;
	
	public ControllerHomeCrearCarrera(){
	}
	public void agregarCarrera() {
		Carrera _carrera = new Carrera(this.getNombre());
			carreraHome.saveOrUpdate(_carrera);
	}

	public CarreraHome getHome() {
		return carreraHome;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setHome(CarreraHome home) {
		this.carreraHome = home;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	

}
