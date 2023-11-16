package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.dao.BookDAO_21110559;
import hcmute.entity.BooksEntity_21110559;

@WebServlet(urlPatterns = {"/admin/list-book", "/admin/edit-book/insert", "/admin/edit-book/update", "/admin/edit-book/delete", "/admin/edit-book/reset", "/admin/edit-book/delete/*", "/admin/edit-book/edit/*"})
public class BookController_21110559 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookController_21110559() {
        super();
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        BooksEntity_21110559 book = null;
        BookDAO_21110559 dao = new BookDAO_21110559(); 
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
        request.getRequestDispatcher("/views/admin/book/book-21110559.jsp").forward(request, response);
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
			request.setAttribute("user", new BooksEntity_21110559());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/admin/book/book-21110559.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BooksEntity_21110559 book = new BooksEntity_21110559();
			BeanUtils.populate(book, request.getParameterMap());
			BookDAO_21110559 dao = new BookDAO_21110559();
			dao.insert(book);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BooksEntity_21110559 book = new BooksEntity_21110559();
			BeanUtils.populate(book, request.getParameterMap());
			BookDAO_21110559 dao = new BookDAO_21110559();
			int bookid = Integer.parseInt(request.getParameter("bookid"));
			BooksEntity_21110559 old = dao.findById(bookid);
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
			BooksEntity_21110559 book = new BooksEntity_21110559();
			BeanUtils.populate(book, request.getParameterMap());
			BookDAO_21110559 dao = new BookDAO_21110559();
			dao.delete(book.getBookid());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO_21110559 bookDAO = new BookDAO_21110559();
    	String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		Long countP = bookDAO.countAll();
		Long endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		List<BooksEntity_21110559> books = bookDAO.paginationPage(indexp - 1, 3);
		request.setAttribute("books", books);
		request.setAttribute("countAll", countP);
		request.setAttribute("endP", endPage);
		request.setAttribute("tag", indexp);
    }

}
