package ar.edu.unq.sarmiento.wicket.inscripcion;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.modelo.Direccion;
import ar.edu.unq.sarmiento.wicket.alumno.ListadoAlumnoPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class CargarInscripcionPage extends LayoutPage{

	private static final long serialVersionUID = 1L;

	@SpringBean
	private CargarInscripcionController cargarInscripcionController;
	
	private Alumno alumno;
	
	public CargarInscripcionPage(){
		this.formulario();
	}

	
	public CargarInscripcionPage(Alumno alumno2,Direccion direccion2) {
		alumno=alumno2;
		cargarInscripcionController.setAlumno(alumno2);
        cargarInscripcionController.setDireccion(direccion2);
        alumno2.setDireccion(direccion2);
		this.formulario();
	}


	private void formulario() {
		Form<CargarInscripcionController>formulario=new Form<CargarInscripcionController>("inscripcionAlumno"){

			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit(){
				CargarInscripcionPage.this.cargarInscripcionController.inscribir();
				this.setResponsePage(new ListadoAlumnoPage());
			}
		
		};
		formulario.add(new TextField<>("nombre",new PropertyModel<>(this.cargarInscripcionController,"nombre")));
		formulario.add(new TextField<>("genero",new PropertyModel<>(this.cargarInscripcionController,"genero")));
		formulario.add(new TextField<>("dni",new PropertyModel<>(this.cargarInscripcionController,"dni")));
		formulario.add(new TextField<>("fechaNacimiento",new PropertyModel<>(this.cargarInscripcionController,"fechaNacimiento")));
		formulario.add(new TextField<>("lugarNacimiento",new PropertyModel<>(this.cargarInscripcionController,"lugarNacimiento")));
		formulario.add(new TextField<>("estadoCivil",new PropertyModel<>(this.cargarInscripcionController,"estadoCivil")));
		formulario.add(new TextField<>("hijos",new PropertyModel<>(this.cargarInscripcionController,"hijos")));
		formulario.add(new TextField<>("familiaresACargo",new PropertyModel<>(this.cargarInscripcionController,"familiaresACargo")));
		formulario.add(new TextField<>("telefono",new PropertyModel<>(this.cargarInscripcionController,"telefono")));
		formulario.add(new TextField<>("telefonoAlternativo",new PropertyModel<>(this.cargarInscripcionController,"telefonoAlternativo")));
		formulario.add(new TextField<>("propietarioTelefonoAlternativo",new PropertyModel<>(this.cargarInscripcionController,"propietarioTelefonoAlternativo")));
		formulario.add(new TextField<>("email",new PropertyModel<>(this.cargarInscripcionController,"email")));
		formulario.add(new TextField<>("calle",new PropertyModel<>(this.cargarInscripcionController,"calle")));
		formulario.add(new TextField<>("altura",new PropertyModel<>(this.cargarInscripcionController,"altura")));
		formulario.add(new TextField<>("departamento",new PropertyModel<>(this.cargarInscripcionController,"departamento")));
		formulario.add(new TextField<>("localidad",new PropertyModel<>(this.cargarInscripcionController,"localidad")));
		formulario.add(new TextField<>("partido",new PropertyModel<>(this.cargarInscripcionController,"partido")));
		formulario.add(new TextField<>("codigoPostal",new PropertyModel<>(this.cargarInscripcionController,"codigoPostal")));
	
		
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
