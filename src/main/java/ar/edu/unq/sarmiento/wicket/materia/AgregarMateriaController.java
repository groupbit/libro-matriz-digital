package ar.edu.unq.sarmiento.wicket.materia;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.CarreraHome;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;
import ar.edu.unq.sarmiento.modelo.ModelException;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class AgregarMateriaController implements Serializable {

	@Autowired
	private CarreraHome carreraHome;
	
	private static final long serialVersionUID = 1L;
	private Materia materia;
	private Carrera carrera;
	@NotNull
	private String nombre;
	private boolean promocionable = false;
	private int anioEnCarrera;
	private String docente;

	public AgregarMateriaController() {
	}

	public AgregarMateriaController(Carrera carrera1) {
		carreraHome.attach(carrera1);
		this.carrera = carrera1;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPromocionable() {
		return promocionable;
	}

	public void setPromocionable(boolean esPromocionable) {
		this.promocionable = esPromocionable;
	}

	public int getAnioEnCarrera() {
		return anioEnCarrera;
	}

	public void setAnioEnCarrera(int anioEnCarrera) {
		this.anioEnCarrera = anioEnCarrera;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public void agregarMateriaACarrera(Carrera carrera) {
		carreraHome.attach(carrera);
		Materia materia1 = new Materia();
		materia1.setNombre(nombre);
		materia1.setAnioEnCarrera(anioEnCarrera);
		materia1.setPromocionable(promocionable);
		materia1.setDocente(docente);
		carrera.agregarMateria(materia1);
	}

	public List<Integer> getListaAnios() {
		Stream<Integer> strean = IntStream.range(1, (int) carrera.getDuracion() + 1).boxed();
		return strean.collect(Collectors.toList());

	}
	
	
}