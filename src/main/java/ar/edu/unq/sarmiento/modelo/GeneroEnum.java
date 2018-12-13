package ar.edu.unq.sarmiento.modelo;

public enum GeneroEnum {
	
	FEMENINO("femenino"),MASCULINO("masculino"),OTROS("otros");
	
	
	private String string;
	
	private GeneroEnum(String string) {
		this.setString(string);
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
