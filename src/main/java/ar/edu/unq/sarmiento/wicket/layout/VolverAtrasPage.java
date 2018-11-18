package ar.edu.unq.sarmiento.wicket.layout;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;

public abstract class VolverAtrasPage extends LayoutPage {
	public VolverAtrasPage(Page paginaAnterior) {
		this.botonVolver(paginaAnterior);
	}
	
	public void botonVolver(Page paginaAnterior) {
		this.add(new Link<String>("volver") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(paginaAnterior);
			}
		});
	}
}
