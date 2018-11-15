package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.resource.PackageResourceReference;

import ar.edu.unq.sarmiento.wicket.carrera.ListadoDeCarrerasPage;
import ar.edu.unq.sarmiento.wicket.crearCarrera.HomeCrearCarrera;

public class HomePage extends WebPage{

	public HomePage() {
		super();
		
		this.add(new Image("image", new PackageResourceReference(HomePage.class, "logoEscuela.png")));
		this.add(new Link<String>("listadoDeCarreras") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCarrerasPage());
			}

		});

	}
	
}
