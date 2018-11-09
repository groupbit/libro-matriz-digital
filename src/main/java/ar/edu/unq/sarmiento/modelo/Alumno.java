package ar.edu.unq.sarmiento.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Alumno extends Persistible {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private Direccion direccion;
	private Carrera carrera;
	private Cursada cursada;
	private String dni;
	private LocalDate fechaNacimiento;
	private String lugarDeNacimiento;
	private String genero;
	private String estadoCivil;
	private int hijos;
	private String familiaresACargo;
	private String telefono;
	private String telefonoAlternativo;
	private String propietarioTelefonoAlternativo;
	private String email;
	private boolean trabaja;
	private String actividad;
	private LocalTime horarioHabitual;
	private String obraSocial;
	private List<EstudioCursado>otros;
	private EstudioCursado estudioCursado;

	
	
	
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
	
	public LocalDate getFechaNacimiento(){
	    return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public void setGenero(String genero){
        this.genero=genero;
    }
    
    public String getEstadoCivil (){
        return estadoCivil;
    }
    
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil=estadoCivil;
    }
    
    public String getFamiliaresACargo(){
        return familiaresACargo;
    }
    
    public void setFamiliaresACargo(String familiaresACargo){
        this.familiaresACargo= familiaresACargo;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    
    public String getLugarDeNacimiento(){
        return lugarDeNacimiento;
    }
    
    public void setLugarDeNacimiento(String lugarDeNacimiento){
        this.lugarDeNacimiento=lugarDeNacimiento;
    }
    
    public String getEmail(){
        return email; 
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
     public String getActividad(){
        return actividad; 
    }
    
    public void setActividad(String actividad ){
        this.actividad=actividad;
    }
    
     public LocalTime getHorarioHabitualDeTrabajo(){
        return horarioHabitual; 
    }
    
    public void setHorarioHabitualDeTrabajo(LocalTime horariohabitualDeTrabajo){
        this.horarioHabitual=horariohabitualDeTrabajo;
    }
    
     public String getObraSocial(){
        return obraSocial; 
    }
    
    public void setObraSocial(String obraSocial){
        this.obraSocial=obraSocial;
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

	public LocalTime getHorarioHabitual() {
		return horarioHabitual;
	}

	public void setHorarioHabitual(LocalTime horarioHabitual) {
		this.horarioHabitual = horarioHabitual;
	}
	
	public String getTelefonoAlternativo(){
		return telefonoAlternativo;
	}
	
	public void setTelefonoAlternativo(String telefonoAlternativo){
		this.telefonoAlternativo=telefonoAlternativo;
	}
	
	public String getPropietarioTelefonoAlternativo() {
		return propietarioTelefonoAlternativo;
	}

	public void setPropietarioTelefonoAlternativo(String propietarioTelefonoAlternativo) {
		this.propietarioTelefonoAlternativo = propietarioTelefonoAlternativo;
	}

	public EstudioCursado getEstudioCursado(){
		return estudioCursado;
	}
	
	public void setEstudioCursado(EstudioCursado estudioCursado){
		this.estudioCursado=estudioCursado;
	}
	
	public String getSecundario(){
		return this.getEstudioCursado().getSecundario();
	}
	
	public void setSecundaria(String secundario){
		this.getEstudioCursado().setSecundario(secundario);	    	
	}
	
	public List<EstudioCursado>getEstudiosCursados(){
		return this.otros;
	}
	
	public void setOtros(List<EstudioCursado> otros) {
		this.otros = otros;
	}
	
	public String getEscuela(){
		return this.getEstudioCursado().getEscuela();
	}
	
	public void setEscuela(String escuela){
		this.getEstudioCursado().setEscuela(escuela);
	}
	
	public LocalDate getAnioDeEgreso(){
		return this.getEstudioCursado().getAnioEgreso();
	}
	
    public void setAnioDeEgreso(LocalDate anioEgreso){
    	  this.getEstudioCursado().setAnioEgreso(anioEgreso);
    }
	
	public String getInstitucion(){
		return this.getEstudioCursado().getInstitucion();
	}
	
	public void setInstitucion(String institucion){
		this.getEstudioCursado().setInstitucion(institucion);
	}
	
	
	
}


