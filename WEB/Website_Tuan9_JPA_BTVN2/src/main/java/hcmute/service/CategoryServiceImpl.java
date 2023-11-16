package hcmute.service;

import java.util.List;

import hcmute.dao.CategoryDAOImpl;
import hcmute.dao.ICategoryDAO;
import hcmute.entity.CategoryEntity;

public class CategoryServiceImpl implements ICategoryService {
	ICategoryDAO cateDAO = new CategoryDAOImpl();

	@Override
	public void insert(CategoryEntity entity) {
		 cateDAO.insert(entity);
	}

	@Override
	public void update(CategoryEntity entity) {
		 cateDAO.update(entity);
	}

	@Override
	public void delete(int CategoryID) throws Exception {
		 cateDAO.delete(CategoryID);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return cateDAO.findAll();
	}

	@Override
	public CategoryEntity findById(int CategoryID) {
		return cateDAO.findById(CategoryID);
	}

	@Override
	public List<CategoryEntity> findCategoryName(String CategoryName) {
		return cateDAO.findCategoryName(CategoryName);
	}

	@Override
	public List<CategoryEntity> findAll(int page, int pagesize) {
		return cateDAO.findAll();
	}

	@Override
	public int count() {
		return cateDAO.count();
	}
}
