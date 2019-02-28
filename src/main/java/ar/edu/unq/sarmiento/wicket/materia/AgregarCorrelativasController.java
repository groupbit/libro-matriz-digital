package ar.edu.unq.sarmiento.wicket.materia;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.MateriaHome;
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
	private Materia materia;
	private Materia materiaElegida;

	public Materia getMateria() {
		return materia;
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

	public List<Materia> materiasActivadas() {
		List<Materia> todasLasMaterias = materiaHome.all();
		List<Materia> correlaticas = this.materia.getCorrelativas();
		todasLasMaterias.removeAll(correlaticas);
	return todasLasMaterias;
	}

	public void attach(Materia materia) {
		Materia materia1 = materia;
		materiaHome.attach(materia1);
	}
}
