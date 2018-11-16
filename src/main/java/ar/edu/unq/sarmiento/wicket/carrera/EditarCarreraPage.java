package ar.edu.unq.sarmiento.wicket.carrera;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;

public class EditarCarreraPage extends WebPage {

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

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCarrerasPage());

			}

		});

//		carrera.add(new TextField<>("nombre", new PropertyModel<>(this.carreraController, "nombre")));
//		carrera.add(new TextField<>("resolucion", new PropertyModel<>(this.carreraController, "resolucion")));
//		carrera.add(new TextField<>("duracion", new PropertyModel<>(this.carreraController, "duracion")));

		this.add(carrera);
	}
}
