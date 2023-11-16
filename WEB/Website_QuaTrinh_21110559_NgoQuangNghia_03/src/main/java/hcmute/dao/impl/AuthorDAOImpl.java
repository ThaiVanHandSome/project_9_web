package hcmute.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.dao.IAuthorDAO;
import hcmute.entity.AuthorEntity;

public class AuthorDAOImpl implements IAuthorDAO{
	protected EntityManager entitymanager = JPAConfig.getEntityManager();
	EntityTransaction transaction = entitymanager.getTransaction();
	@Override
	public List<AuthorEntity> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<AuthorEntity> query = em.createNamedQuery("author.findAll", AuthorEntity.class);
        return query.getResultList();
	}

	@Override
	public void insert(AuthorEntity authorEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(authorEntity);
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
	public void update(AuthorEntity authorEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(authorEntity);
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
	public void delete(int authorid) throws Exception {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			AuthorEntity authorEntity = em.find(AuthorEntity.class, authorid);
			if(authorEntity!=null) {
				em.remove(authorEntity);
			}
			trans.commit();
		}
		catch(Exception e){
			throw new Exception("NOT FOUND");
		}finally {
			em.close();
		}
	}

	@Override
	public AuthorEntity findById(int authorid) {
		EntityManager em = JPAConfig.getEntityManager();
		AuthorEntity category = em.find(AuthorEntity.class, authorid);
		return category;
	}

}
