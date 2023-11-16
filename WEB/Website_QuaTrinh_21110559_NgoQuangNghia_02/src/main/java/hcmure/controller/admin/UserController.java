package hcmure.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.service.UserServiceImpl;
import hcmute.entity.User;
import hcmute.service.IUserService;


@WebServlet(urlPatterns = "/admin/phantrang")
public class UserController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String indexPage = req.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		// Get data từ DAO
		int countP = userService.countAll();
		// chia trang cho count
		int endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		
		List<User> users = userService.paginationPage(indexp - 1);
		req.setAttribute("users", users);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.getRequestDispatcher("/views/users/phantranguser.jsp").forward(req, resp);
	}
}
