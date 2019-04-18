package ar.edu.unq.sarmiento.wicket.materia;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;
import ar.edu.unq.sarmiento.wicket.utils.BotonConfirmar;

public class ListadoDeMateriasPage extends LayoutPage {

	@SpringBean(name = "listadoDeMateriasController")
	private ListadoDeMateriasController controller;
	@Autowired
	private Carrera carrera1;

	public ListadoDeMateriasPage() {
		this.listadoMaterias();
		this.agregarMateria();
	}

	public ListadoDeMateriasPage(Carrera carrera) {
		carrera1 = carrera;
		controller.setCarrera(carrera1);
		this.listadoMaterias();
		this.agregarMateria();
	}

	public void listadoMaterias() {
		this.add(new Label("nombreCarrera", new PropertyModel<>(controller, "nombreCarrera")));
		this.add(new ListView<Materia>("materias", new PropertyModel<>(controller, "materias")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Materia> item) {
				CompoundPropertyModel<Materia> materia = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", new PropertyModel<>(materia, "nombre")));
				item.add(new Label("año", new PropertyModel<>(materia, "anioEnCarrera")));
				item.add(new Label("promocionable",
						controller.convertirString(item.getModelObject().isPromocionable())));
				item.add(new Label("docente", new PropertyModel<>(materia, "docente")));
				item.add(new Label("correlativas", controller.getCorrelativas(item.getModelObject())));

				item.add(new Link<String>("correlativa"){
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						controller.attach(carrera1);
						controller.attachMateria(item.getModelObject());
						this.setResponsePage(new AgregarCorrelativa(item.getModelObject(),carrera1));
					}
				});

				item.add(new Link<String>("borrarCorrelativa"){
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						controller.attachMateria(item.getModelObject());
						this.setResponsePage(new QuitarCorrelativaPage(item.getModelObject(), carrera1));
					}
				});

				Form<ListadoDeMateriasController> eliminarAlumnoForm = new Form<ListadoDeMateriasController>("eliminarMateriaForm") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onSubmit() {
						controller.attachMateria(item.getModelObject());
						controller.eliminar(item.getModelObject());
						this.setResponsePage(new ListadoDeMateriasPage(controller.getCarreraDetached()));
					}
				};
				eliminarAlumnoForm.add(new BotonConfirmar("eliminarMateria", controller.mensajeDeEliminarMateria(item.getModelObject())){});
				item.add(eliminarAlumnoForm);
			}
		});
	}

	public void agregarMateria() {
		this.add(new Link<String>("agregarMateria") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new AgregarMateriaPage(carrera1));
			}
		});
		
	}
}
