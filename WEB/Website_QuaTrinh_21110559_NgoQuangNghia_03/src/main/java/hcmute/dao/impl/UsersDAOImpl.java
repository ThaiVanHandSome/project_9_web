package hcmute.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.dao.IUsersDAO;
import hcmute.entity.UsersEntity;

public class UsersDAOImpl implements IUsersDAO {

	@Override
	public List<UsersEntity> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<UsersEntity> query = em.createNamedQuery("users.findAll", UsersEntity.class);
        return query.getResultList();
	}

	@Override
	public void insert(UsersEntity usersEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(usersEntity);
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
	public void edit(UsersEntity usersEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(usersEntity);
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
			UsersEntity usersEntity = em.find(UsersEntity.class, id);
			if(usersEntity!=null) {
				em.remove(usersEntity);
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
	public UsersEntity findById(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		UsersEntity usersEntity = em.find(UsersEntity.class, id);
		return usersEntity;
	}

}
