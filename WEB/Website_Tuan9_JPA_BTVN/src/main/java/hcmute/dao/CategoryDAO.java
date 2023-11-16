package hcmute.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.CategoryEntity;
public class CategoryDAO{
	protected EntityManager entitymanager = JPAConfig.getEntityManager();
	EntityTransaction transaction = entitymanager.getTransaction();

	public void insert(CategoryEntity entity) {
	    try {
	        transaction.begin();
	        entitymanager.persist(entity);
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        transaction.rollback();
	        throw e;
	    } finally {
	        entitymanager.close();
	    }
	}


	public void update(CategoryEntity entity) {
		try {
			transaction.begin();
			entitymanager.merge(entity);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}finally {
			entitymanager.close();
		}
	}

	public void delete(int CategoryID) throws Exception {
		try {
			transaction.begin();
			CategoryEntity category = entitymanager.find(CategoryEntity.class, CategoryID);
			entitymanager.remove(category);
			transaction.commit();
		}
		catch(Exception e){
			throw new Exception("NOT FOUND");
		}finally {
			entitymanager.close();
		}
	}

	public List<CategoryEntity> findAll() {
		TypedQuery<CategoryEntity> query = entitymanager.createNamedQuery("Category.findAll", CategoryEntity.class);
        return query.getResultList();
	}

	public CategoryEntity findById(int CategoryID) {
		CategoryEntity category = entitymanager.find(CategoryEntity.class, CategoryID);
		return category;
	}

	public List<CategoryEntity> findCategoryName(String CategoryName) {
		String jpql = "SELECT c FROM Category c WHERE c.CategoryName like :CategoryName";
		TypedQuery<CategoryEntity> query = entitymanager.createQuery(jpql, CategoryEntity.class);
		return query.getResultList();
	}

	public List<CategoryEntity> findAll(int page, int pagesize) {
		TypedQuery<CategoryEntity> query = entitymanager.createNamedQuery("Category.findAll", CategoryEntity.class);
        query.setFirstResult(page*pagesize);
        query.setMaxResults(pagesize);
		return query.getResultList();
	}

	public int count() {
		String jpql ="SELECT count(c) FROM Category c";
		Query query = entitymanager.createQuery(jpql);
		return (((Long) query.getSingleResult()).intValue());
	}
}
