package hcmute.service;

import java.util.List;

import hcmute.dao.CategoryDAOImpl;
import hcmute.dao.ICategoryDAO;
import hcmute.entity.CategoryEntity;

public class CategoryServiceImpl implements ICategoryService {
	ICategoryDAO cateDAO = new CategoryDAOImpl();

	@Override
	public List<CategoryEntity> findAll() {
		return cateDAO.findAll();
	}

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
	public CategoryEntity findOne(int CategoryID) {
		return cateDAO.findOne(CategoryID);
	}
	
}
