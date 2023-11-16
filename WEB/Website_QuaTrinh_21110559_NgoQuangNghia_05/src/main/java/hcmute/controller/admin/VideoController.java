package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import hcmute.dao.VideosDAO;
import hcmute.entity.VideosEntity;

@WebServlet(urlPatterns = {"/admin/list-video", "/admin/edit-video/insert", "/admin/edit-video/update", "/admin/edit-video/delete", "/admin/edit-video/reset", "/admin/edit-video/delete/*", "/admin/edit-video/edit/*"})
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VideoController() {
        super();
    }    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        request.setCharacterEncoding("utf-8");
        VideosEntity video = null;
        VideosDAO dao = new VideosDAO(); 
        if (url.contains("delete")) {
            if (request.getParameter("videoid") != null) {
                int videoid = Integer.parseInt(request.getParameter("videoid")); 
                dao.delete(videoid);
                request.setAttribute("message", "Delete success!");
            }
        } else if (url.contains("edit")) {
            if (request.getParameter("videoid") != null) {
                video = dao.findById(Integer.parseInt(request.getParameter("videoid")));
                request.setAttribute("video", video);
            }
        }
        findAllVideos(request, response);
        request.getRequestDispatcher("/views/admin/video/video.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		if(url.contains("insert")) {
			create(request,response);
		}
		else if(url.contains("update")){
			update(request,response);
		}
		else if(url.contains("delete")) {
			delete(request,response);
		}
		else if(url.contains("reset")){
			request.setAttribute("user", new VideosEntity());
		}
		findAllVideos(request, response);
		request.getRequestDispatcher("/views/admin/video/video.jsp").forward(request, response);
	}
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideosEntity video = new VideosEntity();
			BeanUtils.populate(video, request.getParameterMap());
			VideosDAO dao = new VideosDAO();
			dao.insert(video);
			request.setAttribute("message", "Create success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        VideosEntity video = new VideosEntity();
	        BeanUtils.populate(video, request.getParameterMap());
	        VideosDAO dao = new VideosDAO();
	        VideosEntity old = dao.findById(Integer.parseInt(request.getParameter("videoid")));
	        old.setVideoid(video.getVideoid());
	        old.setTitle(video.getTitle());
	        old.setPoster(video.getPoster());
	        old.setViews(video.getViews());
	        old.setDescription(video.getDescription());
	        old.setActive(video.getActive());
	        old.setCategory(video.getCategory());
	        dao.update(old);
	        request.setAttribute("message", "Update success!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Error: " + e.getMessage());
	    }
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideosEntity video = new VideosEntity();
			BeanUtils.populate(video, request.getParameterMap());
			VideosDAO dao = new VideosDAO();
			dao.delete(video.getVideoid());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	protected void findAllVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideosDAO videoDAO = new VideosDAO();
    	String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		Long countP = videoDAO.countAll();
		Long endPage = countP / 3;
		if (countP % 3 != 0) {
			endPage++;
		}
		List<VideosEntity> videos = videoDAO.paginationPage(indexp - 1, 3);
		request.setAttribute("videos", videos);
		request.setAttribute("countAll", countP);
		request.setAttribute("endP", endPage);
		request.setAttribute("tag", indexp);
    }	
}
