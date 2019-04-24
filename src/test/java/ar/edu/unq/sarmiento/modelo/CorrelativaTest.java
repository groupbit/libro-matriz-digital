package ar.edu.unq.sarmiento.modelo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.modelo.Materia;
import ar.edu.unq.sarmiento.modelo.ModelException;

public class CorrelativaTest {
	
	private Materia mate;
	private Materia intro;
	private Materia obj;
	private Alumno pepe;

	@Before
	public void setup(){
		mate = new Materia();
		mate.setNombre("matematica 1");
		
		intro = new Materia ();
		intro.setNombre("introduccion a programacion");
		
		obj = new Materia ();
		obj.setNombre("Objetos 1");
		
		Carrera prog = new Carrera();
		prog.agregarMateria(mate);
		prog.agregarMateria(obj);
		prog.agregarMateria(intro);

		obj.addCorrelativa(mate);
		
		pepe = new Alumno();
		pepe.setCarrera(prog);
		
	}
	
	@Test
	public void agregarCorrelativaandaTest(){
		obj.addCorrelativa(intro);

		
		assertEquals(new HashSet<>(Arrays.asList(intro, mate)).stream().count(), obj.getCorrelativas().size());
	}
	
	@Test
	public void alumnoCursaMateriaConCorrelativa(){
		this.agregarCursadas(EstadoCursada.APROBADA_FINAL);
		
	}
	
	@Test(expected = ModelException.class)
	public void alumnoNoPuedeCursarMateriaConCorrelativa(){
		this.agregarCursadas(EstadoCursada.CURSANDO);
		
	}

	private void agregarCursadas(EstadoCursada estado) {
		Cursada cursadaMate = new Cursada();
		cursadaMate.setMateria(mate);
		cursadaMate.setEstado(estado);
		pepe.addCursada(cursadaMate);
		
		Cursada cursadaProg = new Cursada();
		cursadaProg.setMateria(obj);
		pepe.addCursada(cursadaProg);
	}
	
}
