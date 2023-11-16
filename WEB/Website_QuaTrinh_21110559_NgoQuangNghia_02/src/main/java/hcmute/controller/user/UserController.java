package hcmute.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.dao.AuthorDaoImpl;
import hcmute.dao.BookDaoImpl;
import hcmute.dao.UserDaoImpl;
import hcmute.entity.Author;
import hcmute.entity.Book;
import hcmute.entity.User;

@WebServlet(urlPatterns = { "/home", "/product", "/login", "/user-rating", "/book-author", "/list-author" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String url = req.getRequestURI();
//	    User userSession = (User) req.getSession().getAttribute("user");
	    if (url.contains("/home")) {
	        req.getRequestDispatcher("/views/users/home.jsp").forward(req, resp);
	        return; 
	    }
	    else if (url.contains("/login")) {
		        req.getRequestDispatcher("/views/users/login.jsp").forward(req, resp);
		        return; 
		}
//	    if (userSession != null) {
	    	if (url.contains("/product")) {
				findAllBooks(req, resp);
				req.getRequestDispatcher("/views/users/product.jsp").forward(req, resp);
			} else if (url.contains("/list-author")) {
				doGetAuthorID(req, resp);
			} else if (url.contains("/book-author")) {
				doGetBookAuthor(req, resp);
			}
//	    } else {
//			resp.sendRedirect("/Website_QuaTrinh_21110559_NgoQuangNghia_02/login");
//	    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		if (url.contains("login")) {
			login(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("passwd");
		int count = 0;
		try {
			UserDaoImpl dao = new UserDaoImpl();
			User user = dao.findOne(Integer.parseInt(id));
			if (id.isEmpty() || pass.isEmpty()) {
				request.getSession().setAttribute("user", null);
			}
			if (!user.getPasswd().equals(pass)) {
				request.setAttribute("message_pass", "Sai mật khẩu!");
			} else {
				request.setAttribute("message_username", "Đăng nhập thành công!");
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("account", user.getId());
				count = 1;
			}
		} catch (Exception e) {
			request.setAttribute("message_username", "Sai tên đăng nhập!");
		}
		if (count == 1) {
			response.sendRedirect("home");
		} else {
			response.sendRedirect("/Website_QuaTrinh_21110559_NgoQuangNghia_02/login");
		}
	}
	private void doGetAuthorID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AuthorDaoImpl authorDAO = new AuthorDaoImpl();
		List<Author> author = authorDAO.findAll();
		request.setAttribute("authors", author);
		request.getRequestDispatcher("/views/users/list-author.jsp").forward(request, response);
	}

	private void doGetBookAuthor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int author_id = Integer.parseInt(req.getParameter("authorID"));
		BookDaoImpl bookDao = new BookDaoImpl();
		AuthorDaoImpl authorDao = new AuthorDaoImpl();
		List<Book> book = bookDao.findBookByAuthor(author_id);
		req.setAttribute("books", book);
		List<Author> author = authorDao.findAuthorByAuthor(author_id);
		req.setAttribute("authors", author);
		req.getRequestDispatcher("/views/users/book-author.jsp").forward(req, resp);
	}

	protected void findAllBooks(HttpServletRequest request, HttpServletResponse response)
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
