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
				cate.setId(rs.getInt("CategoryID"));
				cate.setName(rs.getString("CategoryName"));
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
				model.setId(rs.getInt(1));
				model.setName(rs.getNString(2));
				model.setImages(rs.getNString(3));
			}
			conn.close();
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
