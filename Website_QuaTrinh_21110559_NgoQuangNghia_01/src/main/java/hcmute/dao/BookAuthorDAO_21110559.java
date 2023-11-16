package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hcmute.entity.AuthorEntity_21110559;
import hcmute.entity.BookAuthorEntity_21110559;
import hcmute.entity.BooksEntity_21110559;

public class BookAuthorDAO_21110559 extends AbstractDAO_21110559<BookAuthorEntity_21110559>{
	public List<BooksEntity_21110559> findBookByBookAuthor(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.book FROM BookAuthorEntity_21110559 o WHERE o.author.authorID = :author";
	    TypedQuery<BooksEntity_21110559> query = entitymanager.createQuery(jpql, BooksEntity_21110559.class);
	    query.setParameter("author", id); 
	    List<BooksEntity_21110559> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
	public List<AuthorEntity_21110559> findAuthorByBooksAuthor(int id) {
	    entitymanager.getTransaction().begin();
	    String jpql = "SELECT o.author FROM BookAuthorEntity_21110559 o WHERE o.author.authorID = :author";
	    TypedQuery<AuthorEntity_21110559> query = entitymanager.createQuery(jpql, AuthorEntity_21110559.class);
	    query.setParameter("author", id); 
	    List<AuthorEntity_21110559> list = query.getResultList();
	    entitymanager.getTransaction().commit();
	    return list;
	}
}
