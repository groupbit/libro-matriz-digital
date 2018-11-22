package ar.edu.unq.sarmiento.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Docente extends Persistible {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private int telefono;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date fechaDeNacimiento;
	private String titulacion;
	private Direccion direccion;
	@OneToMany(mappedBy = "docente")
	private List<Materia> materiasQueDicta;
	private SituacionDeRevista situacion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public List<Materia> getMateriasQueDicta() {
		return materiasQueDicta;
	}
	public void setMateriasQueDicta(List<Materia> materiasQueDicta) {
		this.materiasQueDicta = materiasQueDicta;
	}
	public SituacionDeRevista getSituacion() {
		return situacion;
	}
	public void setSituacion(SituacionDeRevista situacion) {
		this.situacion = situacion;
	}
	
}
