package hcmute.service;

import java.util.List;

import hcmute.model.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	List<ProductModel> findProductByCategory(int categoryID);
	
}
