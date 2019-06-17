package ar.edu.unq.sarmiento.wicket.auth;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import ar.edu.unq.sarmiento.utils.Env;

public class BasicAuthenticationSession extends AuthenticatedWebSession {
	private String adminUser;
	private String adminPassword;

	public BasicAuthenticationSession(Request request) {
		super(request);		
		this.adminUser = Env.getOrElse("ADMIN_USER", "admin");
		this.adminPassword = Env.getOrElse("ADMIN_PASSWORD", "admin");
	}

	@Override
	public boolean authenticate(String username, String password) {
		return username.equals(this.adminUser) && password.equals(this.adminPassword);
	}

	@Override
	public Roles getRoles() {
		return null;
	}
}