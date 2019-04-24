package ar.edu.unq.sarmiento.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Materia extends Persistible {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Materia> correlativas = new ArrayList<>();
	@Column
	private boolean promocionable;
	private int anioEnCarrera;
	private String docente;
	private boolean esDificil;
	@ManyToOne
	private Carrera carrera;
	
	public Materia() {
		
	}
	
	public Materia(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void addCorrelativa(Materia materia){
        this.validarSipuedeAgregarCorrelativa(materia);
		this.correlativas.add(materia);
	}
	
	public List<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(List<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public boolean isPromocionable() {
		return promocionable;
	}

	public void setPromocionable(boolean promocionable) {
		this.promocionable = promocionable;
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
	
	public void validarSipuedeAgregarCorrelativa(Materia materia){
		if(this.correlativas.contains(materia)){
			throw new ModelException("No puede agregar "+ materia.getNombre() + " porque ya es correlativa de " + this.getNombre());
		}
		if(materia.getCorrelativas().contains(this)){
			throw new ModelException("No puedo agregar "+ this.getNombre() + " porque ya pertenece a las correlativas de " + materia.getNombre());
		}
	}

	public void eliminarCorrelatividades(Carrera carrera) {
		carrera.getListadoMaterias().stream().forEach(m -> m.getCorrelativas().remove(this));
		carrera.removerMateria(this);
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	
	

}
