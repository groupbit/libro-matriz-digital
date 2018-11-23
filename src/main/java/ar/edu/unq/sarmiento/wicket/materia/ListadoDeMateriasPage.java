package ar.edu.unq.sarmiento.wicket.materia;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.edu.unq.sarmiento.modelo.Carrera;
import ar.edu.unq.sarmiento.modelo.Materia;
import ar.edu.unq.sarmiento.wicket.layout.LayoutPage;

public class ListadoDeMateriasPage extends LayoutPage{

	@SpringBean(name="listadoDeMateriasController")
	private ListadoDeMateriasController controller;
	
	public ListadoDeMateriasPage(Carrera carrera) {
		controller.setCarrera(carrera);
		
		this.add(new ListView<Materia>("materias", new PropertyModel<>(controller, "materias")){

			@Override
			protected void populateItem(ListItem<Materia> item) {
				CompoundPropertyModel<Materia> materia = new CompoundPropertyModel<>(item.getModelObject());
				item.add(new Label("nombre", new PropertyModel<>(materia, "nombre")));
				item.add(new Label("año", new PropertyModel<>(materia, "anioEnCarrera")));
				item.add(new Label("promocionable", new PropertyModel<>(materia, "promocionableString")));
				item.add(new Label("docente", new PropertyModel<>(materia, "docente")));
			}
			
		});
		
	}
	
}
