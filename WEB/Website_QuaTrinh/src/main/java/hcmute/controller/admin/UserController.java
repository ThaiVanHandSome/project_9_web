package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.dao.UserDAO;
import hcmute.entity.AuthorEntity;
import hcmute.entity.UsersEntity;

@WebServlet(urlPatterns = {"/admin/list-user", "/admin/edit-user/insert", "/admin/edit-user/update", "/admin/edit-user/delete", "/admin/edit-user/reset", "/admin/edit-user/delete/*", "/admin/edit-user/edit/*"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserController() {
        super();
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        UsersEntity user = null;
        UserDAO dao = new UserDAO(); 
        if (url.contains("delete")) {
            if (request.getParameter("id") != null) {
                int userID = Integer.parseInt(request.getParameter("id")); 
                dao.delete(userID);
                request.setAttribute("message", "Delete success!");
            }
        } else if (url.contains("edit")) {
            if (request.getParameter("id") != null) {
                user = dao.findById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("user", user);
            }
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/admin/user/user.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		if(url.contains("insert")) {
			create(request,response);
		}
		else if(url.contains("update")){
			update(request,response);
		}
		else if(url.contains("delete")) {
			delete(request,response);
		}
		else if(url.contains("reset")){
			request.setAttribute("user", new UsersEntity());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/user/user.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UsersEntity user = new UsersEntity();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.insert(user);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UsersEntity user = new UsersEntity();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			UsersEntity old = dao.findById(id);
			old.setEmail(user.getEmail());
			old.setFullname(user.getFullname());
			old.setPhone(user.getPhone());
			old.setPasswd(user.getPasswd());
			old.setSignup_date(user.getLast_login());
			old.setLast_login(user.getLast_login());
			old.setIs_admin(user.getIs_admin());
			dao.update(old);
			request.setAttribute("message", "Update success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UsersEntity user = new UsersEntity();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.delete(user.getId());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			List<UsersEntity> list = dao.findAll();
			request.setAttribute("users", list);
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}

}
