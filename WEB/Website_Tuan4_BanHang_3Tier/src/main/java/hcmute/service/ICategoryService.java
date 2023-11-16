package hcmute.service;

import java.util.List;

import hcmute.models.CategoryModel;

public interface ICategoryService {
	//định nghĩa phương thức
	List<CategoryModel> findAll();
	void insert(CategoryModel model);
	void update(CategoryModel model);
	void delete(int id);
	CategoryModel findOne(int id);
}
