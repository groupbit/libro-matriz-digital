package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.resource.PackageResourceReference;

import ar.edu.unq.sarmiento.wicket.alumno.ListadoAlumnoPage;

public class HomePage extends WebPage{

	public HomePage() {
		super();
		
		this.add(new Image("image", new PackageResourceReference(HomePage.class, "logoEscuela.png")));
		this.add(new Link<String>("listadoAlumnoPage") {

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoAlumnoPage());
			}
		});
	}
	
}
