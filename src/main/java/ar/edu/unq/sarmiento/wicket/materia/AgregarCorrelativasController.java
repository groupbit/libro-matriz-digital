package ar.edu.unq.sarmiento.wicket.materia;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.hibernate.MateriaHome;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class AgregarCorrelativasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MateriaHome materiaHome;
	@Autowired
	private CarreraHome carreraHome;
	private Materia materia;
	private Materia materiaElegida;
	private List<Materia> todasLasMaterias;
	private List<Materia> correlativasDeMateria;

	public Materia getMateria() {
		return materia;
	}
	
	public String nombreMateria(){
		return materia.getNombre();
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Materia getMateriaElegida() {
		return materiaElegida;
	}

	public void setMateriaElegida(Materia materiaElegida) {
		this.materiaElegida = materiaElegida;
	}

	public void agregarCorrelativa() {
		materia.addCorrelativa(materiaElegida);
		materiaHome.saveOrUpdate(materia);
	}

	public Carrera attach(Carrera carrera) {
		carreraHome.attach(carrera);
		return carrera;
	}

	public void cargarCorrelativasPosibles() {
		setTodasLasMaterias(materiaHome.all());
	}
	public List<Materia> materiasYaElegidas(List<Materia> mate){
		todasLasMaterias.removeAll(mate);
		return todasLasMaterias;
	}

	public List<Materia> getTodasLasMaterias() {
		List<Materia> materias =this.materiasYaElegidas(materia.getCorrelativas());
		materias.remove(materia);
		return materias;
	}

	public void setTodasLasMaterias(List<Materia> todasLasMaterias) {
		this.todasLasMaterias = todasLasMaterias;
	}
}
