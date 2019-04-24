package ar.edu.unq.sarmiento.wicket.cursada;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Cursada;
import ar.edu.unq.sarmiento.wicket.crearCursada.CrearCursadaPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;
import ar.edu.unq.sarmiento.wicket.utils.BotonConfirmar;

public class ListadoDeCursadasPage extends LayoutPage {

	private static final long serialVersionUID = 1L;
	@SpringBean(name = "listadoDeCursadasController")
	private ListadoDeCursadasController controller;
	@Autowired
	private Alumno alumno1;
	
	public ListadoDeCursadasPage(Alumno alumno) {
		alumno1 = alumno;
		controller.setAlumno(alumno1);
		this.agregarCursada(alumno1);
		this.listadoDeCursadas();
		
	}

	private void agregarCursada(Alumno alumno1) {
		this.add(new Link<String>("nuevaCursada") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new CrearCursadaPage(alumno1));
			}
		});
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
				
				Form<ListadoDeCursadasController> eliminarCursadaForm = new Form<ListadoDeCursadasController>("eliminarCursadaForm") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onSubmit() {
						controller.eliminarCursada(item.getModelObject());
						this.setResponsePage(new ListadoDeCursadasPage(controller.getAlumnoDetached()));
					}
				};
				eliminarCursadaForm.add(new BotonConfirmar("eliminarCursada", controller.mensajeDeEliminacion(item.getModelObject())));
								
				item.add(eliminarCursadaForm);		
			}
		});
	}
}
