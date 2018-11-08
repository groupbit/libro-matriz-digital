package ar.edu.unq.sarmiento.wicked.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.carrera.ListadoDeCarrerasPage;

public class HomePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomePage() {
		this.add(new Link<Carrera>("listadoCarreras") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCarrerasPage());

			}
		});

	}
}