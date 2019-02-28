package ar.edu.unq.sarmiento.modelo;


public enum Genero {
	
	FEMENINO("femenino"),MASCULINO("masculino"),OTROS("otros");
	
	private String genero;
	
	Genero(String genero){
		this.setGenero(genero);
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
