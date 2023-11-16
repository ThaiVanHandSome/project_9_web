package hcmute.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.dao.VideosDAO;
import hcmute.entity.VideosEntity;

@WebServlet(urlPatterns = { "/admin/home", "/admin/video", "/admin/overview-video" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();

		if (url.contains("/admin/home")) {
			req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
		} else if (url.contains("/admin/video")) {
			findAllVideos(req, resp);
			req.getRequestDispatcher("/views/admin/video/video.jsp").forward(req, resp);
		} else if (url.contains("/admin/overview-video")) {
			findAllVideos(req, resp);
			req.getRequestDispatcher("/views/admin/video/overview-video.jsp").forward(req, resp);
		}

	}

	protected void findAllVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
