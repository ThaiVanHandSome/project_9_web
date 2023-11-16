package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.service.impl.UsersServiceImpl;
import hcmute.entity.UsersEntity;
import hcmute.service.IUsersService;

@WebServlet(urlPatterns = {"/admin/list-user", "/admin/edit-users/insert", "/admin/edit-users/update", "/admin/edit-users/delete", "/admin/edit-users/reset", "/admin/edit-users/delete/*", "/admin/edit-users/edit/*"})
public class UsersController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    IUsersService usersService = new UsersServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String url = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        if (url.equals(contextPath + "/admin/edit-users/delete")) {
	        delete(req, resp);
	        req.setAttribute("users", new UsersEntity());
	    } else if (url.equals(contextPath + "/admin/edit-users/edit")) {
	    	String ID = req.getParameter("id");
	        UsersEntity users = usersService.findById(Integer.parseInt(ID));
	        req.setAttribute("users", users);
	    }
        req.getRequestDispatcher("/views/admin/edit-users.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String url = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        req.setCharacterEncoding("utf-8");
        if (url.equals(contextPath + "/admin/edit-users/insert")) {
            create(req, resp);
        } 
        else if (url.equals(contextPath + "/admin/edit-users/update")) {
            update(req, resp);
        } 
        else if (url.equals(contextPath + "/admin/edit-users/delete")) {
            delete(req, resp);
        } 
        else if (url.equals(contextPath + "/admin/edit-users/reset")) {
        	req.setAttribute("users", new UsersEntity());
        }
        req.getRequestDispatcher("/views/admin/edit-users.jsp").forward(req, resp);
    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            UsersEntity users = new UsersEntity();
            BeanUtils.populate(users, req.getParameterMap());
            usersService.insert(users);
            req.setAttribute("message", "Create success!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            UsersEntity users = new UsersEntity();
            BeanUtils.populate(users, req.getParameterMap());
            usersService.edit(users);
            req.setAttribute("users", users);
            req.setAttribute("message", "Update success!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
        	String usersID = request.getParameter("id");
            usersService.delete(Integer.parseInt(usersID));
            request.setAttribute("message", "Delete success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
