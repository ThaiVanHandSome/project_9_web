package hcmute.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.entity.CategoryEntity;
public class CategoryDAOImpl implements ICategoryDAO{
	protected EntityManager entitymanager = JPAConfig.getEntityManager();
	EntityTransaction transaction = entitymanager.getTransaction();

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
			trans.commit();
		}
		catch(Exception e){
			throw new Exception("NOT FOUND");
		}finally {
			em.close();
		}
	}
	public List<CategoryEntity> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<CategoryEntity> query = em.createNamedQuery("Category.findAll", CategoryEntity.class);
        return query.getResultList();
	}

	public CategoryEntity findById(int CategoryID) {
		EntityManager em = JPAConfig.getEntityManager();
		CategoryEntity category = em.find(CategoryEntity.class, CategoryID);
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
