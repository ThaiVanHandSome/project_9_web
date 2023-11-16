package hcmure.controller.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.dao.BookDaoImpl;
import hcmute.entity.Book;
import hcmute.service.BookServiceimpl;
import hcmute.service.IBookService;

@WebServlet(urlPatterns = {"/admin/list-book", "/admin/edit-book/insert", "/admin/edit-book/update", "/admin/edit-book/delete", "/admin/edit-book/reset", "/admin/edit-book/delete/*", "/admin/edit-book/edit/*"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IBookService bookService= new BookServiceimpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
        req.setCharacterEncoding("utf-8");
        Book book = null;
        BookDaoImpl dao = new BookDaoImpl(); 
        if (url.contains("delete")) {
            delete(req, resp);
        } else if (url.contains("edit")) {
            if (req.getParameter("bookid") != null) {
                book = dao.findOne(Integer.parseInt(req.getParameter("bookid")));
                req.setAttribute("book", book);
            }
        }
        findAll(req, resp);
        req.getRequestDispatcher("/views/admin/book/book.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		req.setCharacterEncoding("utf-8");
		if(url.contains("insert")) {
			insert(req,resp);
		}
		else if(url.contains("update")){
			update(req,resp);
		}
		else if(url.contains("delete")) {
			delete(req,resp);
		}
		else if(url.contains("reset")){
			req.setAttribute("user", new Book());
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/admin/book/book.jsp").forward(req, resp);
	}
	private void setCharacterEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			setCharacterEncoding(req,resp);
			Book model = new Book();
			BeanUtils.populate(model, req.getParameterMap());
			bookService.insert(model);
			req.getSession().setAttribute("message", "Thêm thành công");
		}catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Thêm thất bại. Error: " + e.getMessage());
		}
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
		try {
			setCharacterEncoding(req, resp);
			Book model = new Book();
			BeanUtils.populate(model, req.getParameterMap());
			bookService.update(model);
			req.getSession().setAttribute("message", "Cập nhật thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Cập nhật thất bại. Error: " + e.getMessage());
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
		try {
			int id = Integer.parseInt(req.getParameter("bookid"));
			bookService.delete(id);
			req.getSession().setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Xóa thất bại. Error: " + e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BookDaoImpl dao = new BookDaoImpl();
			List<Book> list = dao.findAll();
			request.setAttribute("books", list);
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}

}
