package ar.edu.unq.sarmiento.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Alumno extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	private Direccion direccion;
	private Carrera carrera;
	private Cursada cursada;
	private String dni;
	private LocalDate fechaDeNacimiento;
	private String lugarDeNacimiento;
	private String genero;
	private String estadoCivil;
	private int hijos;
	private String familiaresACargo;
	private String telefono;
	private String telefonoAlternativo;
	private String propietarioTelefonoAlternativo;
	private String email;
	private boolean trabaja = false;
	private String actividad;
	private LocalTime horarioHabitual;
	private String obraSocial;
	@OneToMany
	private List<EstudioCursado> otrosTitulos;
	@OneToOne//(cascade=CascadeType.ALL)
	private EstudioCursado titulo;

	public Alumno() {
	}

	public Alumno(String nombre, Direccion direccion, Carrera carrera, Cursada cursada, String dni,
			LocalDate fechaNacimiento, String lugarDeNacimiento, String genero, String estadoCivil, int hijos,
			String familiaresACargo, String telefono, String telefonoAlternativo, String email, boolean trabaja,
			String actividad, LocalTime horarioHabitual, String obraSocial, EstudioCursado titulo) {

		this.nombre = nombre;
		this.direccion = direccion;
		this.carrera = carrera;
		this.cursada = cursada;
		this.dni = dni;
		this.fechaDeNacimiento = fechaNacimiento;
		this.lugarDeNacimiento = lugarDeNacimiento;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.trabaja = trabaja;
		this.actividad = actividad;
		this.horarioHabitual = horarioHabitual;
		this.obraSocial = obraSocial;
		this.titulo = titulo;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Cursada getCursada() {
		return cursada;
	}

	public void setCursada(Cursada cursada) {
		this.cursada = cursada;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaNacimiento) {
		this.fechaDeNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	public String getLugarDeNacimiento() {
		return lugarDeNacimiento;
	}

	public void setLugarDeNacimiento(String lugarDeNacimiento) {
		this.lugarDeNacimiento = lugarDeNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public LocalTime getHorarioHabitual() {
		return horarioHabitual;
	}

	public void setHorarioHabitual(LocalTime horariohabitual) {
		this.horarioHabitual = horariohabitual;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public boolean trabaja() {
		return trabaja;
	}

	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}

	public int getHijos() {
		return hijos;
	}

	public void setHijos(int hijos) {
		this.hijos = hijos;
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

	public EstudioCursado getTitulo() {
		return titulo;
	}

	public void setTitulo(EstudioCursado titulo) {
		this.titulo = titulo;
	}

	public List<EstudioCursado> getOtrosTitulos() {
		return this.otrosTitulos;
	}

	public void setOtrosTitulos(List<EstudioCursado> otros_titulos) {
		this.otrosTitulos = otros_titulos;
	}

//	public int getAnioDeEgreso() {
//		return this.titulo.getAnioEgreso();
//	}
//
//	public void setAnioDeEgreso(int anioEgreso) {
//		this.titulo.setAnioEgreso(anioEgreso);
//	}
//
//	public String getInstitucion() {
//		return this.titulo.getNombreTitulo();
//	}
//
//	public void setInstitucion(String institucion) {
//		this.titulo.setInstitucion(institucion);
//	}
	
}
