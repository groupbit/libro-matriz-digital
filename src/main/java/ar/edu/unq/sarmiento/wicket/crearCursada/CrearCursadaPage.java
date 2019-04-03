package ar.edu.unq.sarmiento.wicket.crearCursada;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.EstadoCursada;
import ar.edu.unq.sarmiento.wicket.crearCarrera.CrearCarreraController;
import ar.edu.unq.sarmiento.wicket.cursada.ListadoDeCursadasPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;


public class CrearCursadaPage extends LayoutPage {

	private static final long serialVersionUID = 1L;

	private Alumno alumno;

	@SpringBean(name = "crearCursadaController")
	private CrearCursadaController crearCursadaController;

	public CrearCursadaPage(Alumno alumno) {
		this.alumno = alumno;
		this.formularioCursada();
	}

	private void formularioCursada() {
		Form<CrearCarreraController> nuevaCursada = new Form<CrearCarreraController>("cursada") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				crearCursadaController.agregarCursada(alumno);
				this.setResponsePage(new ListadoDeCursadasPage(alumno));

			}
		};
		
		nuevaCursada.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeCursadasPage(alumno));

			}

		});

		nuevaCursada.add(new TextField<>("anio",new PropertyModel<>(this.crearCursadaController,"anio")));
		nuevaCursada.add(new DropDownChoice<>(
				"materia",
				new PropertyModel<>(crearCursadaController, "materiaElegida"),
				new PropertyModel<>(crearCursadaController, "TodasLasMaterias"),
				new ChoiceRenderer<>("nombre")));
		nuevaCursada.add(new TextField<>("notaFinal",new PropertyModel<>(this.crearCursadaController,"notaFinal")));
		this.add(nuevaCursada);
		nuevaCursada.add(new DropDownChoice<>(
				"estado",
				new PropertyModel<>(crearCursadaController, "estado"),
				new PropertyModel<>(crearCursadaController, "estadosPosibles"),
				new ChoiceRenderer<>()));
	}
}
