package hcmute.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcmute.models.CategoryModel;

@WebServlet(urlPatterns = {"/category/listcate"})
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement ps =null;
	ResultSet rs = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			findAll(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//hiển thị tất cả dữ liệu của Category
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//tạo các biến trung gian
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM CATEGORY";
		//xử lý bài toán
		try {
			//Kết nối database
			conn = new DBConnectionSqlServer().getConnection();
			//Đưa câu truy vấn vào và thực thi
			ps = conn.prepareStatement(sql);
			//Lấy kết quả ra ResultSet
			rs = ps.executeQuery();
			//Đọc ResultSet đưa vào model
			while(rs.next()) {
				CategoryModel cate = new CategoryModel();
				cate.setCateID(rs.getInt("id"));
				cate.setCateName(rs.getString("name"));
				cate.setImages(rs.getString("images"));
				list.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//đẩy dữ liệu ra view
		req.setAttribute("listcate", list);
		//view sẽ lấy dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listcategory.jsp");
		rd.forward(req, resp);
	}
}
