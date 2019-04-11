package ar.edu.unq.sarmiento.wicket.utils;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.Button;

public class BotonConfirmar extends Button {
	private static final long serialVersionUID = 1L;

	public BotonConfirmar(String id, String confirmationText) {
		super(id);
		this.add(new AttributeModifier("onclick", "if(!confirm('" + confirmationText + "')) return false;"));
	}
}
