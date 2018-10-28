package ar.edu.unq.sarmiento.wicked.home;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.request.resource.PackageResourceReference;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage() {
		this.add(new Image("image", new PackageResourceReference(HomePage.class, "logoEscuela.png")));
		
	}
}
