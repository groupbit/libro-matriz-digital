package ar.edu.unq.sarmiento.wicket.crearCarrera;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.carrera.ListadoDeCarrerasPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class CrearCarreraPage extends  LayoutPage{
	
	@SpringBean(name="crearCarreraController")
	private CrearCarreraController controller;
	
	private Carrera carrera;

	public CrearCarreraPage() {
		this(new Carrera());
	}
	public CrearCarreraPage(Carrera carrera){
		this.carrera=carrera;
		this.formularioAltaCarrera();
		
	}

	public void formularioAltaCarrera() {
		Form<CrearCarreraController> altaCarrera = new Form<CrearCarreraController>("laCarrera") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				controller.agregarCarrera();
				this.setResponsePage(new ListadoDeCarrerasPage());

			}
		};
		altaCarrera.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCarrerasPage());

			}

		});
		
		altaCarrera.add(new TextField<>("nombre", new PropertyModel<>(controller, "nombre")).add(new PropertyValidator<>()));
		altaCarrera.add(new TextField<>("resolucion", new PropertyModel<>(controller, "resolucion")).add(new PropertyValidator<>()));
		altaCarrera.add(new TextField<>("duracion", new PropertyModel<>(controller, "duracion")).add(new PropertyValidator<>()));

		this.add(altaCarrera);

	}
	

}
