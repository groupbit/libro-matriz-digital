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
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class ListadoDeMateriasController implements Serializable{

	private Carrera carrera;

	public Carrera getCarrera() {
		return carrera;
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
		List<String> list = materia.getCorrelativas().stream().map(m -> m.getNombre()).collect(Collectors.toList());
		return String.join(", ", list);
	}
	
}
