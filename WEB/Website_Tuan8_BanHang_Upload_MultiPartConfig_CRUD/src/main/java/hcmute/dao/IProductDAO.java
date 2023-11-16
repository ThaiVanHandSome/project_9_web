package hcmute.dao;

import java.util.List;

import hcmute.model.ProductModel;


public interface IProductDAO {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCategory(int categoryID);
	void insert(ProductModel model);
	void update(ProductModel model);
	ProductModel findOne(int ProductID);
}
