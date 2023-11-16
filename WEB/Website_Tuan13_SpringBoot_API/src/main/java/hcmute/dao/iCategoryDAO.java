package hcmute.dao;

import java.util.List;

import hcmute.model.CategoryModel;

//PHẦN ĐỂ KHAI BÁO CÁC HÀM XỬ LÝ
public interface iCategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel findOne(int CategoryID);
}
