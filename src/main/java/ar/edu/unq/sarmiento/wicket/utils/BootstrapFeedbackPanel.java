package ar.edu.unq.sarmiento.wicket.utils;

import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

public class BootstrapFeedbackPanel extends FeedbackPanel {

    public BootstrapFeedbackPanel(String id) {
        super(id);
    }

    public BootstrapFeedbackPanel(String id, IFeedbackMessageFilter filter) {
        super(id, filter);
    }

    @Override
    protected String getCSSClass(FeedbackMessage message) {
        String css = "alert alert-dismissible";
        switch (message.getLevel()){
            case FeedbackMessage.SUCCESS:
                css += " alert-success";
                break;
            case FeedbackMessage.INFO:
                css += " alert-info";
                break;
            case FeedbackMessage.ERROR:
                css += " alert-danger";
                break;
            case FeedbackMessage.WARNING:
                css += " alert-warning";
                break;
        }

        return css;
    }
}