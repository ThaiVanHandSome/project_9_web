package hcmute.service;

import java.util.List;

import hcmute.dao.IProductDAO;
import hcmute.dao.ProductDAOImpl;
import hcmute.models.CategoryModel;
import hcmute.models.ProductModel;

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

	@Override
	public ProductModel findOne(int ProductID) {
		return productDao.findOne(ProductID);
	}

	@Override
	public int countByCategoryID(int id) {
		return productDao.countByCategoryID(id);
	}

	@Override
	public List<ProductModel> count() {
		return productDao.count();
	}
}
