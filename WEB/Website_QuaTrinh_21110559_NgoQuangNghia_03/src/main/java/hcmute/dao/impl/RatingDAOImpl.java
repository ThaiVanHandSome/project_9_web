package hcmute.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.dao.IRatingDAO;
import hcmute.entity.RatingEntity;

public class RatingDAOImpl implements IRatingDAO {

	@Override
	public List<RatingEntity> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<RatingEntity> query = em.createNamedQuery("rating.findAll", RatingEntity.class);
        return query.getResultList();
	}

	@Override
	public void insert(RatingEntity ratingEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(ratingEntity);
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
	public void edit(RatingEntity ratingEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(ratingEntity);
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
	public void delete(int id) throws Exception {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			RatingEntity ratingEntity = em.find(RatingEntity.class, id);
			if(ratingEntity!=null) {
				em.remove(ratingEntity);
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
	public RatingEntity findById(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		RatingEntity ratingEntity = em.find(RatingEntity.class, id);
		return ratingEntity;
	}

}
