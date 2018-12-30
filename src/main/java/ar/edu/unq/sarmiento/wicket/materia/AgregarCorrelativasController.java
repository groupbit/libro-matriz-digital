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
		materiaHome.attach(materia);
	}

	public Materia getMateriaElegida() {
		return materiaElegida;
	}

	public void setMateriaElegida(Materia materiaElegida) {
		this.materiaElegida = materiaElegida;
	}

	public void agregarCorrelativa() {
		materia.addCorrelativa(materiaElegida);
	}
	public List<Materia> materiasActivadas(){
		return materiaHome.all();
	}
}
