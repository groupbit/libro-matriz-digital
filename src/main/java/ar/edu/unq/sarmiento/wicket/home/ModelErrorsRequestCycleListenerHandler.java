package ar.edu.unq.sarmiento.wicket.home;

import org.apache.wicket.core.request.handler.IPageRequestHandler;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.IRequestCycleListener;
import org.apache.wicket.request.cycle.PageRequestHandlerTracker;
import org.apache.wicket.request.cycle.RequestCycle;

import ar.edu.unq.sarmiento.modelo.ModelException;

final class ModelErrorsRequestCycleListenerHandler implements IRequestCycleListener {
	@Override
	public IRequestHandler onException(RequestCycle cycle, Exception ex) {
		if (!esErrorDelModelo(ex)) {
			return handlerOriginal(cycle);
		} 
		
		try {
			return mostrarErrorEnFeedbackPanel(cycle, ex);
		} catch (Exception e) {
			return handlerOriginal(cycle);
		}
	}

	private IRequestHandler handlerOriginal(RequestCycle cycle) {
		return cycle.getActiveRequestHandler();
	}

	private boolean esErrorDelModelo(Exception ex) {
		return ex instanceof ModelException;
	}

	private IRequestHandler mostrarErrorEnFeedbackPanel(RequestCycle cycle, Exception ex) {
		IPageRequestHandler last = PageRequestHandlerTracker.getLastHandler(cycle);
		WebPage page = (WebPage) (last.getPage());
		page.error(ex.getMessage());
		return new RenderPageRequestHandler(new PageProvider(page));
	}
}