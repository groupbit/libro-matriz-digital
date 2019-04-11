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

public class AgregarCorrelativa extends LayoutPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private AgregarCorrelativasController agregarCorrelativasController;
	
	@Autowired
	private Materia materia1;
	@Autowired
	private Carrera carrera;
	
	public AgregarCorrelativa(){
		this.formulario();
	}
	public AgregarCorrelativa(Materia materia, Carrera carrera1){
		materia1 = materia;
		carrera = carrera1;
		agregarCorrelativasController.setMateria(materia1);
		agregarCorrelativasController.cargarCorrelativasPosibles(carrera);
			
		this.formulario();
	}

	private void formulario() {
		this.add(new Label("nombreMateria", new PropertyModel<>(agregarCorrelativasController, "nombreMateria")));
		Form<AgregarCorrelativasController> formulario = new Form<AgregarCorrelativasController>("correlativas") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				agregarCorrelativasController.agregarCorrelativa();
				this.setResponsePage(new ListadoDeMateriasPage(carrera));
			}

		};
		formulario.add(new
				DropDownChoice<>("materia",
				new PropertyModel<>(agregarCorrelativasController, "materiaElegida"),
				new PropertyModel<>(agregarCorrelativasController, "todasLasMaterias"),
				new ChoiceRenderer<>("nombre")));
		this.add(formulario);
		formulario.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoDeMateriasPage(agregarCorrelativasController.attach(carrera)));
			}
		});

		this.add(formulario);
	}
}
