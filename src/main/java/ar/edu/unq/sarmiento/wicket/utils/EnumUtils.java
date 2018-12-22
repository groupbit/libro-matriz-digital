package ar.edu.unq.sarmiento.wicket.utils;

public class EnumUtils {

	public static String convertirString(Enum estado) {
		return estado.toString().substring(0, 1).toUpperCase() + estado.toString().toLowerCase().replace("_", " ").substring(1);
	}
}
