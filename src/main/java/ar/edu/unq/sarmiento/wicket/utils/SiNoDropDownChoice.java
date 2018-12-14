package ar.edu.unq.sarmiento.wicket.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;

public class SiNoDropDownChoice extends DropDownChoice<Boolean> {
	private static final long serialVersionUID = -9165991864318804365L;
	
	public SiNoDropDownChoice(String id, IModel<Boolean> model) {
		super(id, model, opciones(), new BooleanToSiNoRenderer());
	}

	private static List<Boolean> opciones() {
		return Arrays.asList(false, true);
	}
}
