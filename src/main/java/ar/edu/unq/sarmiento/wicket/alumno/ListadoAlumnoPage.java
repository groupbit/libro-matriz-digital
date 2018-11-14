package ar.edu.unq.sarmiento.wicket.alumno;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Alumno;

public class ListadoAlumnoPage extends WebPage{

	@SpringBean(name="listadoAlumnoController")
	private ListadoAlumnoController controller;
	
	public ListadoAlumnoPage() {
		super();
		
		 ListView<Alumno> listAlumno = new ListView<Alumno>("alumnos", new PropertyModel<>(controller, "usuariosEnInstituto")) {

				@Override
				protected void populateItem(ListItem<Alumno> item) {
					Alumno alumno = item.getModelObject();
					CompoundPropertyModel<Alumno> alumnoModel = new CompoundPropertyModel<>(alumno);
					Label nombreUsuario = new Label("nombre", alumnoModel.bind("nombre"));
					item.add(nombreUsuario);
				}
			};
		this.add(listAlumno);
	}
	
}
