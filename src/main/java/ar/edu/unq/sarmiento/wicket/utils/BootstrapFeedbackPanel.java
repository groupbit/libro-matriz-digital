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
        String css;
        switch (message.getLevel()){
            case FeedbackMessage.SUCCESS:
                css = "alert alert-success";
                break;
            case FeedbackMessage.INFO:
                css = "alert alert-info";
                break;
            case FeedbackMessage.ERROR:
                css = "alert alert-danger";
                break;
            case FeedbackMessage.WARNING:
                css = "alert alert-warning";
                break;
            default:
                css = "alert";
        }

        return css;
    }
}