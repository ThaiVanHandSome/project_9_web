package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModel;

public class CategoryDAOImpl implements iCategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		// tạo các biến trung gian
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM CATEGORY";
		// xử lý bài toán
		try {
			// Kết nối database
			conn = new DBConnectionSqlServer().getConnection();
			// Đưa câu truy vấn vào và thực thi
			ps = conn.prepareStatement(sql);
			// Lấy kết quả ra ResultSet
			rs = ps.executeQuery();
			// Đọc ResultSet đưa vào model
			while (rs.next()) {
				CategoryModel cate = new CategoryModel();
				cate.setCateID(rs.getInt("id"));
				cate.setCateName(rs.getString("name"));
				cate.setImages(rs.getString("image"));
				list.add(cate);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public CategoryModel findOne(int id) {
		String sql = "SELECT * FROM CATEGORY WHERE CATEGORY.id=?";
		
		try {
			// Kết nối database
			conn = new DBConnectionSqlServer().getConnection();
			// Đưa câu truy vấn vào và thực thi
			ps = conn.prepareStatement(sql);
			// Truyền tham số vào query
			ps.setInt(1, id);
			// Thực thi câu truy vấn
			rs = ps.executeQuery();
			CategoryModel model = new CategoryModel();
			while(rs.next()) {
				model.setCateID(rs.getInt(1));
				model.setCateName(rs.getNString(2));
				model.setImages(rs.getNString(3));
			}
			conn.close();
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(CategoryModel model) {
		// xử lý dữ liệu cho bài toán insert
		String sql = "INSERT INTO CATEGORY(name,image) values(?,?)";
		try {
			// Kết nối database
			conn = new DBConnectionSqlServer().getConnection();
			// Đưa câu truy vấn vào và thực thi
			ps = conn.prepareStatement(sql);
			// Truyền tham số vào query
			ps.setString(1, model.getCateName());
			ps.setString(2, model.getImages());
			// Thực thi câu truy vấn
			rs = ps.executeQuery();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel model) {
	    String sql = "UPDATE CATEGORY SET name = ?, image = ? WHERE id = ?";
	    
	    try {
	        // Kết nối database
	        conn = new DBConnectionSqlServer().getConnection();
	        // Đưa câu truy vấn vào và thực thi
	        ps = conn.prepareStatement(sql);
	        // Truyền tham số vào query
	        ps.setString(1, model.getCateName());
	        ps.setString(2, model.getImages());
	        ps.setInt(3, model.getCateID()); // Sử dụng trường cateID để xác định danh mục cần cập nhật
	        // Thực thi câu truy vấn
	        int rowsAffected = ps.executeUpdate();
	        conn.close();
	        if (rowsAffected > 0) {
	            System.out.println("Cap nhat thanh cong");
	        } else {
	            System.out.println("Khong co du lieu nao duoc cap nhat");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void delete(int id) {
		// xử lý dữ liệu cho bài toán insert
		String sql = "DELETE FROM CATEGORY WHERE id=?";
		try {
			// Kết nối database
			conn = new DBConnectionSqlServer().getConnection();
			// Đưa câu truy vấn vào và thực thi
			ps = conn.prepareStatement(sql);
			// Truyền tham số vào query
			ps.setInt(1, id);
			// Thực thi câu truy vấn
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
