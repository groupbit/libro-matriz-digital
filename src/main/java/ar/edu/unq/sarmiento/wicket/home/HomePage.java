package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.markup.html.link.Link;

import ar.edu.unq.sarmiento.wicket.alumno.ListadoAlumnoPage;
import ar.edu.unq.sarmiento.wicket.carrera.ListadoDeCarrerasPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class HomePage extends LayoutPage {

	public HomePage() {
		this.add(new Link<String>("listadoAlumnoPage") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoAlumnoPage());
			}
		});
		
		this.add(new Link<String>("listadoDeCarreras") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCarrerasPage());
			}

		});
	}
	
}
