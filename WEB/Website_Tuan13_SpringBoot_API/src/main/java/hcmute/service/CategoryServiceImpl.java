package hcmute.service;

import java.util.List;

import hcmute.dao.CategoryDAOImpl;
import hcmute.dao.iCategoryDAO;
import hcmute.models.CategoryModel;

public class CategoryServiceImpl implements ICategoryService{
	//Khởi tạo đối tượng trong DAO
	iCategoryDAO cateDAO = new CategoryDAOImpl();
	@Override
	public List<CategoryModel> findAll() {
		return cateDAO.findAll();
	}
}
