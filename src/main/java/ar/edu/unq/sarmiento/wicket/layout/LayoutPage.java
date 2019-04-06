package ar.edu.unq.sarmiento.wicket.layout;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import ar.edu.unq.sarmiento.wicket.alumno.ListadoAlumnoPage;
import ar.edu.unq.sarmiento.wicket.carrera.ListadoDeCarrerasPage;
import ar.edu.unq.sarmiento.wicket.home.HomePage;
import ar.edu.unq.sarmiento.wicket.utils.BootstrapFeedbackPanel;

public abstract class LayoutPage extends WebPage {
	public LayoutPage() {
		this.agregarLink("homePage", HomePage.class);
		this.agregarLink("alumnosPage", ListadoAlumnoPage.class);
		this.agregarLink("carrerasPage", ListadoDeCarrerasPage.class);
		
		add(new BootstrapFeedbackPanel("feedback"));
	}
	
	private void agregarLink(String nombre, Class<? extends Page> pageClass) {
		this.add(new Link<String>(nombre) {
			@Override
			public void onClick() {
				this.setResponsePage(pageClass);
			}
		});
	}
}
