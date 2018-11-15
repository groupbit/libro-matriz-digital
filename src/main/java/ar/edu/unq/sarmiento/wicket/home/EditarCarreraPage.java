package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

public class EditarCarreraPage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@SpringBean
	//private CarrerController carreraController;

	
	public void editarCarrera() {
		Form<CarreraController> carrera = new Form<CarreraController>("editarCarrera") {

			@Override
			protected void onSubmit() {
//				EditarCarreraPage.this.carreraController.editarCarrera();
//				this.setResponsePage(new ListadoDeCarrerasPage());
			}
		};
			carrera.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
	//			this.setResponsePage(new ListadoDeCarrerasPage());

			}

		});

		carrera.add(new TextField<>("nombre", new PropertyModel<>(this.carreaController, "nombre")));
		carrera.add(new TextField<>("resolucion", new PropertyModel<>(this.carreaController, "resolucion")));
		carrera.add(new TextField<>("duracion", new PropertyModel<>(this.carreaController, "duracion")));

		this.add(carrera);
	}

}
	
	
	
	
	
