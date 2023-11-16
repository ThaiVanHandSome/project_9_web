package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/helloform"})
public class PostData extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String ten = req.getParameter("ten");
		String holot = req.getParameter("hoLot");
		PrintWriter out = resp.getWriter();
		out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: "+holot);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String ten = req.getParameter("ten");
		String holot = req.getParameter("hoLot");
		PrintWriter out = resp.getWriter();
		out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: "+holot);
	}

}
