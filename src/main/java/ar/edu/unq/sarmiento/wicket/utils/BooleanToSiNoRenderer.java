package ar.edu.unq.sarmiento.wicket.utils;

import java.util.List;

import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

public class BooleanToSiNoRenderer implements IChoiceRenderer<Boolean> {
	private static final long serialVersionUID = 7602762203807447870L;

	@Override
	public Object getDisplayValue(Boolean object) {
		return object ? "Sí" : "No";
	}

	@Override
	public String getIdValue(Boolean object, int index) {
		return object.toString();
	}

	@Override
	public Boolean getObject(String id, IModel<? extends List<? extends Boolean>> choices) {
		return Boolean.valueOf(id);
	}
}