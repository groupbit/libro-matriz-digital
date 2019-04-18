package ar.edu.unq.sarmiento.wicket.materia;

import java.io.Serializable;
import java.util.List;

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
public class QuitarCorrelativaController implements Serializable{

	private static final long serialVersionUID = 1L;
	private Materia materia;
	private Materia correlativaElegida;
	@Autowired
	private MateriaHome materiaHome;
	@Autowired
	private CarreraHome carreraHome;
	
	public void setMateria(Materia materia1) {
		this.materia = materia1;
	}

	public List<Materia> listaDeCorrelativasdeMateria(){
		return this.materia.getCorrelativas();
	}
	
	public void quitarCorrelativa(){
		this.materia.getCorrelativas().remove(correlativaElegida);
		this.materiaHome.saveOrUpdate(materia);
	}

	public Materia getCorrelativaElegida() {
		return correlativaElegida;
	}

	public void setCorrelativaElegida(Materia correlativaElegida) {
		this.correlativaElegida = correlativaElegida;
	}
	
	public Carrera attach(Carrera carrera) {
		carreraHome.attach(carrera);
		return carrera;
	}
	
	public String nombreMateria(){
		return materia.getNombre();
	}
}
