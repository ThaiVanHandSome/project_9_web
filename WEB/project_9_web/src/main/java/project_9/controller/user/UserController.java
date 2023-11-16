package project_9.controller.user;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home"})
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String url = req.getRequestURI();
	        String contextPath = req.getContextPath();

	        if (url.equals(contextPath + "/home")) {
	            req.getRequestDispatcher("/views/user/home/home.jsp").forward(req, resp);
	        }
	    }

}
