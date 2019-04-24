package ar.edu.unq.sarmiento.wicket.alumno;

import java.time.format.DateTimeFormatter;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.wicket.cursada.ListadoDeCursadasPage;
import ar.edu.unq.sarmiento.wicket.inscripcion.CargarInscripcionPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;
import ar.edu.unq.sarmiento.wicket.materia.AgregarCorrelativa;

public class ListadoAlumnoPage extends LayoutPage {

	@SpringBean(name = "listadoAlumnoController")
	private ListadoAlumnoController controller;

	public ListadoAlumnoPage() {
		inicializarPage();
	}

	private void inicializarPage() {
		this.cargarInscripcionAlumno();
		this.busquedaPorNombre();
	}

	public WebMarkupContainer listaDeAlumno(Form<ListadoAlumnoController> formBusqueda) {
		ListView<Alumno> listAlumno = new ListView<Alumno>("alumnos", new PropertyModel<>(controller, "alumnos")) {

			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Alumno> item) {
				Alumno alumno = item.getModelObject();
				CompoundPropertyModel<Alumno> alumnoModel = new CompoundPropertyModel<>(alumno);
				Label nombreAlumno = new Label("nombre", alumnoModel.bind("nombre"));
				Label telefonoAlumno = new Label("telefono", alumnoModel.bind("telefono"));
				Label fechaNacimientoAlumno = new Label("fechaNacimiento",
						alumno.getFechaDeNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				Label dniAlumno = new Label("dni", alumnoModel.bind("dni"));
				Label mailAlumno = new Label("email", alumnoModel.bind("email"));
				Label carreraAlumno = new Label("carrera", alumnoModel.bind("carrera.nombre"));
				item.add(nombreAlumno);
				item.add(telefonoAlumno);
				item.add(fechaNacimientoAlumno);
				item.add(dniAlumno);
				item.add(mailAlumno);
				item.add(carreraAlumno);
				item.add(new Link<String>("cursadas") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new ListadoDeCursadasPage(controller.attach(item.getModelObject())));
					}
				});
				item.add(new Link<String>("Alumno"){
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						controller.attach(item.getModelObject());
						this.setResponsePage(new EditarDatosDeAlumno(item.getModelObject()));
					}
				});
			}
		};
		
		WebMarkupContainer contenedorListado = new WebMarkupContainer("listado");
		contenedorListado.setOutputMarkupId(true);
		contenedorListado.add(listAlumno);
		
		formBusqueda.add(contenedorListado);
		
		return contenedorListado;
	}

	public void busquedaPorNombre() {
		Form<ListadoAlumnoController> formBusqueda = new Form<ListadoAlumnoController>("formBuscarNombre");
		WebMarkupContainer contenedorListado = this.listaDeAlumno(formBusqueda);
		
		TextField<Object> busquedaField = new TextField<>("nombreBuscado",
				new PropertyModel<>(this.controller, "nombreBuscado"));
		
		busquedaField.add(new OnChangeAjaxBehavior() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(contenedorListado);
			}
		});

		formBusqueda.add(busquedaField);
		this.add(formBusqueda);
	};

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
