package ar.edu.unq.sarmiento.wicket.materia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.hibernate.CursadaHome;
import ar.edu.unq.sarmiento.hibernate.MateriaHome;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.Materia;
import ar.edu.unq.sarmiento.modelo.ModelException;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ListadoDeMateriasController implements Serializable{
	@Autowired
	private CarreraHome carreraHome;
	@Autowired
	private MateriaHome materiaHome;
	@Autowired
	private CursadaHome cursadaHome;
	private Carrera carrera;
	private Materia materia;

	public Materia getMateria() {
		return materia;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}
	
	public Carrera getCarreraDetached(){
		return carreraHome.find(carrera.getId());
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public String getNombreCarrera(){
		return this.getCarrera().getNombre();
	}
	
	public List<Materia> getMaterias(){
		return this.getCarrera().getListadoMaterias();
	}

	public String convertirString(Boolean promocion) {
		return promocion ? "Sí" : "No";
	}
	

	public String getCorrelativas(Materia materia) {
		return materia.getCorrelativas().stream()
				  .map(m -> m.getNombre())
				  .collect(Collectors.joining(", "));
	}

	public void attach(Carrera carrera) {
		carreraHome.attach(carrera);
	}

	public void attachMateria(Materia materia) {
		materiaHome.attach(materia);
	}

	public void eliminar(Materia materia) {
		this.puedeBorrarse(materia);
		eliminarCorrelativasDe(materia);
	}

	private void puedeBorrarse(Materia materia) {
		List<Cursada> cursadas = new ArrayList<>(cursadaHome.all());
		if(cursadas.stream().anyMatch(c -> c.getMateria().equals(materia))){
			throw new ModelException("No se puede eliminar " + materia.getNombre()  + " porque algún alumno ya la cursó o la esta cursando");
		}
	}

	private void eliminarCorrelativasDe(Materia materia) {
		materia.eliminarCorrelatividades(this.getCarreraDetached());
		materiaHome.saveOrUpdate(materia);
	}

	public String mensajeDeEliminarMateria(Materia materia) {
		return "¿Confirma que desea eliminar la materia " + materia.getNombre() + "?";
	}

}
