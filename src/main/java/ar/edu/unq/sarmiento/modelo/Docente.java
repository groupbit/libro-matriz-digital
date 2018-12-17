//package ar.edu.unq.sarmiento.modelo;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Docente extends Persistible {
//
//	private String nombre;
//	private String apellido;
//	private Direccion direccion;
//	@OneToMany(mappedBy = "docente")
//	private List<Materia> materiasQueDicta;
//	
//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	public String getApellido() {
//		return apellido;
//	}
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
//	public Direccion getDireccion() {
//		return direccion;
//	}
//	public void setDireccion(Direccion direccion) {
//		this.direccion = direccion;
//	}
//	
//}
