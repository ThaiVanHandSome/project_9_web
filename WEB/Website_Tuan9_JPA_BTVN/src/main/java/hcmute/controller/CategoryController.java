package hcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import JPAConfig.JPAConfig;
import hcmute.dao.CategoryDAO;
import hcmute.entity.CategoryEntity;


@WebServlet(urlPatterns = {
	"/category/listcate",
	"/category/create",
	"/category/update",
	"/category/delete",
	"/category/reset",
	"/category/edit/*",
	"/category/delete/*",
})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String url = request.getRequestURL().toString();
	    request.setCharacterEncoding("utf-8");
	    CategoryEntity category = null;
	    CategoryDAO dao = new CategoryDAO();

	    if (url.contains("delete")) {
	        String categoryId = request.getParameter("CategoryID");
	        if (categoryId != null) {
	            try {
	                int id = Integer.parseInt(categoryId);
	                dao.delete(id);
	                request.setAttribute("message", "Delete success!");
	            } 
	            catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    } else if (url.contains("edit")) {
	        String categoryId = request.getParameter("CategoryID");
	        if (categoryId != null) {
	            try {
	                int id = Integer.parseInt(categoryId);
	                category = dao.findById(id);
	                request.setAttribute("category", category);
	            }  
	            catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    }
	    findAll(request, response);
	    request.getRequestDispatcher("/common/web/left.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		if(url.contains("create")) {
			create(request,response);
		}
		else if(url.contains("update")){
			update(request,response);
		}
		else if(url.contains("delete")) {
			delete(request,response);
		}
		else if(url.contains("reset")){
			request.setAttribute("category", new CategoryEntity());
		}
		findAll(request, response);
		request.getRequestDispatcher("/common/web/left.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryEntity category = new CategoryEntity();
			BeanUtils.populate(category, request.getParameterMap());
			CategoryDAO dao = new CategoryDAO();
			dao.insert(category);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryEntity category = new CategoryEntity();
			BeanUtils.populate(category, request.getParameterMap());
			CategoryDAO dao = new CategoryDAO();
			dao.update(category);
			request.setAttribute("message", "Update success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoryEntity category = new CategoryEntity();
			BeanUtils.populate(category, request.getParameterMap());
			CategoryDAO dao = new CategoryDAO();
			dao.delete(category.getCategoryID());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        CategoryDAO dao = new CategoryDAO();
	        List<CategoryEntity> list = dao.findAll();
	        request.setAttribute("categories", list); // Sửa thành "categories"
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Error: "+e.getMessage());
	    }
	}


}
