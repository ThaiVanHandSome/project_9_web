package hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hcmute.model.CategoryModel;
import hcmute.model.ProductModel;

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
	public void insert(ProductModel model) {
		String sql ="INSERT INTO PRODUCT(productName, description, price, imageLink, categoryID, sellerID, amount, stoke) values(?,?,?,?,?,?,?)";
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, model.getProductName());
			ps.setString(2, model.getDescription());
			ps.setInt(3, model.getPrice());
			ps.setString(4, model.getImageLink());
			ps.setInt(5, model.getCategory().getCateID());
			ps.setInt(6, model.getSellerID());
			ps.setInt(7, model.getAmount());
			ps.setInt(8, model.getStoke());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProductModel model) {
		String sql ="UPDTAE PRODUCT SET productName=?, description=?, price=?, imageLink=?, categoryID=?, sellerID=?, amount=?, stoke=? WHERE productID = ?";
		try {
			Connection conn = new DBConnectionSqlServer().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, model.getProductName());
			ps.setString(2, model.getDescription());
			ps.setInt(3, model.getPrice());
			ps.setString(4, model.getImageLink());
			ps.setInt(5, model.getCategory().getCateID());
			ps.setInt(6, model.getSellerID());
			ps.setInt(7, model.getAmount());
			ps.setInt(8, model.getStoke());
			ps.setInt(9, model.getProductID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ProductModel findOne(int ProductID) {
		String sql ="SELECT * FROM PRODUCT WHERE productID = ?";
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

	
	
	
	
	
	
	
	
	
	
	

	
	
}
