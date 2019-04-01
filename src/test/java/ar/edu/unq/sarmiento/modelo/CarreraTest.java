package ar.edu.unq.sarmiento.modelo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarreraTest {
	private Carrera tpi;
	
	@Before
	public void setUp() {
		tpi = new Carrera();
	}

	@Test(expected=ModelException.class)
	public void noSePuedenAgregarDosMateriasConElMismoNombre() {
		tpi.agregarMateria(new Materia("Introducción a la programación"));
		tpi.agregarMateria(new Materia("Introducción a la programación"));
	}
	
	@Test
	public void sePuedenAgregarMateriasConNombresDistintos() {
		tpi.agregarMateria(new Materia("Introducción a la programación"));
		tpi.agregarMateria(new Materia("Estructuras de datos"));
		
		assertEquals(2, tpi.getListadoMaterias().size());
	}
}
