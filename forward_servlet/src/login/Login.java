package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String pass = req.getParameter("pass");
		
		if(pass.equals("admin")) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome"); // forward den servlet khac
			rd.forward(req, resp);
		} else {
			out.print("Fail");
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
			out.close();
		}
	}
}
