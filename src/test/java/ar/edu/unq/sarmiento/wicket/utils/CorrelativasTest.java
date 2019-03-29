package ar.edu.unq.sarmiento.wicket.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.sarmiento.modelo.Materia;

public class CorrelativasTest {
	
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
		
		
		
		
		
	}
}
