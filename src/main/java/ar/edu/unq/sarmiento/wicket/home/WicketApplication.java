package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;

public class WicketApplication extends WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		HibernateConf.modo = "server";
		return HomePage.class;
	}

}
