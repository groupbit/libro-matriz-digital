package ar.edu.unq.sarmiento.modelo;

import javax.persistence.Entity;

@Entity
public class Direccion extends Persistible {
	
	private String calle;
	
	private int altura;
	
	private String departamento;
	
	private String codigoPostal;
	
	private String localidad;
	
	private String partido;
	
	public Direccion() {}

	public Direccion(String calle, int altura, String departamento, String codigoPostal, String localidad,String partido) {
		super();
		this.calle = calle;
		this.altura = altura;
		this.departamento = departamento;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.partido=partido;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
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
	
	
	
	

}
