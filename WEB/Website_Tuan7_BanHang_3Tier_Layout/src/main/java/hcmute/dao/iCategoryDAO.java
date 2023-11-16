package hcmute.dao;

import java.util.List;

import hcmute.models.CategoryModel;

//PHẦN ĐỂ KHAI BÁO CÁC HÀM XỬ LÝ
public interface iCategoryDAO {
	List<CategoryModel> findAll();
	void insert(CategoryModel model); 
	void update(CategoryModel model);
	void delete(int id);
	CategoryModel findOne(int id);
}
