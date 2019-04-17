package ar.edu.unq.sarmiento.wicket.materia;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.hibernate.MateriaHome;
import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class QuitarCorrelativaPage extends LayoutPage{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private QuitarCorrelativaController quitarCorrelativaController;
	@Autowired
	private Materia materia1;
	@Autowired
	private Carrera carrera;
	public QuitarCorrelativaPage(Materia modelObject, Carrera carrera) {
		this.materia1 = modelObject;
		this.carrera = carrera;
		this.quitarCorrelativaController.setMateria(materia1);
		this.formulario();
	}

	private void formulario() {
		this.add(new Label("nombreMateria", new PropertyModel<>(quitarCorrelativaController, "nombreMateria")));
		Form<QuitarCorrelativaController> formulario = new Form<QuitarCorrelativaController>("quitarCorrelativas") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				quitarCorrelativaController.quitarCorrelativa();
				this.setResponsePage(new ListadoDeMateriasPage(carrera));
			}
		};
		formulario.add(new
				DropDownChoice<>("materia",
				new PropertyModel<>(quitarCorrelativaController, "correlativaElegida"),
				new PropertyModel<>(quitarCorrelativaController, "listaDeCorrelativasdeMateria"),
				new ChoiceRenderer<>("nombre")));
		
		formulario.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeMateriasPage(quitarCorrelativaController.attach(carrera)));
			}
		});

		this.add(formulario);
	}
}
