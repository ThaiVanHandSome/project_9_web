package hcmure.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.dao.BookDaoImpl;
import hcmute.entity.Book;
import hcmute.entity.User;

@WebServlet(urlPatterns = { "/admin/home", "/admin/book", "/admin/overview-book" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    private static final int BOOK_MAX_PAGE_SIZE = 6;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
//		User userSession = (User) req.getSession().getAttribute("user");
//		if (userSession != null) {
			if (url.contains("/admin/home")) {
				req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
			} else if (url.contains("/admin/book")) {
				findAll(req, resp);
				req.getRequestDispatcher("/views/admin/book/book.jsp").forward(req, resp);
			} else if (url.contains("/admin/overview-book")) {
				findAll(req, resp);
				req.getRequestDispatcher("/views/admin/book/overview-book.jsp").forward(req, resp);
			}
//		} else {
//			resp.sendRedirect("/Website_QuaTrinh_21110559_NgoQuangNghia_01/login");
//		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookDaoImpl dao = new BookDaoImpl();
			List<Book> list = dao.findAll();
			request.setAttribute("books", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
