package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.models.CategoryModel;
import hcmute.models.ProductModel;

public class ProductDAOImpl implements IProductDAO{
	iCategoryDAO cateDAO = new CategoryDAOImpl();
	@Override
	public List<ProductModel> findAll() {
		String sql ="SELECT * FROM Product";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductModel model = new ProductModel();
				model.setProductID(rs.getInt(1));
				model.setProductName(rs.getString(2));
				model.setDescription(rs.getString(3));
				model.setPrice(rs.getInt(4));
				model.setImageLink(rs.getString(5));
				model.setCategoryID(rs.getInt(6));
				model.setSellerID(rs.getInt(7));
				model.setAmount(rs.getInt(8));
				model.setStoke(rs.getInt(9));
				list.add(model);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductModel> findProductByCategory(int categoryID) {
		String sql ="SELECT * FROM Product where CategoryID=?";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CategoryModel model1 = cateDAO.findOne(rs.getInt("CategoryID"));
				ProductModel model = new ProductModel();
				model.setProductID(rs.getInt(1));
				model.setProductName(rs.getString(2));
				model.setDescription(rs.getString(3));
				model.setPrice(rs.getInt(4));
				model.setImageLink(rs.getString(5));
				model.setCategoryID(model1.getCateID());
				model.setSellerID(rs.getInt(7));
				model.setAmount(rs.getInt(8));
				model.setStoke(rs.getInt(9));
				list.add(model);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	
	@Override
	public ProductModel findOne(int ProductID) {
		String sql ="SELECT * FROM PRODUCT WHERE ProductID = ?";
		ProductModel model = new ProductModel();
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ProductID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CategoryModel model1 = cateDAO.findOne(rs.getInt("CategoryID"));
				model.setProductID(rs.getInt("ProductID"));
				model.setProductName(rs.getString("ProductName"));
				model.setDescription(rs.getString("Description"));
				model.setPrice(rs.getInt("price"));
				model.setImageLink(rs.getString("imageLink"));
				model.setCategoryID(model1.getCateID());
				model.setSellerID(rs.getInt("sellerID"));
				model.setAmount(rs.getInt("amount"));
				model.setStoke(rs.getInt("stoke"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@Override
	public int countByCategoryID(int id) {
		String sql ="SELECT COUNT(*) FROM Product WHERE CategoryID=?";
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<ProductModel> count() {
		String sql ="SELECT categoryID, COUNT(*) as count FROM Product GROUP BY categoryID Order by count DESC";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getInt(2)));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	

	
	
}
