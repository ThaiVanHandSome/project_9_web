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

	@Override
	public void insert(ProductModel model) {
		productDao.insert(model);
	}

	@Override
	public void update(ProductModel model) {
		ProductModel newModel = productDao.findOne(model.getProductID());
		newModel.setProductName(model.getProductName());
		newModel.setDescription(model.getDescription());
		newModel.setPrice(model.getPrice());
		newModel.setImageLink(model.getImageLink());
		newModel.setCategoryID(model.getCategoryID());
		newModel.setSellerID(model.getSellerID());
		newModel.setAmount(model.getAmount());
		newModel.setStoke(model.getStoke());
		productDao.update(model);
	}

	@Override
	public ProductModel findOne(int ProductID) {
		return productDao.findOne(ProductID);
	}

	
}
