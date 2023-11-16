package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.dao.BookDAO;
import hcmute.entity.AuthorEntity;
import hcmute.entity.BooksEntity;

@WebServlet(urlPatterns = {"/admin/list-book", "/admin/edit-book/insert", "/admin/edit-book/update", "/admin/edit-book/delete", "/admin/edit-book/reset", "/admin/edit-book/delete/*", "/admin/edit-book/edit/*"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookController() {
        super();
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        BooksEntity book = null;
        BookDAO dao = new BookDAO(); 
        if (url.contains("delete")) {
            if (request.getParameter("bookid") != null) {
                int bookID = Integer.parseInt(request.getParameter("bookid")); 
                dao.delete(bookID);
                request.setAttribute("message", "Delete success!");
            }
        } else if (url.contains("edit")) {
            if (request.getParameter("bookid") != null) {
                book = dao.findById(Integer.parseInt(request.getParameter("bookid")));
                request.setAttribute("book", book);
            }
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/admin/book/book.jsp").forward(request, response);
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
			request.setAttribute("user", new BooksEntity());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/book/book.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BooksEntity book = new BooksEntity();
			BeanUtils.populate(book, request.getParameterMap());
			BookDAO dao = new BookDAO();
			dao.insert(book);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BooksEntity book = new BooksEntity();
			BeanUtils.populate(book, request.getParameterMap());
			BookDAO dao = new BookDAO();
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			BooksEntity old = dao.findById(bookid);
			old.setIsbn(book.getIsbn());
			old.setTitle(book.getTitle());
			old.setPublisher(book.getPublisher());
			old.setPrice(book.getPrice());
			old.setDescription(book.getDescription());
			old.setPublish_date(book.getPublish_date());
			old.setCover_image(book.getCover_image());
			old.setQuantity(book.getQuantity());
			dao.update(old);
			request.setAttribute("message", "Update success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BooksEntity book = new BooksEntity();
			BeanUtils.populate(book, request.getParameterMap());
			BookDAO dao = new BookDAO();
			dao.delete(book.getBookid());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BookDAO dao = new BookDAO();
			List<BooksEntity> list = dao.findAll();
			request.setAttribute("books", list);
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}

}
