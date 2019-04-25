package ar.edu.unq.sarmiento.wicket.materia;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;
import ar.edu.unq.sarmiento.wicket.utils.SiNoDropDownChoice;

public class AgregarMateriaPage extends LayoutPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean
	private AgregarMateriaController agregarMateriasController;

	private Carrera carrera;

	public AgregarMateriaPage() {
		formularioAltaMateria();
	}

	public AgregarMateriaPage(Carrera carrera1) {
		this.carrera = carrera1;
		this.agregarMateriasController.setCarrera(carrera);
		formularioAltaMateria();
	}

	public void formularioAltaMateria() {
		Form<AgregarMateriaController> altaMateria = new Form<AgregarMateriaController>("laMateria") {
			@Override
			protected void onSubmit() {
				AgregarMateriaPage.this.agregarMateriasController.agregarMateriaACarrera(carrera);
				this.setResponsePage(new ListadoDeMateriasPage(carrera));

			}
		};

		altaMateria.add(new TextField<>("nombre", new PropertyModel<>(agregarMateriasController, "nombre")).add(new PropertyValidator<>()));
		altaMateria.add(new SiNoDropDownChoice("promocion", new PropertyModel<>(agregarMateriasController, "promocionable")));
		altaMateria.add(new TextField<>("docente", new PropertyModel<>(agregarMateriasController, "docente")));

		altaMateria.add(new DropDownChoice<>("anio", new PropertyModel<>(this.agregarMateriasController, "anioEnCarrera"),
						new PropertyModel<>(this.agregarMateriasController, "listaAnios")));

		altaMateria.add(new Link<String>("listadoMaterias") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(new ListadoDeMateriasPage(carrera));
			}
		});

		this.add(altaMateria);
	};

}
