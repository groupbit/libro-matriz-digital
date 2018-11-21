package ar.edu.unq.sarmiento.wicket.carrera;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.crearCarrera.CrearCarreraPage;
import ar.edu.unq.sarmiento.wicket.home.HomePage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class ListadoDeCarrerasPage extends LayoutPage {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private CarreraController carreraController;

	public ListadoDeCarrerasPage() {
		this.tablaCarreras();
		this.cancelar();
		this.CrearCarrera();
	}

	public void tablaCarreras() {
		this.add(new ListView<Carrera>("lasCarreras", new PropertyModel<>(this.carreraController, "carreras")) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Carrera> item) {
				CompoundPropertyModel<Carrera> laCarrera = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", laCarrera.bind("nombre")));
				item.add(new Label("resolucion", laCarrera.bind("resolucion")));
				item.add(new Label("duracion", laCarrera.bind("duracion")));
				item.add(new Link<String>("editarCarrera") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new EditarCarreraPage(item.getModelObject()));
					}
				});
			}
		});
	}

	public void cancelar() {
		this.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());
			}
		});
	}

	public void CrearCarrera() {
		this.add(new Link<String>("carreraHome") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new CrearCarreraPage());
			}
		});
	}
}
