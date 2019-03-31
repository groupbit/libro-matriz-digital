package ar.edu.unq.sarmiento.wicket.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;

public class CorrelativaTest {
	
	@Test
	public void agregarCorrelativaandaTest(){
		Carrera prog = new Carrera();
		
		Materia mate = new Materia();
		mate.setNombre("matematica 1");
		Materia intro = new Materia ();
		intro.setNombre("introduccion a programacion");
		Materia obj = new Materia ();
		obj.setNombre("Objetos 1");
	
		prog.agregarMateria(mate);
		prog.agregarMateria(obj);
		prog.agregarMateria(intro);
		
		obj.addCorrelativa(intro);
		obj.addCorrelativa(mate);
		
		assertEquals(new HashSet<>(Arrays.asList(intro, mate)).stream().count(), obj.getCorrelativas().size());
		}	
	
}
