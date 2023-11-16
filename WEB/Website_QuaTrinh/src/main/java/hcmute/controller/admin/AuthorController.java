package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.dao.AuthorDAO;
import hcmute.entity.AuthorEntity;

@WebServlet(urlPatterns = {"/admin/list-author", "/admin/edit-author/insert", "/admin/edit-author/update", "/admin/edit-author/delete", "/admin/edit-author/reset", "/admin/edit-author/delete/*", "/admin/edit-author/edit/*"})
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AuthorController() {
        super();
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        AuthorEntity author = null;
        AuthorDAO dao = new AuthorDAO(); 
        if (url.contains("delete")) {
            if (request.getParameter("authorID") != null) {
                int authorID = Integer.parseInt(request.getParameter("authorID")); 
                dao.delete(authorID);
                request.setAttribute("message", "Delete success!");
            }
        } else if (url.contains("edit")) {
            if (request.getParameter("authorID") != null) {
                author = dao.findById(Integer.parseInt(request.getParameter("authorID")));
                request.setAttribute("author", author);
            }
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/admin/author/author.jsp").forward(request, response);
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
			request.setAttribute("user", new AuthorEntity());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/author/author.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AuthorEntity author = new AuthorEntity();
			BeanUtils.populate(author, request.getParameterMap());
			AuthorDAO dao = new AuthorDAO();
			dao.insert(author);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        AuthorEntity author = new AuthorEntity();
	        BeanUtils.populate(author, request.getParameterMap());
	        AuthorDAO dao = new AuthorDAO();
	        AuthorEntity old = dao.findById(Integer.parseInt(request.getParameter("authorID")));
	        old.setAuthorName(author.getAuthorName());
	        old.setDateOfBirth(author.getDateOfBirth());
	        dao.update(old);
	        request.setAttribute("message", "Update success!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Error: " + e.getMessage());
	    }
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AuthorEntity author = new AuthorEntity();
			BeanUtils.populate(author, request.getParameterMap());
			AuthorDAO dao = new AuthorDAO();
			dao.delete(author.getAuthorID());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AuthorDAO dao = new AuthorDAO();
			List<AuthorEntity> list = dao.findAll();
			request.setAttribute("authors", list);
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
}
