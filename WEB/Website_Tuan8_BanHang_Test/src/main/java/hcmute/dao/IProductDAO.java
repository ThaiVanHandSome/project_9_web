package hcmute.dao;

import java.util.List;

import hcmute.models.ProductModel;


public interface IProductDAO {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCategory(int categoryID);
	ProductModel findOne(int ProductID);

	int countByCategoryID(int id);
	List<ProductModel> count();
}
