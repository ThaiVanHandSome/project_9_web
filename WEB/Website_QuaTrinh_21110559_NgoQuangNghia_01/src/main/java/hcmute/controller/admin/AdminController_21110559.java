package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.dao.AuthorDAO_21110559;
import hcmute.dao.BookDAO_21110559;
import hcmute.entity.AuthorEntity_21110559;
import hcmute.entity.BooksEntity_21110559;
import hcmute.entity.UsersEntity_21110559;


@WebServlet(urlPatterns = {"/admin/home", "/admin/book",  "/admin/overview-book"})
public class AdminController_21110559 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        UsersEntity_21110559 userSession = (UsersEntity_21110559) req.getSession().getAttribute("user");
        if(userSession!=null) {
            if (url.contains("/admin/home")) {
                req.getRequestDispatcher("/views/admin/home-21110559.jsp").forward(req, resp);
            }
            else if (url.contains("/admin/book")) {
            	findAllBook(req, resp);
            	req.getRequestDispatcher("/views/admin/book/book-21110559.jsp").forward(req, resp);
            }
            else if(url.contains("/admin/overview-book")) {
            	findAllBook(req, resp);
            	req.getRequestDispatcher("/views/admin/book/overview-book-21110559.jsp").forward(req, resp);
            }
        }
        else {
			resp.sendRedirect("/Website_QuaTrinh_21110559_NgoQuangNghia_01/login");
        }
    }
    protected void findAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
