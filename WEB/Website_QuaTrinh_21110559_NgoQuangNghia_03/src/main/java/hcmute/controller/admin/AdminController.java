package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.AuthorEntity;
import hcmute.entity.BooksEntity;
import hcmute.entity.UsersEntity;
import hcmute.service.IUsersService;
import hcmute.service.impl.UsersServiceImpl;
import hcmute.service.IAuthorService;
import hcmute.service.impl.AuthorServiceImpl;
import hcmute.service.IBooksService;
import hcmute.service.impl.BooksServiceImpl;

@WebServlet(urlPatterns = {"/admin/home", "/admin/overview-users", "/admin/overview-author", "/admin/overview-book", "/admin/edit-users", "/admin/edit-author", "/admin/edit-book"})
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUsersService usersService = new UsersServiceImpl();
    IBooksService bookService = new BooksServiceImpl();
    IAuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if (url.contains("/admin/home")) {
            req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/overview-users")) {
        	findAllUsers(req,resp);
        	req.getRequestDispatcher("/views/admin/overvsiew-users.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/overview-author")) {
            findAllAuthor(req, resp);
        	req.getRequestDispatcher("/views/admin/overview-author.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/overview-book")) {
            findAllBook(req, resp);
        	req.getRequestDispatcher("/views/admin/overview-book.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/edit-users")) {
            req.getRequestDispatcher("/views/admin/edit-users.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/edit-author")) {
            req.getRequestDispatcher("/views/admin/edit-author.jsp").forward(req, resp);
        }
        else if (url.contains("/admin/edit-book")) {
            req.getRequestDispatcher("/views/admin/edit-book.jsp").forward(req, resp);
        }
    }
    private void findAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<UsersEntity> usersList = usersService.findAll();
            req.setAttribute("USERS", usersList);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    private void findAllBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<BooksEntity> bookList = bookService.findAll();
            req.setAttribute("books", bookList);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    private void findAllAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<AuthorEntity> authorList = authorService.findAll();
            req.setAttribute("authors", authorList);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
    
}
