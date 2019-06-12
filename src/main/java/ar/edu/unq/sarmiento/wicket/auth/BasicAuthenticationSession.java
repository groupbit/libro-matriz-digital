package ar.edu.unq.sarmiento.wicket.auth;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class BasicAuthenticationSession extends AuthenticatedWebSession {
	public BasicAuthenticationSession(Request request) {
		super(request);		
	}

	@Override
	public boolean authenticate(String username, String password) {
		return username.equals("admin") && password.equals("admin1234");
	}

	@Override
	public Roles getRoles() {
		return null;
	}
}