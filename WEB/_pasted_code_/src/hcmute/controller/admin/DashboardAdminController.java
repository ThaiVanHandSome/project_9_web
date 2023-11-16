package hcmute.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/home", "/admin/overview/users", "/admin/overview/author", "/admin/edit/users", "/admin/edit/author"})
public class DashboardAdminController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("/overview/users")) {
        	req.getRequestDispatcher("/views/admin/overview-users").forward(req, resp);
        } 
        else if (url.contains("/overview/author")) {
        	req.getRequestDispatcher("/views/admin/overview-author").forward(req, resp);
	    }
        else if(url.contains("/edit/users")) {
        	req.getRequestDispatcher("/views/admin/edit-users").forward(req, resp);
        }
        else if(url.contains("/edit/author")) {
        	req.getRequestDispatcher("/views/admin/edit-author").forward(req, resp);
        }
    }
}
