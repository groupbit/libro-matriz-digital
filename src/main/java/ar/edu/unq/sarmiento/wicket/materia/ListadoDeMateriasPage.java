package ar.edu.unq.sarmiento.wicket.materia;

import org.apache.wicket.markup.html.basic.Label;
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
