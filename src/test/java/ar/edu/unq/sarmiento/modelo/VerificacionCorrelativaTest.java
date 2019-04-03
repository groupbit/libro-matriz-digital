package ar.edu.unq.sarmiento.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VerificacionCorrelativaTest {

	
Materia robotica; Materia informatica; Materia organizacion; Materia objetosUno; Materia objetosDos;
	
	@Before
	public void setUp()throws Exception{
		objetosUno=new Materia();
		informatica=new Materia();
		robotica=new Materia();
		organizacion=new Materia();
		objetosDos=new Materia();
		
		objetosUno.addCorrelativa(informatica);
		objetosUno.addCorrelativa(robotica);
		objetosUno.addCorrelativa(organizacion);
		objetosUno.addCorrelativa(objetosDos);
		
	}

	@Test
	public void verificarSiPuedeAgregarCorrelativa(){
		assertEquals(4,objetosUno.getCorrelativas().size());
		objetosUno.addCorrelativa(objetosDos);
		assertEquals(5, objetosUno.getCorrelativas().size());	
		
	}	
}
