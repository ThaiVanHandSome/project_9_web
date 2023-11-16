package hcmute.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModel;
import hcmute.models.ProductModel;
import hcmute.service.CategoryServiceImpl;
import hcmute.service.ICategoryService;
import hcmute.service.ProductServiceImpl;
import hcmute.service.IProductService;
@WebServlet(urlPatterns = { "/category/listcate"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Khởi tạo đối tượng service
	ICategoryService categoryService = new CategoryServiceImpl();
	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("listcate")) {
			findAll(req, resp);
		} 
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> categoryList = categoryService.findAll();
		req.setAttribute("listcate", categoryList);
		List<ProductModel> count = productService.count();
		req.setAttribute("count", count);
		RequestDispatcher rd = req.getRequestDispatcher("/web/home.jsp");
		rd.forward(req, resp);	
	}
	
}
