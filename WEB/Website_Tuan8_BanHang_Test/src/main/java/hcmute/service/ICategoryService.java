package hcmute.service;

import java.util.List;

import hcmute.models.CategoryModel;

public interface ICategoryService {
	//định nghĩa phương thức
	List<CategoryModel> findAll();
}
