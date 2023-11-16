package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.service.impl.BooksServiceImpl;
import hcmute.entity.BooksEntity;
import hcmute.service.IBooksService;

@WebServlet(urlPatterns = {"/admin/list-book", "/admin/edit-book/insert", "/admin/edit-book/update", "/admin/edit-book/delete", "/admin/edit-book/reset", "/admin/edit-book/delete/*", "/admin/edit-book/edit/*"})
public class BookController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    IBooksService bookService = new BooksServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String url = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        if (url.equals(contextPath + "/admin/edit-book/delete")) {
	        delete(req, resp);
	        req.setAttribute("book", new BooksEntity());
	    } else if (url.equals(contextPath + "/admin/edit-book/edit")) {
	    	String ID = req.getParameter("bookid");
	        BooksEntity book = bookService.findById(Integer.parseInt(ID));
	        req.setAttribute("book", book);
	    }
        req.getRequestDispatcher("/views/admin/edit-books.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String url = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        req.setCharacterEncoding("utf-8");
        if (url.equals(contextPath + "/admin/edit-book/insert")) {
            create(req, resp);
        } 
        else if (url.equals(contextPath + "/admin/edit-book/update")) {
            update(req, resp);
        } 
        else if (url.equals(contextPath + "/admin/edit-book/delete")) {
            delete(req, resp);
        } 
        else if (url.equals(contextPath + "/admin/edit-book/reset")) {
        	req.setAttribute("book", new BooksEntity());
        }
        req.getRequestDispatcher("/views/admin/edit-book.jsp").forward(req, resp);
    }
    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            BooksEntity book = new BooksEntity();
            BeanUtils.populate(book, req.getParameterMap());
            bookService.insert(book);
            req.setAttribute("message", "Create success!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            BooksEntity book = new BooksEntity();
            BeanUtils.populate(book, req.getParameterMap());
            bookService.update(book);
            req.setAttribute("book", book);
            req.setAttribute("message", "Update success!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
        	String ID = request.getParameter("bookid");
            bookService.delete(Integer.parseInt(ID));
            request.setAttribute("message", "Delete success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
