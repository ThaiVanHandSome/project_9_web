package hcmute.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import JPAConfig.JPAConfig;
import hcmute.entity.CategoryEntity;

public class CategoryDAOImpl implements ICategoryDAO{

	@Override
	public List<CategoryEntity> findAll() {
		return null;
	}

	@Override
	public void insert(CategoryEntity entity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
	}

	@Override
	public void update(CategoryEntity entity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(entity);
			trans.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			em.close();
		}
	}

	@Override
	public void delete(int CategoryID) throws Exception {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			CategoryEntity category = em.find(CategoryEntity.class, CategoryID);
			if(category!=null) {
				em.remove(category);
			}
		}
		catch(Exception e){
			throw new Exception("NOT FOUND");
		}finally {
			em.close();
		}
	}

	@Override
	public CategoryEntity findOne(int CategoryID) {
		return null;
	}
	
}
