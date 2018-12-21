package ar.edu.unq.sarmiento.wicket.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.modelo.TipoDeExamen;

public class EnumUtilsTest {

	@Test
	public void comprobarMetodoConvertirAString() {
		
		String estadoDeCursada = EnumUtils.convertirString(EstadoCursada.APROBADA_FINAL);
		String tipoExamen = EnumUtils.convertirString(TipoDeExamen.PARCIAL);
		
		assertEquals("Parcial", tipoExamen);
		assertEquals("Aprobada final", estadoDeCursada);
	}
}
