package ar.edu.unq.sarmiento.wicket.inscripcion;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.modelo.Alumno;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CargarInscripcionController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private AlumnoHome alumnoHome;
	
	private String nombre;
	private String genero;
	private String dni;
	private String fechaNacimiento;
	private String lugarNacimiento;
	private String estadoCivil;
	private int hijos;
	private String familiaresACargo;
	private String telefono;
	private String telefonoAlternativo;
	private String propietarioTelefonoAlternativo;
	private String email;
	
	
	
	public void inscribir(){
		Alumno alumno=new Alumno();
		alumno.setNombre(this.getNombre());
		alumno.setGenero(this.getGenero());
		alumno.setDni(this.getDni());
		alumno.setFechaDeNacimiento(this.getFechaNacimiento());
		alumno.setLugarDeNacimiento(this.getLugarNacimiento());
		alumno.setEstadoCivil(this.getEstadoCivil());
		alumno.setHijos(this.getHijos());
		alumno.setFamiliaresACargo(this.getFamiliaresACargo());
		alumno.setTelefono(this.getTelefono());
		alumno.setTelefonoAlternativo(this.getTelefonoAlternativo());
		alumno.setPropietarioTelefonoAlternativo(this.getPropietarioTelefonoAlternativo());
		
		alumnoHome.saveOrUpdate(alumno);
	}

	
	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public int getHijos() {
		return hijos;
	}


	public void setHijos(int hijos) {
		this.hijos = hijos;
	}


	public String getFamiliaresACargo() {
		return familiaresACargo;
	}


	public void setFamiliaresACargo(String familiaresACargo) {
		this.familiaresACargo = familiaresACargo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getTelefonoAlternativo() {
		return telefonoAlternativo;
	}


	public void setTelefonoAlternativo(String telefonoAlternativo) {
		this.telefonoAlternativo = telefonoAlternativo;
	}


	public String getPropietarioTelefonoAlternativo() {
		return propietarioTelefonoAlternativo;
	}


	public void setPropietarioTelefonoAlternativo(String propietarioTelefonoAlternativo) {
		this.propietarioTelefonoAlternativo = propietarioTelefonoAlternativo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}
	
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni){
		this.dni=dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
