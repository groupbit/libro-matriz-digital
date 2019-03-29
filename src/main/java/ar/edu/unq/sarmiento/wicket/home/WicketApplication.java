package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.IPageRequestHandler;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.IRequestCycleListener;
import org.apache.wicket.request.cycle.PageRequestHandlerTracker;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import ar.edu.unq.sarmiento.hibernate.HibernateConf;
import ar.edu.unq.sarmiento.hibernate.HibernateConf.HibernateMode;
import ar.edu.unq.sarmiento.modelo.ModelException;

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
		getRequestCycleListeners().add(new IRequestCycleListener() {
			@Override
			public IRequestHandler onException(RequestCycle cycle, Exception ex) {
				if (ex instanceof ModelException) {
					IPageRequestHandler last = PageRequestHandlerTracker.getLastHandler(cycle);
					WebPage page = (WebPage) (last.getPage());
					page.error(ex.getMessage());
					return new RenderPageRequestHandler(new PageProvider(page));
				} else {
					return cycle.getActiveRequestHandler();
				}
			}
		});
	}
}
