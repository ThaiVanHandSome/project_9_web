package hcmute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import hcmute.model.CategoryModel;
import hcmute.util.HttpUtil;

public class CategoryApiController extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();
	private static final long serialVersionUID = 7733176626714241908L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		List<CategoryModel> cateModel = HttpUtil.of(req.getReader()).listModel(CategoryModel.class);
		cateModel = categoryService.getALLCategory();
		mapper.writeValue(resp.getOutputStream(), cateModel);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		cateModel = categoryService.insert(cateModel);
		mapper.writeValue(resp.getOutputStream(), "{Đã thêm thành công}");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse
	resp) throws ServletException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	req.setCharacterEncoding("UTF-8");
	resp.setContentType("application/json");
	CategoryModel cateModel =
	HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
	cateModel = categoryService.edit(cateModel);
	mapper.writeValue(resp.getOutputStream(), "{Đã cập nhật thành công}");

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel cateModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.delete(cateModel.getId());
		mapper.writeValue(resp.getOutputStream(), "{Đã xóa}");
	}
}
