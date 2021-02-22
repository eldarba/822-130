package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coupon.system.CompanyFacade;

@WebServlet(urlPatterns = { "/MyServlet", "/aaa", "/bbb" })
public class MyServlet extends HttpServlet {

	/*
	 * CGI - Common Gateway Interface - any software that can send output to remote
	 * clients (on the web)
	 * 
	 * Servlet = Java implementation for CGI
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private CompanyFacade cf = new CompanyFacade();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get an output object
		PrintWriter out = response.getWriter();
		// write to client
		out.println("Hello From Servlet");

		String command = request.getParameter("command");
		switch (command) {
		case "create":
			out.println(cf.create());
			break;
		case "delete":
			out.println(cf.delete());
			break;

		default:
			out.println("the command " + command + " is not supported");
			break;
		}
	}

}
