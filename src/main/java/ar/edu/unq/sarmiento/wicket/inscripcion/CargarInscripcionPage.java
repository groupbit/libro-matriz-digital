package ar.edu.unq.sarmiento.wicket.inscripcion;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.hibernate.AlumnoHome;
import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.wicket.alumno.ListadoAlumnoPage;
import ar.edu.unq.sarmiento.wicket.carrera.ListadoDeCarrerasPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class CargarInscripcionPage extends LayoutPage{

	private static final long serialVersionUID = 1L;

	@SpringBean
	private CargarInscripcionController cargarInscripcionController;
	
	private AlumnoHome alumnoHome;
	
	private Alumno alumno;
	
	public CargarInscripcionPage(){
        this(new Alumno()); 		
	}

	public CargarInscripcionPage(Alumno alumno2) {
		this.alumno=alumno2;
		this.formulario();
	}

	private void formulario() {
		Form<CargarInscripcionController>formulario=new Form<CargarInscripcionController>("inscripcion"){

			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit(){
				CargarInscripcionPage.this.cargarInscripcionController.inscribir();
				this.setResponsePage(new ListadoAlumnoPage());
			}
		
		};
		formulario.add(new TextField<>("nombre",new PropertyModel<>(this.cargarInscripcionController,"nombre")));
		
		this.add(formulario);
		
		formulario.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoAlumnoPage());
			}
		});
		
	}



}