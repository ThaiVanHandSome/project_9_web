package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hcmute.entity.BooksEntity_21110559;

public class BookDAO_21110559 extends AbstractDAO_21110559<BooksEntity_21110559>{
	public Long countAll() {
	    entitymanager.getTransaction().begin();
		TypedQuery<Long> count = entitymanager.createQuery("select count(o) from BooksEntity_21110559 o", Long.class);
	    entitymanager.getTransaction().commit();
		return count.getSingleResult();
	}
	public List<BooksEntity_21110559> paginationPage(int index, int numberOfPage) {
	    entitymanager.getTransaction().begin();
	    TypedQuery<BooksEntity_21110559> query = entitymanager.createQuery("select o from BooksEntity_21110559 o", BooksEntity_21110559.class);
	    List<BooksEntity_21110559> allBooks = query.getResultList();
	    entitymanager.getTransaction().commit();

	    int startIndex = index * numberOfPage;
	    int endIndex = Math.min(startIndex + numberOfPage, allBooks.size());

	    return allBooks.subList(startIndex, endIndex);
	}

}
