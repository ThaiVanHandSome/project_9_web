package hcmute.dao;

import java.util.List;

import hcmute.entity.CategoryEntity;
public interface ICategoryDAO {
	void insert(CategoryEntity entity); 
	void update(CategoryEntity entity);
	void delete(int CategoryID) throws Exception;
	List<CategoryEntity> findAll();
	CategoryEntity findById(int CategoryID);
	List<CategoryEntity> findCategoryName(String CategoryName);
	List<CategoryEntity> findAll(int page, int pagesize);
	int count();
}
