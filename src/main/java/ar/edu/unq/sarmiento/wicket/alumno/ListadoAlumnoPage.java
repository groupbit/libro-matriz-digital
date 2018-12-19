package ar.edu.unq.sarmiento.wicket.alumno;

import java.time.format.DateTimeFormatter;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.wicket.carrera.EditarCarreraPage;
import ar.edu.unq.sarmiento.wicket.cursada.ListadoDeCursadasPage;
import ar.edu.unq.sarmiento.wicket.inscripcion.CargarInscripcionPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class ListadoAlumnoPage extends LayoutPage {

	@SpringBean(name = "listadoAlumnoController")
	private ListadoAlumnoController controller;
	
	
	public ListadoAlumnoPage() {
		this.listaDeAlumno();
		this.cargarInscripcionAlumno();
		
	}
	
	public void listaDeAlumno(){
		ListView<Alumno> listAlumno = new ListView<Alumno>("alumnos",
				new PropertyModel<>(controller, "usuariosEnInstituto")) {

			@Override
			protected void populateItem(ListItem<Alumno> item) {
				Alumno alumno = item.getModelObject();
				CompoundPropertyModel<Alumno> alumnoModel = new CompoundPropertyModel<>(alumno);
				Label nombreAlumno = new Label("nombre", alumnoModel.bind("nombre"));
				Label telefonoAlumno = new Label("telefono", alumnoModel.bind("telefono"));
				Label fechaNacimientoAlumno = new Label("fechaNacimiento", alumno.getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				Label dniAlumno = new Label("dni", alumnoModel.bind("dni"));
				Label mailAlumno = new Label("email", alumnoModel.bind("email"));
				item.add(nombreAlumno);
				item.add(telefonoAlumno);
				item.add(fechaNacimientoAlumno);
				item.add(dniAlumno);
				item.add(mailAlumno);
				item.add(new Link<String>("cursadas") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new ListadoDeCursadasPage(controller.attach(item.getModelObject())));
					}
				});
			}
		};
		this.add(listAlumno);
	}

	public void cargarInscripcionAlumno() {
		this.add(new Link<String>("inscripcion") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new CargarInscripcionPage());
			}
		});
	}

}
