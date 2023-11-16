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
	@Override
	public void insert(CategoryModel model) {
		cateDAO.insert(model);
	}
	@Override
	public void update(CategoryModel model) {
		//Lấy giá trị từ view và chuyển nó sang csdl
		CategoryModel newModel = cateDAO.findOne(model.getCateID());
		newModel.setCateID(model.getCateID());
		newModel.setCateName(model.getCateName());
		newModel.setImages(model.getImages());
		cateDAO.update(newModel);
	}
	@Override
	public void delete(int id) {
		cateDAO.delete(id);
	}
	@Override
	public CategoryModel findOne(int id) {
		return cateDAO.findOne(id);
	}
	
}
