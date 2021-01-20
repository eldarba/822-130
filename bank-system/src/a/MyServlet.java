package a;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//		resp.setContentType("text/plain");
		System.out.println("hi this is the sevlet");
		PrintWriter out = resp.getWriter();
		out.println("<h1>");
		out.println("hi this is the sevlet");
		out.println("</h1>");
		out.println("<br>");
		int r = (int) (Math.random() * 11);
		out.println("lucky number: " + r);
		out.println("<br>");
		out.println("date: " + LocalDateTime.now());
	}

}
