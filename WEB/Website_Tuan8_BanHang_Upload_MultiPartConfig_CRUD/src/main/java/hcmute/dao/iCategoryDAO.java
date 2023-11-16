package hcmute.dao;

import java.util.List;

import hcmute.model.CategoryModel;

//PHẦN ĐỂ KHAI BÁO CÁC HÀM XỬ LÝ
public interface iCategoryDAO {
	List<CategoryModel> findAll();
	void insert(CategoryModel model); 
	void update(CategoryModel model);
	void delete(int CategoryID);
	CategoryModel findOne(int CategoryID);
}
