package ar.edu.unq.sarmiento.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private String sexo;
	private String estadoCivil;
	private String hijos;
	private String familiaresACargo;
	private String telefono;
	private String nacionalidad;
	private String email;
	private boolean trabajaAlumno;
	private String actividad;
	private LocalTime horarioHabitual;
	private String obraSocial;
	private String titulo;
	private LocalDate anioDeEgresoEstudioCursado;
	private String escuela;
	
	
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
    
    public String getSexo(){
        return sexo;
    }
    
    public void setSexo(String sexo){
        this.sexo=sexo;
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
    
    public String getNacionalidad(){
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }
    
    public String getEmail(){
        return email; 
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public boolean trabajaAlumno(){
        return trabajaAlumno;
    }
    
    public void setTrabajaAlumno(boolean bool){
        this.trabajaAlumno=bool;
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
	
	 public String getTitulo(){
        return titulo; 
    }
    
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
     public LocalDate getAnioDeEgresoEstudioCursado(){
        return anioDeEgresoEstudioCursado; 
    }
    
    public void setAnioDeEgresoEstudioCursado(LocalDate anioDeEgresoEstudioCursado){
        this.anioDeEgresoEstudioCursado=anioDeEgresoEstudioCursado;
    }
    
    public String getEscuela(){
        return escuela; 
    }
    
    public void setEscuela(String escuela){
        this.escuela=escuela;
    }
	
	
}


