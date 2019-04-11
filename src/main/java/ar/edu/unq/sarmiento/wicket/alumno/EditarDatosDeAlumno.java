package ar.edu.unq.sarmiento.wicket.alumno;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Alumno;
import ar.edu.unq.sarmiento.wicket.inscripcion.CargarInscripcionController;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class EditarDatosDeAlumno extends LayoutPage {
	
	private static final long serialVersionUID = 1L;

	@SpringBean
	private CargarInscripcionController cargarInscripcionController;
	
	public EditarDatosDeAlumno() {
		this.formulario();
	}
	public EditarDatosDeAlumno(Alumno alumno1){
		cargarInscripcionController.setAlumno2(alumno1);
		this.formulario();
	}


	private void formulario() {
		Form<CargarInscripcionController>formulario=new Form<CargarInscripcionController>("editarAlumno"){

			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit(){
				EditarDatosDeAlumno.this.cargarInscripcionController.editar();
				this.setResponsePage(new ListadoAlumnoPage());
			}
		
		};
		formulario.add(new TextField<>("nombre",new PropertyModel<>(this.cargarInscripcionController,"alumno2.nombre")));
		formulario.add(new DropDownChoice<>("genero",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.genero"),
				new PropertyModel<>(this.cargarInscripcionController,"generos"),new ChoiceRenderer<>()));	
		formulario.add(new TextField<>("dni",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.dni")));
		formulario.add(new TextField<>("lugarNacimiento",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.lugarDeNacimiento")));
		formulario.add(new TextField<>("estadoCivil",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.estadoCivil")));
		formulario.add(new TextField<>("hijos",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.hijos")));
		formulario.add(new TextField<>("familiaresACargo",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.familiaresACargo")));
		formulario.add(new TextField<>("telefono",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.telefono")));
		formulario.add(new TextField<>("telefonoAlternativo",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.telefonoAlternativo")));
		formulario.add(new TextField<>("propietarioTelefonoAlternativo",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.propietarioTelefonoAlternativo")));
		formulario.add(new TextField<>("email",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.email")));
		formulario.add(new TextField<>("calle",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.direccion.calle")));
		formulario.add(new TextField<>("altura",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.direccion.altura")));
		formulario.add(new TextField<>("departamento",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.direccion.departamento")));
		formulario.add(new TextField<>("localidad",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.direccion.localidad")));
		formulario.add(new TextField<>("partido",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.direccion.partido")));
		formulario.add(new TextField<>("codigoPostal",new PropertyModel<>(this.cargarInscripcionController,"Alumno2.direccion.codigoPostal")));	
		this.add(formulario);
		
		formulario.add(new Link<String>("cancelar") {

			private static final long serialVersionUID = 505927122883116822L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListadoAlumnoPage());
			}
		});
		formulario.add(new DropDownChoice<>(
				"carrera",
				new PropertyModel<>(cargarInscripcionController, "carreraElegida"),
				new PropertyModel<>(cargarInscripcionController, "carrerasActivadas"),
				new ChoiceRenderer<>("nombre")));
		this.add(formulario);
		
	}


}
