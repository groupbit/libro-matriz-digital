package ar.edu.unq.sarmiento.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Alumno extends Persistible {

	private static final long serialVersionUID = 1L;

	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	private Direccion direccion;
	@ManyToOne
	private Carrera carrera;
	@OneToMany
	@JoinColumn(name = "alumno_id")
	private List<Cursada> cursadas = new ArrayList<>();
	private String dni;
	private LocalDate fechaDeNacimiento;
	private String lugarDeNacimiento;
	public Genero genero;
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
	@OneToOne
	private EstudioCursado titulo;

	public Alumno(){}
	
	public Alumno(String nombre,Direccion direccion,Carrera carrera,Cursada cursada,String dni,
			LocalDate fechaNacimiento,String lugarDeNacimiento,Genero genero,String estadoCivil,
			int hijos,String familiaresACargo,String telefono,String telefonoAlternativo,
			String email,boolean trabaja,String actividad,LocalTime horarioHabitual,
			String obraSocial){
		
		this.nombre=nombre;
		this.direccion=direccion;
		this.carrera=carrera;
		this.cursadas.add(cursada);
		this.dni=dni;
		this.fechaDeNacimiento=fechaNacimiento;
		this.lugarDeNacimiento=lugarDeNacimiento;
		this.genero=genero;
		this.estadoCivil=estadoCivil;
		this.email=email;
		this.trabaja=trabaja;
		this.actividad=actividad;
		this.horarioHabitual=horarioHabitual;
		this.obraSocial=obraSocial;
		
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

	public List<Cursada> getCursadas() {
		return cursadas.stream().sorted((c1, c2) -> c1.getMateria().getNombre().compareTo(c2.getMateria().getNombre()))
				.sorted((c1, c2) -> Integer.compare(c2.getAnio(), c1.getAnio())).collect(Collectors.toList());
	}

	
	public void setCursadas(List<Cursada> cursadas) {
		this.cursadas = cursadas;
	}

	public void addCursada(Cursada cursada) {
		this.validarQueMateriaElegidaEsDeCarreraDe(cursada);
		this.validarSiPuedeMatricularseAMateria(cursada);    
		this.cursadas.add(cursada);
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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
	
	public boolean puedeMatricularseA(Materia materia) {
		return materia.getCorrelativas().stream().allMatch(m -> this.estaRegularizada(m));
	}

	private boolean estaRegularizada(Materia m) {
		return this.cursadas.stream().filter(c -> c.getMateria().equals(m))
				.anyMatch(c -> c.estadoRegularizadoOAprobado());
	}

    public void validarQueMateriaElegidaEsDeCarreraDe(Cursada cursada) {
		if (this.carrera.getId() != cursada.getMateria().getCarrera().getId()) {
			throw new ModelException("No se puede inscribir a " + cursada.getMateria().getNombre() + " porque no pertenece a la carrera "
					+ this.getCarrera().getNombre());
		}
	}
    
    public void validarSiPuedeMatricularseAMateria(Cursada cursada){
        if(!this.puedeMatricularseA(cursada.getMateria())){
		    throw new ModelException("No puede matricularse en la materia "
				+ cursada.getMateria().getNombre() + 
				" porque debe sus correlativas.");
	   }
    }
}
