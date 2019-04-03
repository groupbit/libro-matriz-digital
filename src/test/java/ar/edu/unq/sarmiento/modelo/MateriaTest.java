package ar.edu.unq.sarmiento.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MateriaTest {

	
Materia robotica; Materia informatica; Materia organizacion; Materia objetosUno; Materia objetosDos;
	
	@Before
	public void setUp(){
		objetosUno=new Materia();
		objetosDos=new Materia();
		
		objetosUno.addCorrelativa(objetosDos);
		
	}

	@Test(expected=ModelException.class)
	public void verificarNoPoderAgregarLaCorrelativaDosVeces(){
		objetosUno.addCorrelativa(objetosDos);
		
	}
	@Test(expected=ModelException.class)
	public void vericarNoHayaBucle(){
		objetosDos.addCorrelativa(objetosUno);
		
	}
}
