package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.dao.AuthorDAO;
import hcmute.dao.BookDAO;
import hcmute.dao.UserDAO;
import hcmute.entity.AuthorEntity;
import hcmute.entity.BooksEntity;
import hcmute.entity.UsersEntity;


@WebServlet(urlPatterns = {"/admin/home", "/admin/book", "/admin/author", "/admin/user", "/admin/overview-author",  "/admin/overview-user",  "/admin/overview-book"})
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        UsersEntity userSession = (UsersEntity) req.getSession().getAttribute("user");
        if(userSession!=null) {
            if (url.contains("/admin/home")) {
                req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
            }
            else if (url.contains("/admin/author")) {
            	findAllAuthor(req, resp);
            	req.getRequestDispatcher("/views/admin/author/author.jsp").forward(req, resp);
            }
            else if(url.contains("/admin/overview-author")) {
            	findAllAuthor(req, resp);
            	req.getRequestDispatcher("/views/admin/author/overview-author.jsp").forward(req, resp);
            }
            else if (url.contains("/admin/user")) {
            	findAllUsers(req, resp);
            	req.getRequestDispatcher("/views/admin/user/user.jsp").forward(req, resp);
            }
            else if(url.contains("/admin/overview-user")) {
            	findAllUsers(req, resp);
            	req.getRequestDispatcher("/views/admin/user/overview-user.jsp").forward(req, resp);
            }
            else if (url.contains("/admin/book")) {
            	findAllBooks(req, resp);
            	req.getRequestDispatcher("/views/admin/book/book.jsp").forward(req, resp);
            }
            else if(url.contains("/admin/overview-book")) {
            	findAllBooks(req, resp);
            	req.getRequestDispatcher("/views/admin/book/overview-book.jsp").forward(req, resp);
            }
        }
        else {
			resp.sendRedirect("/Website_QuaTrinh/login");
        }
    }

    protected void findAllAuthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void findAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDAO dao = new UserDAO();
            List<UsersEntity> list = dao.findAll(); 
            request.setAttribute("users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    protected void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDAO dao = new BookDAO();
            List<BooksEntity> list = dao.findAll(); 
            request.setAttribute("books", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    
   
}
