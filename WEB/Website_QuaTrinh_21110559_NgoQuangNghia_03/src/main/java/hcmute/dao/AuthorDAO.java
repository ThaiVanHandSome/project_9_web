package hcmute.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import hcmute.entity.AuthorEntity;

public class AuthorDAO extends AbstractDAO<AuthorEntity>{
	public Long countAll() {
	    entitymanager.getTransaction().begin();
		TypedQuery<Long> count = entitymanager.createQuery("select count(o) from AuthorEntity o", Long.class);
	    entitymanager.getTransaction().commit();
		return count.getSingleResult();
	}
	public List<AuthorEntity> paginationPage(int index, int numberOfPage) {
	    entitymanager.getTransaction().begin();
	    TypedQuery<AuthorEntity> query = entitymanager.createQuery("select o from AuthorEntity o", AuthorEntity.class);
	    List<AuthorEntity> author = query.getResultList();
	    entitymanager.getTransaction().commit();

	    int startIndex = index * numberOfPage;
	    int endIndex = Math.min(startIndex + numberOfPage, author.size());

	    return author.subList(startIndex, endIndex);
	}
}
