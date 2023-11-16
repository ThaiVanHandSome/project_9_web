package hcmute.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.entity.CategoryEntity;
import hcmute.service.CategoryServiceImpl;
import hcmute.service.ICategoryService;

@WebServlet(urlPatterns = { "/category/listcate", "/category/insert", "/category/update", "/category/delete" })
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Khởi tạo đối tượng service
	ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/insertcategory.jsp");
			rd.forward(req, resp);
		} else if (url.contains("listcate")) {
			findAll(req, resp);
		} else if (url.contains("update")) {
			findOne(req, resp);
		} else if (url.contains("delete")) {
			delete(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("insert")) {
			insert(req, resp);
		} else if (url.contains("update")) {
			update(req, resp);
		}

	}
	
	private void setCharacterEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			setCharacterEncoding(req,resp);
			//////////////////////////////
			String name = req.getParameter("cateName");
			String image = req.getParameter("images");
			CategoryEntity model = new CategoryEntity();
			model.setCategoryName(name);
			model.setIcon(image);
			//////////////////////////////
			categoryService.insert(model);
			req.getSession().setAttribute("message", "Thêm thành công");
		}catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Thêm thất bại. Error: " + e.getMessage());
		}
		resp.sendRedirect("listcate");
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
		try {
			setCharacterEncoding(req, resp);
			/////////////////////////////
			int id = Integer.parseInt(req.getParameter("cateID"));
			String name = req.getParameter("cateName");
			String image = req.getParameter("images");
			CategoryEntity model = new CategoryEntity();
			model.setCategoryID(id);
			model.setCategoryName(name);
			model.setIcon(image);
			////////////////////////////
			categoryService.update(model);
			req.getSession().setAttribute("message", "Cập nhật thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.getSession().setAttribute("error", "Cập nhật thất bại. Error: " + e.getMessage());
		}
		req.setAttribute("cate", new CategoryEntity());
		resp.sendRedirect("listcate");
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
		try {
			int id = Integer.parseInt(req.getParameter("CategoryID"));
			categoryService.delete(id);
			req.getSession().setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Xóa thất bại. Error: " + e.getMessage());
		}
		RequestDispatcher rd = req.getRequestDispatcher("listcate");
		rd.forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryEntity> categoryList = categoryService.findAll();
		req.setAttribute("listcate", categoryList);
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);	}

	private void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("CategoryID"));
		CategoryEntity model = categoryService.findOne(id);
		req.setAttribute("cate", model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/updatecategory.jsp");
		rd.forward(req, resp);
	}

}