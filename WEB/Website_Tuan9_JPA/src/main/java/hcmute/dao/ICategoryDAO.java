package hcmute.dao;

import java.util.List;

import hcmute.entity.CategoryEntity;
public interface ICategoryDAO {
	List<CategoryEntity> findAll();
	void insert(CategoryEntity entity); 
	void update(CategoryEntity entity);
	void delete(int CategoryID) throws Exception;
	CategoryEntity findOne(int CategoryID);
}
