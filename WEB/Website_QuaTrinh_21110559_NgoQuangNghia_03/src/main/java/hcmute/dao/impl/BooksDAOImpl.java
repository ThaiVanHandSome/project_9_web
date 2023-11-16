package hcmute.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.dao.IBooksDAO;
import hcmute.entity.BooksEntity;
import hcmute.entity.BooksEntity;

public class BooksDAOImpl implements IBooksDAO{
	protected EntityManager entitymanager = JPAConfig.getEntityManager();
	EntityTransaction transaction = entitymanager.getTransaction();
	@Override
	public List<BooksEntity> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<BooksEntity> query = em.createNamedQuery("books.findAll", BooksEntity.class);
        return query.getResultList();
	}

	@Override
	public void insert(BooksEntity booksEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(booksEntity);
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
	public void update(BooksEntity booksEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(booksEntity);
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
	public void delete(int bookid) throws Exception {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			BooksEntity booksEntity = em.find(BooksEntity.class, bookid);
			if(booksEntity!=null) {
				em.remove(booksEntity);
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
	public BooksEntity findById(int bookid) {
		EntityManager em = JPAConfig.getEntityManager();
		BooksEntity booksEntity = em.find(BooksEntity.class, bookid);
		return booksEntity;
	}
}
