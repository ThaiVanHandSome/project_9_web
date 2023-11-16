package hcmute.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;



import hcmute.dao.RatingDAO_21110559;
import hcmute.dao.AuthorDAO_21110559;
import hcmute.dao.BookAuthorDAO_21110559;
import hcmute.dao.BookDAO_21110559;
import hcmute.dao.UserDAO_21110559;
import hcmute.entity.AuthorEntity_21110559;
import hcmute.entity.BooksEntity_21110559;
import hcmute.entity.UsersEntity_21110559;

@WebServlet(urlPatterns = {"/home", "/product", "/login", "/register", "/all-book","/author","/detail-book","/detail-author","/detail-review"})
public class UserController_21110559 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String url = req.getRequestURI();
	    UsersEntity_21110559 userSession = (UsersEntity_21110559) req.getSession().getAttribute("user");
	    if (url.contains("/home")) {
	        req.getRequestDispatcher("/views/users/home-21110559.jsp").forward(req, resp);
	        return; 
	    }
	    else if (url.contains("/login")) {
		        req.getRequestDispatcher("/views/users/login-21110559.jsp").forward(req, resp);
		        return; 
		}
	    else if (url.contains("/register")) {
	        req.getRequestDispatcher("/views/users/register-21110559.jsp").forward(req, resp);
	        return; 
	    }
	    if (userSession != null) {
	        if (url.contains("/product")) {
	        	findAllBooks(req, resp);
	        	req.getRequestDispatcher("/views/users/product-21110559.jsp").forward(req, resp);
	        } else if (url.contains("/all-book")) {
	            doGetAuthor(req, resp);
	        } 
	        else if (url.contains("/author")) {
	        	doGetBookAuthor(req, resp);
	        }
	        else if (url.contains("/detail-author")) {
	        	doGetDetailBookAuthor(req, resp);
	        } 
	        else if (url.contains("/detail-book")) {
	        	doGetDetailAuthor(req, resp);
	        } 
	        else if (url.contains("/detail-review")) {
	        	doGetDetailReview(req, resp);
	        } 
	    } else {
			resp.sendRedirect("/Website_QuaTrinh_21110559_NgoQuangNghia_01/login");
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		if(url.contains("login")) {
			login(request,response);
		}
		else if(url.contains("register")) {
			register(request,response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("passwd");
		int count = 0;
		try {
			UserDAO_21110559 dao = new UserDAO_21110559();
			UsersEntity_21110559 user = dao.findById(Integer.parseInt(id));
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
			response.sendRedirect("/Website_QuaTrinh_21110559_NgoQuangNghia_01/login");
		}
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO_21110559 dao = new UserDAO_21110559();
		int count = 0;
		try {
			UsersEntity_21110559 entity = new UsersEntity_21110559();
			BeanUtils.populate(entity, request.getParameterMap());
			dao.insert(entity);
			request.setAttribute("message", "Đăng ký thành công!");
			count = 1;
		} catch (Exception e) {
			request.setAttribute("message", "Lỗi đăng ký!");
		}
		if (count == 0) {
			request.getRequestDispatcher("/views/users/login-21110559.jsp").forward(request, response);
		} else {
			response.sendRedirect("login");
		}
	}
	private void doGetBookAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersEntity_21110559 user = (UsersEntity_21110559) req.getSession().getAttribute("user");
		if (user != null) {
			BookAuthorDAO_21110559 bookAuthorDAO = new BookAuthorDAO_21110559();
			BookDAO_21110559 bookDAO = new BookDAO_21110559();

			int author_id  = Integer.parseInt(req.getParameter("authorID"));
			List<BooksEntity_21110559> book = bookAuthorDAO.findBookByBookAuthor(author_id);
			List<AuthorEntity_21110559> author = bookAuthorDAO.findAuthorByBooksAuthor(author_id);
			req.setAttribute("books", book);
			req.setAttribute("authors", author);
		}
		req.getRequestDispatcher("/views/users/all-book-21110559.jsp").forward(req, resp);
	}
	private void doGetAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersEntity_21110559 user = (UsersEntity_21110559) req.getSession().getAttribute("user");
		if (user != null) {
			AuthorDAO_21110559 authorDAO = new AuthorDAO_21110559();
			List<AuthorEntity_21110559> author = authorDAO.findAll();
			req.setAttribute("authors", author);
		}
		req.getRequestDispatcher("/views/users/list-author-21110559.jsp").forward(req, resp);
	}
	private void doGetDetailBookAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersEntity_21110559 user = (UsersEntity_21110559) req.getSession().getAttribute("user");
		if (user != null) {
			BookAuthorDAO_21110559 bookAuthorDAO = new BookAuthorDAO_21110559();
			int author_id  = Integer.parseInt(req.getParameter("authorID"));
			List<BooksEntity_21110559> book = bookAuthorDAO.findBookByBookAuthor(author_id);
			List<AuthorEntity_21110559> author = bookAuthorDAO.findAuthorByBooksAuthor(author_id);
			req.setAttribute("books", book);
			req.setAttribute("authors", author);
		}
		req.getRequestDispatcher("/views/users/detail-book-21110559.jsp").forward(req, resp);
	}
	private void doGetDetailAuthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersEntity_21110559 user = (UsersEntity_21110559) req.getSession().getAttribute("user");
		if (user != null) {
			AuthorDAO_21110559 authorDAO = new AuthorDAO_21110559();
			List<AuthorEntity_21110559> author = authorDAO.findAll();
			req.setAttribute("authors", author);
		}
		req.getRequestDispatcher("/views/users/detail-author-21110559.jsp").forward(req, resp);
	}
	
	private void doGetDetailReview(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersEntity_21110559 user = (UsersEntity_21110559) req.getSession().getAttribute("user");
		if (user != null) {
			RatingDAO_21110559 ratingDAO = new RatingDAO_21110559();
			int bookid  = Integer.parseInt(req.getParameter("bookid"));
			List<UsersEntity_21110559> users = ratingDAO.findUserByRating(bookid);
			List<BooksEntity_21110559> books = ratingDAO.findBookByRating(bookid);
			List<String> reviews = ratingDAO.findReviewTextByRating(bookid);
			req.setAttribute("users", users);
			req.setAttribute("books", books);
			req.setAttribute("reviews", reviews);
		}
		req.getRequestDispatcher("/views/users/detail-review-21110559.jsp").forward(req, resp);
	}
	protected void findAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
