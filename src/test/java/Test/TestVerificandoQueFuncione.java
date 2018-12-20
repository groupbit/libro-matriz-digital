package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.modelo.EstudioCursado;
import ar.edu.unq.sarmiento.modelo.TipoDeExamen;
import ar.edu.unq.sarmiento.wicket.utils.EnumUtils;

public class TestVerificandoQueFuncione {

	@Test
	public void testDeEnumUtils() {
		
		String estadoDeCursada = EnumUtils.convertirString(EstadoCursada.APROBADA_FINAL);
		String tipoExamen = EnumUtils.convertirString(TipoDeExamen.PARCIAL);
		
		assertTrue(tipoExamen.equals("Parcial"));
		assertTrue(estadoDeCursada.equals("Aprobada final"));
	}

}
