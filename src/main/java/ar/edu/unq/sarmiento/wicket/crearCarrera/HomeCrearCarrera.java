package ar.edu.unq.sarmiento.wicket.crearCarrera;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.home.HomePage;

public class HomeCrearCarrera extends  WebPage{
	
	@SpringBean(name="controllerHomeCrearCarrera")
	private ControllerHomeCrearCarrera controller;
	private Carrera carrera;

	public HomeCrearCarrera() {
		super();
		this.formularioAltaCarrera();

	}
	public HomeCrearCarrera(Carrera carrera){
		this.carrera=carrera;
		this.formularioAltaCarrera();
		
	}

	public void formularioAltaCarrera() {
		Form<ControllerHomeCrearCarrera> altaCarrera = new Form<ControllerHomeCrearCarrera>("laCarrera") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				controller.agregarCarrera();
				this.setResponsePage(new HomePage());

			}
		};
		altaCarrera.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new HomePage());

			}

		});
//		altaCarrera.add(new Link<String>("agregarLaMateria") {
//
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void onClick() {
//				// AgregarCarreraPage.this.controller.getMaterias();
//				// this.setResponsePage(new
//				// MateriaPage(controller.getCarrera()));
//			}

		//});

		altaCarrera.add(new TextField<>("nombre", new PropertyModel<>(controller, "nombre")));
//		altaCarrera.add(new TextField<>("resolucion", new PropertyModel<>(this.controller, "resolucion")));
//		altaCarrera.add(new TextField<>("duracion", new PropertyModel<>(this.controller, "duracion")));

		this.add(altaCarrera);

	}
	

}
