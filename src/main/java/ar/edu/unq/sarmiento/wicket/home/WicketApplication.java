package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.Page;
import org.apache.wicket.bean.validation.BeanValidationConfiguration;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.PageRequestHandlerTracker;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;
import ar.edu.unq.sarmiento.hibernate.HibernateConf.HibernateMode;

public class WicketApplication extends WebApplication {
	@Override
	public Class<? extends Page> getHomePage() {
		HibernateConf.modo = HibernateMode.SERVER;
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		getRequestCycleListeners().add(new PageRequestHandlerTracker());
		getRequestCycleListeners().add(new ModelErrorsRequestCycleListenerHandler());
		new BeanValidationConfiguration().configure(this);
	}
}
