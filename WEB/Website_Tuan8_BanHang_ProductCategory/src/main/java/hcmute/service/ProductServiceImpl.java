package hcmute.service;

import java.util.List;

import hcmute.dao.IProductDAO;
import hcmute.dao.ProductDAOImpl;
import hcmute.model.CategoryModel;
import hcmute.model.ProductModel;

public class ProductServiceImpl implements IProductService{
	IProductDAO productDao = new ProductDAOImpl();
	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}

	@Override
	public List<ProductModel> findProductByCategory(int categoryID) {
		return productDao.findProductByCategory(categoryID);
	}
}
