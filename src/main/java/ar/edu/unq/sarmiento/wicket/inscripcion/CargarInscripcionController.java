package ar.edu.unq.sarmiento.wicket.inscripcion;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.hibernate.DireccionHome;
import ar.edu.unq.sarmiento.hibernate.EstudioCursadoHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Direccion;
import ar.edu.unq.sarmiento.modelo.EstudioCursado;
import ar.edu.unq.sarmiento.modelo.Genero;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transactional
public class CargarInscripcionController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AlumnoHome alumnoHome;
	@Autowired
	private DireccionHome direccionHome;
	@Autowired
	private EstudioCursadoHome estudioCursadoHome;
	private String nombre;
	private Genero genero;
	private String dni;
	private LocalDate fechaNacimiento;
	private String lugarNacimiento;
	private String estadoCivil;
	private int hijos;
	private String familiaresACargo;
	private Direccion direccion;
	private String telefono;
	private String telefonoAlternativo;
	private String propietarioTelefonoAlternativo;
	private String email;
	private Alumno alumno;
	private String calle;
	private int altura;
	private String departamento;
	private String codigoPostal;
	private String localidad;
	private String partido;
	private EstudioCursado estudioCursado;
	private int anioEgreso;
	private String institucion;
	private String distrito;
	private String nombreTitulo;

	public CargarInscripcionController() {
	}

	public void inscribir() {
		alumno = new Alumno();
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
		alumno.setEmail(this.getEmail());
		Direccion dir = new Direccion();
		dir.setCalle(this.getCalle());
		dir.setAltura(this.getAltura());
		dir.setDepartamento(this.getDepartamento());
		dir.setLocalidad(this.getLocalidad());
		dir.setPartido(this.getPartido());
		dir.setCodigoPostal(this.getCodigoPostal());
		EstudioCursado estudio = new EstudioCursado();
		estudio.setAnioEgreso(this.getAnioEgreso());
		estudio.setInstitucion(this.getInstitucion());
		estudio.setDistrito(this.getDistrito());
		estudio.setNombreTitulo(this.getNombreTitulo());
		alumno.setDireccion(dir);
		alumno.setTitulo(estudio);
		estudioCursadoHome.saveOrUpdate(alumno.getTitulo());
		alumnoHome.saveOrUpdate(alumno);
		direccionHome.saveOrUpdate(alumno.getDireccion());

	}

	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCalle() {
		return this.calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
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

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public EstudioCursado getEstudioCursado() {
		return estudioCursado;
	}

	public void setEstudioCursado(EstudioCursado estudioCursado) {
		this.estudioCursado = estudioCursado;
	}

	public void setAnioEgreso(int anioEgreso) {
		this.anioEgreso = anioEgreso;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDistrito() {
		return distrito;
	}

	public String getInstitucion() {
		return institucion;
	}

	public int getAnioEgreso() {
		return anioEgreso;
	}

	public String getNombreTitulo() {
		return nombreTitulo;
	}

	public void setNombreTitulo(String nombreTitulo) {
		this.nombreTitulo = nombreTitulo;
	}

}
