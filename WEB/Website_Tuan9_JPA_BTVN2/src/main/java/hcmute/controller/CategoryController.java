package hcmute.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Utils.Constant;
import Utils.UploadUtils;
import hcmute.entity.CategoryEntity;
import hcmute.service.CategoryServiceImpl;
import hcmute.service.ICategoryService;
@MultipartConfig(fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*50, maxRequestSize = 1024*1024*50)
@WebServlet(urlPatterns = { "/Category/listcate", "/Category/create", "/Category/update", "/Category/delete", "/Category/reset", "/Category/delete/*", "/Category/edit/*"})
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("delete")) {
	        delete(req, resp);
	        req.setAttribute("category", new CategoryEntity());
	    } else if (url.contains("edit")) {
	    	//Nó lấy từ cái name bên view
	    	String CategoryID = req.getParameter("categoryID");
	        CategoryEntity category = categoryService.findById(Integer.parseInt(CategoryID));
	        req.setAttribute("category", category);
	    }
        findAll(req, resp);
//        req.setAttribute("tag", "cate");
        req.getRequestDispatcher("/common/web/left.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        req.setCharacterEncoding("utf-8");

        if (url.contains("create")) {
            create(req, resp);
        } 
        else if (url.contains("update")) {
            update(req, resp);
        } 
        else if (url.contains("delete")) {
            delete(req, resp);
        } 
        else if (url.contains("reset")) {
        	req.setAttribute("category", new CategoryEntity());
        }
        findAll(req, resp);
        req.getRequestDispatcher("/common/web/left.jsp").forward(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            CategoryEntity category = new CategoryEntity();
            BeanUtils.populate(category, req.getParameterMap());
            if(req.getPart("icon").getSize()!=0) {
            	String fileName = "" + System.currentTimeMillis();
                category.setIcon(UploadUtils.processUploadFiled("icon", req, Constant.DIR + "\\category\\", fileName));
            }
            categoryService.insert(category);
            req.setAttribute("message", "Create success!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            CategoryEntity category = new CategoryEntity();
            BeanUtils.populate(category, req.getParameterMap());
            CategoryEntity old = categoryService.findById(category.getCategoryID());
            if (req.getPart("icon").getSize() == 0) {
                category.setIcon(old.getIcon());
            } else {
                if (old.getIcon() != null) {
                    String fileName = old.getIcon();
                    File file = new File(Constant.DIR + "\\category\\", fileName);
                    if (file.delete()) {
                        System.out.println("Deleted successfully");
                    } else {
                        System.out.println(Constant.DIR + "\\category\\" + fileName);
                    }
                }
            	String fileName = "" + System.currentTimeMillis();
                category.setIcon(UploadUtils.processUploadFiled("icon", req, Constant.DIR + "\\category\\", fileName));
            }
            categoryService.update(category);
            req.setAttribute("category", category);
            req.setAttribute("message", "Update success!");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
        	String categoryID = request.getParameter("categoryID");
            categoryService.delete(Integer.parseInt(categoryID));
            request.setAttribute("message", "Delete success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<CategoryEntity> categoryList = categoryService.findAll();
            req.setAttribute("categories", categoryList);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
