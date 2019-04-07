package ar.edu.unq.sarmiento.wicket.materia;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.wicket.model.IModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.hibernate.MateriaHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ListadoDeMateriasController implements Serializable{
	@Autowired
	private CarreraHome carreraHome;
	@Autowired
	private MateriaHome materiaHome;
	private Carrera carrera;

	public Carrera getCarrera() {
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

	public void eliminar(int idMateria) {
		Materia materia = materiaHome.find(idMateria);
		this.getCarrera().removerMateria(materia);
		materiaHome.delete(materia);
	}

	//saque los return 
}
