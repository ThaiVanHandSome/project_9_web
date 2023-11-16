package hcmute.controller.users;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.UsersEntity;
import hcmute.service.IUsersService;
import hcmute.service.impl.UsersServiceImpl;



@WebServlet(urlPatterns = {"/home"})
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IUsersService userServices = new UsersServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("/views/users/home.jsp").forward(req, resp);
	}
}
