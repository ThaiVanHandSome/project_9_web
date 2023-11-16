package hcmute.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.model.ProductModel;
import hcmute.service.IProductService;
import hcmute.service.ProductServiceImpl;

@WebServlet(urlPatterns = {"/listproduct","/findbycategory"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IProductService productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("listproduct")) {
			List<ProductModel> list = productService.findAll();
			req.setAttribute("listproduct", list);
			req.getRequestDispatcher("/views/product/listproduct.jsp").forward(req, resp);
		}
		else if(url.contains("findbycategory")) {
			int id = Integer.parseInt(req.getParameter("CategoryID"));
			List<ProductModel> list = productService.findProductByCategory(id);
			req.setAttribute("listproduct", list);
			req.getRequestDispatcher("/views/product/listproduct.jsp").forward(req, resp);
		}
	}
	
}
