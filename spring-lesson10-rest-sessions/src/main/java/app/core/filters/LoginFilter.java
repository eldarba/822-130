package app.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import app.core.sessions.SessionContext;

public class LoginFilter implements Filter {

	private SessionContext sessionCtx;

	public LoginFilter(SessionContext sessionCtx) {
		super();
		this.sessionCtx = sessionCtx;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("token");
		if (token != null && sessionCtx.getSession(token) != null) {
			// if we are here we have a valid session
			System.out.println("session good - forwarding the request");
			chain.doFilter(request, response);
		} else {
			// if we are here we do not have a valid session
			System.out.println("NO session - block the request");
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendError(HttpStatus.UNAUTHORIZED.value(), "you are not logged in");

		}

	}

}
