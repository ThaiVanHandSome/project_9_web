package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hcmute.entity.AuthorEntity;
import hcmute.entity.BookAuthorEntity;
import hcmute.entity.BooksEntity;

public class BookAuthorDAO extends AbstractDAO<BookAuthorEntity>{
	public List<BooksEntity> findBookByBookAuthor(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.book FROM BookAuthorEntity o WHERE o.author.authorID = :author";
	    TypedQuery<BooksEntity> query = entitymanager.createQuery(jpql, BooksEntity.class);
	    query.setParameter("author", id); 
	    List<BooksEntity> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
	
	public List<AuthorEntity> findAuthorByBooksAuthor(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.author FROM BookAuthorEntity o WHERE o.author.authorID = :author";
	    TypedQuery<AuthorEntity> query = entitymanager.createQuery(jpql, AuthorEntity.class);
	    query.setParameter("author", id); 
	    List<AuthorEntity> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
}
