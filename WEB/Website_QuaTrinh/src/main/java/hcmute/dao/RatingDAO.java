package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;


import hcmute.entity.BooksEntity;
import hcmute.entity.RatingEntity;
import hcmute.entity.UsersEntity;

public class RatingDAO extends AbstractDAO<RatingEntity>{
	public List<BooksEntity> findBookByRating(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.book FROM RatingEntity o WHERE o.user.id = :user";
	    TypedQuery<BooksEntity> query = entitymanager.createQuery(jpql, BooksEntity.class);
	    query.setParameter("user", id); 
	    List<BooksEntity> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
	public List<UsersEntity> findUserByRating(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.user FROM RatingEntity o WHERE o.user.id = :user";
	    TypedQuery<UsersEntity> query = entitymanager.createQuery(jpql, UsersEntity.class);
	    query.setParameter("user", id); 
	    List<UsersEntity> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
}
