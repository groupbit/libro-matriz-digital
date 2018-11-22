package ar.edu.unq.sarmiento.wicket.alumno;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class ListadoAlumnoPage extends LayoutPage {

	@SpringBean(name = "listadoAlumnoController")
	private ListadoAlumnoController controller;

	public ListadoAlumnoPage() {
		ListView<Alumno> listAlumno = new ListView<Alumno>("alumnos",
				new PropertyModel<>(controller, "usuariosEnInstituto")) {

			@Override
			protected void populateItem(ListItem<Alumno> item) {
				Alumno alumno = item.getModelObject();
				CompoundPropertyModel<Alumno> alumnoModel = new CompoundPropertyModel<>(alumno);
				Label nombreAlumno = new Label("nombre", alumnoModel.bind("nombre"));
				Label telefonoAlumno = new Label("telefono", alumnoModel.bind("telefono"));
				Label dniAlumno = new Label("dni", alumnoModel.bind("dni"));
				Label mailAlumno = new Label("email", alumnoModel.bind("email"));
				item.add(nombreAlumno);
				item.add(telefonoAlumno);
				item.add(dniAlumno);
				item.add(mailAlumno);
			}
		};
		this.add(listAlumno);
	}

}
