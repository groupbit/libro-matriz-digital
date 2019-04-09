package ar.edu.unq.sarmiento.wicket.cursada;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class EditarCursadaPage extends LayoutPage {

	private static final long serialVersionUID = 1L;
	@Autowired
	private Alumno alumno;
	@Autowired
	private Cursada cursada1;
	@SpringBean
	private EditarCursadaController editarCursadaController;

	public EditarCursadaPage(Alumno alumno,Cursada cursada1) {
		this.alumno=alumno;
		this.cursada1 = cursada1;
		this.editarCursadaController.setCursada(cursada1);
		this.editarCursada();
	}

	public EditarCursadaPage() {
		this.editarCursada();
	}

	public void editarCursada() {
		Form<EditarCursadaController> cursada = new Form<EditarCursadaController>("laCursada") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				EditarCursadaPage.this.editarCursadaController.editarCursada();
				this.setResponsePage(new ListadoDeCursadasPage(alumno));

			}
		};

		cursada.add(new TextField<>("nota", new PropertyModel<>(this.editarCursadaController, "cursada.notaFinal")).add(new PropertyValidator<>()));
		cursada.add(new TextField<>("año", new PropertyModel<>(this.editarCursadaController, "cursada.anio")).add(new PropertyValidator<>()));
		cursada.add(new Label("materia", new PropertyModel<>(this.editarCursadaController, "cursada.materia.nombre")));
		cursada.add(new DropDownChoice<>("estado", 
				new PropertyModel<>(editarCursadaController, "cursada.estado"),
				new PropertyModel<>(editarCursadaController, "estadosCursada"),
				new ChoiceRenderer<>()));

		this.add(cursada);
	}
}
