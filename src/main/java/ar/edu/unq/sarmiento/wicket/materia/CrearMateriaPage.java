package ar.edu.unq.sarmiento.wicket.materia;

import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class CrearMateriaPage extends LayoutPage{
	
	@SpringBean(name="crearMateriaController")
	private CrearMateriaController controller;
	
	public CrearMateriaPage(Carrera carrera) {
		
	}
	
}
