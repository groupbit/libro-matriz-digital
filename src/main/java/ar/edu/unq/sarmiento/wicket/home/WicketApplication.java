package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.Page;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.bean.validation.BeanValidationConfiguration;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.cycle.PageRequestHandlerTracker;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;
import ar.edu.unq.sarmiento.hibernate.HibernateConf.HibernateMode;
import ar.edu.unq.sarmiento.utils.Env;
import ar.edu.unq.sarmiento.wicket.auth.BasicAuthenticationSession;
import ar.edu.unq.sarmiento.wicket.auth.SignInPage;

public class WicketApplication extends AuthenticatedWebApplication {
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

	@Override
	public RuntimeConfigurationType getConfigurationType() {
		return Env.isPresent("WICKET_PRODUCTION") 
			? RuntimeConfigurationType.DEPLOYMENT 
			: RuntimeConfigurationType.DEVELOPMENT;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass(){
		return BasicAuthenticationSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return SignInPage.class;
	}
}
