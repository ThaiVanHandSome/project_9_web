package hcmute.service;

import java.util.List;

import hcmute.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCategory(int categoryID);
	ProductModel findOne(int ProductID);
	int countByCategoryID(int id);
	List<ProductModel> count();
}
