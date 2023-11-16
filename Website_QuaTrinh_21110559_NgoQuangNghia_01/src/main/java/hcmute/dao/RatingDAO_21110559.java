package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;


import hcmute.entity.BooksEntity_21110559;
import hcmute.entity.RatingEntity_21110559;
import hcmute.entity.UsersEntity_21110559;

public class RatingDAO_21110559 extends AbstractDAO_21110559<RatingEntity_21110559>{
	public List<UsersEntity_21110559> findUserByRating(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.user FROM RatingEntity_21110559 o WHERE o.book.bookid = :book";
	    TypedQuery<UsersEntity_21110559> query = entitymanager.createQuery(jpql, UsersEntity_21110559.class);
	    query.setParameter("book", id); 
	    List<UsersEntity_21110559> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
	public List<BooksEntity_21110559> findBookByRating(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.book FROM RatingEntity_21110559 o WHERE o.book.bookid = :book";
	    TypedQuery<BooksEntity_21110559> query = entitymanager.createQuery(jpql, BooksEntity_21110559.class);
	    query.setParameter("book", id); 
	    List<BooksEntity_21110559> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
	public List<Long> count(int id) {
	    String jpql = "SELECT count(review_text) FROM RatingEntity_21110559 o WHERE o.book.bookid = :book";
	    TypedQuery<Long> query = entitymanager.createQuery(jpql, Long.class);
	    query.setParameter("book", id);
	    List<Long> list = query.getResultList();
	    return list;
	}
	
	public List<String> findReviewTextByRating(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.review_text FROM RatingEntity_21110559 o WHERE o.book.bookid = :book";
	    TypedQuery<String> query = entitymanager.createQuery(jpql, String.class);
	    query.setParameter("book", id); 
	    List<String> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}

}
