package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.model.CategoryModel;

public class CategoryDAOImpl implements iCategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM Category";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel cate = new CategoryModel();
				cate.setCateID(rs.getInt("CategoryID"));
				cate.setCateName(rs.getString("CategoryName"));
				cate.setImages(rs.getString("icon"));
				list.add(cate);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public CategoryModel findOne(int CategoryID) {
		String sql = "SELECT * FROM Category WHERE Category.CategoryID=?";
		
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, CategoryID);
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
		String sql = "INSERT INTO Category(CategoryName, icon) values(?,?)";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, model.getCateName());
			ps.setString(2, model.getImages());
			rs = ps.executeQuery();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel model) {
	    String sql = "UPDATE Category SET CategoryName = ?, icon = ? WHERE CategoryID = ?";
	    try {
	        conn = new DBConnectionSqlServer().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, model.getCateName());
	        ps.setString(2, model.getImages());
	        ps.setInt(3, model.getCateID()); 
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
	
	public void delete(int CategoryID) {
		String sql = "DELETE FROM Category WHERE CategoryID=?";
		try {
			conn = new DBConnectionSqlServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, CategoryID);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
