package ar.edu.unq.sarmiento.wicket.cursada;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class ListadoDeCursadasPage extends LayoutPage {

	private static final long serialVersionUID = 1L;
	@SpringBean(name = "listadoDeCursadasController")
	private ListadoDeCursadasController controller;
	@Autowired
	private Alumno alumno1;

	public ListadoDeCursadasPage(Alumno alumno) {
		alumno1 = alumno;
		controller.setAlumno(alumno1);
		this.listadoDeCursadas();
	}

	private void listadoDeCursadas() {
		this.add(new Label("nombreAlumno", new PropertyModel<>(controller, "nombreAlumno")));
		this.add(new ListView<Cursada>("cursadas", new PropertyModel<>(controller, "cursadas")) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Cursada> item) {
				CompoundPropertyModel<Cursada> cursada = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("año", new PropertyModel<>(cursada, "anio")));
				item.add(new Label("materia", new PropertyModel<>(cursada, "materia.nombre")));
				item.add(new Label("estado", controller.convertirString(item.getModelObject().getEstado())));
				item.add(new Label("notaF", new PropertyModel<>(cursada, "notaFinal")));
				item.add(new Link<String>("laCursada") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new EditarCursadaPage(alumno1,item.getModelObject()));
					}
				});
			}
		});
	}
}
