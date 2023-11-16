package hcmute.controller;


import java.io.IOException;
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
import hcmute.service.IProductService;
import hcmute.service.ProductServiceImpl;

@WebServlet(urlPatterns = {"/category/listcate/findbycategory","/product/category/listcate/findbycategory"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IProductService productService = new ProductServiceImpl();
	ICategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("/product/category/listcate/findbycategory")) {
			int id = Integer.parseInt(req.getParameter("ProductID"));
			ProductModel list = productService.findOne(id);
			req.setAttribute("product", list);
			List<CategoryModel> categoryList = categoryService.findAll();
			req.setAttribute("listcate", categoryList);
			String setactive = (String) req.getSession().getAttribute("setactive");
            req.setAttribute("setactive", setactive);
            List<ProductModel> count = productService.count();
    		req.setAttribute("count", count);
			req.getRequestDispatcher("/web/home2.jsp").forward(req, resp);
		}
		else if(url.contains("/category/listcate/findbycategory")) {
			int id = Integer.parseInt(req.getParameter("CategoryID"));
			List<ProductModel> list = productService.findProductByCategory(id);
			req.setAttribute("listproduct", list);
			List<CategoryModel> categoryList = categoryService.findAll();
			req.setAttribute("listcate", categoryList);
			String CategoryID = req.getParameter("CategoryID");
			req.getSession().setAttribute("setactive", CategoryID );
			List<ProductModel> count = productService.count();
			req.setAttribute("count", count);
			req.getRequestDispatcher("/web/home.jsp").forward(req, resp);
		}
	}
}
