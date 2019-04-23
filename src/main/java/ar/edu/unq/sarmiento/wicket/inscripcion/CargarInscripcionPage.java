package ar.edu.unq.sarmiento.wicket.inscripcion;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.extensions.markup.html.form.datetime.LocalDateTextField;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.wicket.alumno.ListadoAlumnoPage;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class CargarInscripcionPage extends LayoutPage{

	private static final long serialVersionUID = 1L;

	@SpringBean
	private CargarInscripcionController cargarInscripcionController;
	
	public CargarInscripcionPage(){
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
		formulario.add(new TextField<>("nombre",new PropertyModel<>(this.cargarInscripcionController,"nombre")).add(new PropertyValidator<>()));
		formulario.add(new DropDownChoice<>("genero",new PropertyModel<>(this.cargarInscripcionController,"genero"),
				new PropertyModel<>(this.cargarInscripcionController,"generos"),new ChoiceRenderer<>()).add(new PropertyValidator<>()));	
		formulario.add(new TextField<>("dni",new PropertyModel<>(this.cargarInscripcionController,"dni")).add(new PropertyValidator<>()));
		formulario.add(new LocalDateTextField("fechaNacimiento",new PropertyModel<>(this.cargarInscripcionController,"fechaNacimiento"), "dd/MM/yyyy").add(new PropertyValidator<>()));
		formulario.add(new TextField<>("lugarNacimiento",new PropertyModel<>(this.cargarInscripcionController,"lugarNacimiento")));
		formulario.add(new TextField<>("estadoCivil",new PropertyModel<>(this.cargarInscripcionController,"estadoCivil")));
		formulario.add(new TextField<>("hijos",new PropertyModel<>(this.cargarInscripcionController,"hijos")));
		formulario.add(new TextField<>("familiaresACargo",new PropertyModel<>(this.cargarInscripcionController,"familiaresACargo")));
		formulario.add(new TextField<>("telefono",new PropertyModel<>(this.cargarInscripcionController,"telefono")).add(new PropertyValidator<>()));
		formulario.add(new TextField<>("telefonoAlternativo",new PropertyModel<>(this.cargarInscripcionController,"telefonoAlternativo")));
		formulario.add(new TextField<>("propietarioTelefonoAlternativo",new PropertyModel<>(this.cargarInscripcionController,"propietarioTelefonoAlternativo")));
		formulario.add(new TextField<>("email",new PropertyModel<>(this.cargarInscripcionController,"email")).add(new PropertyValidator<>()));
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
		formulario.add(new DropDownChoice<>(
				"carrera",
				new PropertyModel<>(cargarInscripcionController, "carreraElegida"),
				new PropertyModel<>(cargarInscripcionController, "carrerasActivadas"),
				new ChoiceRenderer<>("nombre")).add(new PropertyValidator<>()));
		this.add(formulario);
		
	}



}
