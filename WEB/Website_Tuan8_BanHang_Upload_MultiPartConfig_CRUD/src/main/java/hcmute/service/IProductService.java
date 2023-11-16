package hcmute.service;

import java.util.List;

import hcmute.model.CategoryModel;
import hcmute.model.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCategory(int categoryID);
	void insert(ProductModel model);
	void update(ProductModel model);
	ProductModel findOne(int ProductID);
}
