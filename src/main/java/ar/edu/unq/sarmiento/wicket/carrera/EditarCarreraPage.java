package ar.edu.unq.sarmiento.wicket.carrera;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.home.HomePage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class EditarCarreraPage extends LayoutPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private CarreraController carreraController;

	public EditarCarreraPage(Carrera carrera) {
		this.carreraController.setCarrera(carrera);
		edicionDeCarrera();
	}

	public EditarCarreraPage() {
		edicionDeCarrera();
	}

	public void edicionDeCarrera() {
		Form<CarreraController> carrera = new Form<CarreraController>("editarCarrera") {

			@Override
			protected void onSubmit() {
				EditarCarreraPage.this.carreraController.modificarCarrera();
				this.setResponsePage(new ListadoDeCarrerasPage());
			}
		};
		carrera.add(new TextField<>("nombre", new PropertyModel<>(this.carreraController, "nombre")));
		carrera.add(new TextField<>("resolucion", new PropertyModel<>(this.carreraController, "resolucion")));
		carrera.add(new TextField<>("duracion", new PropertyModel<>(this.carreraController, "duracion")));

		carrera.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCarrerasPage());
			}
		});

		this.add(carrera);
	}

}
