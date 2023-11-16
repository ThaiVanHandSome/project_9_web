package hcmute.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import JPAConfig.JPAConfig;
import hcmute.dao.IBookAuthorDAO;
import hcmute.entity.BookAuthorEntity;

public class BookAuthorDAOImpl implements IBookAuthorDAO{
	protected EntityManager entitymanager = JPAConfig.getEntityManager();
	EntityTransaction transaction = entitymanager.getTransaction();
	@Override
	public List<BookAuthorEntity> findAll() {
		EntityManager em = JPAConfig.getEntityManager();
		TypedQuery<BookAuthorEntity> query = em.createNamedQuery("book_author.findAll", BookAuthorEntity.class);
        return query.getResultList();
	}

	@Override
	public void insert(BookAuthorEntity bookAuthorEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(bookAuthorEntity);
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
	public void edit(BookAuthorEntity bookAuthorEntity) {
		EntityManager em = JPAConfig.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(bookAuthorEntity);
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
			BookAuthorEntity bookAuthorEntity = em.find(BookAuthorEntity.class, id);
			if(bookAuthorEntity!=null) {
				em.remove(bookAuthorEntity);
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
	public BookAuthorEntity findById(int id) {
		EntityManager em = JPAConfig.getEntityManager();
		BookAuthorEntity bookAuthorEntity = em.find(BookAuthorEntity.class, id);
		return bookAuthorEntity;
	}
}
